package ayds.dictionary.alpha.fulllogic.Model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ServicioWikipediaJSON implements Servicio {

    protected WikipediaAPI wiki;

    public ServicioWikipediaJSON(){

    }

    public String obtenerDefinicion(String term) {
        Response<String> respuesta = null;
        try {
            respuesta = wiki.getTerm(term).execute();

            JsonElement json = transformarDefinicionWikiAPI(respuesta);

            if (json == null) {
                return "No Results";
            } else {
                return json.getAsString().replace("\\n", "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JsonElement transformarDefinicionWikiAPI(Response<String> respuestaWikipedia){
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

    public void conectar(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        wiki=retrofit.create(WikipediaAPI.class);
    }

}
