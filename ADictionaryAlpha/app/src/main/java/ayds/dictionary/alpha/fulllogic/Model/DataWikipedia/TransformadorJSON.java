package ayds.dictionary.alpha.fulllogic.Model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Set;

import retrofit2.Response;

public class TransformadorJSON {

    public static String transformarDefinicionWikiAPI(Response<String> respuestaWikipedia){
       JsonElement elemento=obtenerElemento(respuestaWikipedia);

       if (elemento==null){
           return "No hay resultados";
       }
       else{
           return elemento.getAsString().replace("\\n", "\n");
       }
    }

    private static JsonElement obtenerElemento(Response<String> respuestaWikipedia){
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




}
