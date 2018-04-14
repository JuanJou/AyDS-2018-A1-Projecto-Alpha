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

            String definicion = TransformadorJSON.transformarDefinicionWikiAPI(respuesta);

            return definicion;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void conectar(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        wiki=retrofit.create(WikipediaAPI.class);
    }

}
