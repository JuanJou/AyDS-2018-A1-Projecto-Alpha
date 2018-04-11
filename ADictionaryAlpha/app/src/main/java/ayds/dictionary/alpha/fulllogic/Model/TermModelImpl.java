package ayds.dictionary.alpha.fulllogic.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class TermModelImpl implements TermModel {

    private Term terminoActual;
    private TermModelListener oyente;

    public TermModelImpl(){

    }

    @Override
    public void updateTerm(String nombre) {

        int source=2;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        final WikipediaAPI wikiAPI = retrofit.create(WikipediaAPI.class);

        String text = DataBase.getMeaning(nombre);

        if (text != null) { // exists in db
            source=1;
            text = "[*]" + text;
        } else {
            Response<String> callResponse;
            try {
                callResponse = wikiAPI.getTerm(nombre).execute();

                Log.e("**", "JSON: " + callResponse.body());


                //WikiAPI devuelve un JSON, aca lo formatea
                Gson gson = new Gson();
                JsonObject jobj = gson.fromJson(callResponse.body(), JsonObject.class);
                JsonObject query = jobj.get("query").getAsJsonObject();
                JsonObject pages = query.get("pages").getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> pagesSet = pages.entrySet();
                Map.Entry<String, JsonElement> first = pagesSet.iterator().next();
                JsonObject page = first.getValue().getAsJsonObject();
                JsonElement extract = page.get("extract");

                if (extract == null) {
                    text = "No Results";
                } else {
                    text = extract.getAsString().replace("\\n", "\n");
                    text = textToHtml(text, nombre);

                    // save to DB  <o/
                    DataBase.saveTerm(nombre, text);

                }
            }
            catch(IOException e1) {
                e1.printStackTrace();
            }
        }
        actualizarValoresTermino(text,source,nombre);
    }

    private void actualizarValoresTermino(String meaning, int source, String nombre) {
        terminoActual.setNombre(nombre);
        terminoActual.setSource(source);
        terminoActual.setDefinicion(meaning);
    }

    private JsonElement obtenerDefinicion(Response<String> respuestaWikipedia){
        Gson gson = new Gson();
        JsonObject jobj = gson.fromJson(respuestaWikipedia.body(), JsonObject.class);
        JsonObject query = jobj.get("query").getAsJsonObject();
        JsonObject pages = query.get("pages").getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> pagesSet = pages.entrySet();
        Map.Entry<String, JsonElement> first = pagesSet.iterator().next();
        JsonObject page = first.getValue().getAsJsonObject();
        JsonElement extract = page.get("extract");
        return extract;
    }


    public static String textToHtml(String text, String term) {

        StringBuilder builder = new StringBuilder();

        String textWithBold = text.replaceAll("(?i)" + term, "<b>" + term + "</b>");

        builder.append(textWithBold);

        return builder.toString();
    }

    @Override
    public void setListener(TermModelListener listener) {
        oyente=listener;
    }

    @Override
    public Term getTerm() {
        return terminoActual;
    }
}
