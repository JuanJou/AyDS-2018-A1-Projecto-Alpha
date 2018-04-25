package ayds.dictionary.alpha.fulllogic.Model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Set;

import retrofit2.Response;

public class JSONTransformer {

    public static String transformDefinitionWikiAPI(Response<String> wikipediaResponse){
       JsonElement element=getElement(wikipediaResponse);

       if (element==null){
           return "No hay resultados";
       }
       else{
           return element.getAsString().replace("\\n", "\n");
       }
    }

    private static JsonElement getElement(Response<String> wikipediaResponse){
        Gson gson = new Gson();
        JsonObject jobj = gson.fromJson(wikipediaResponse.body(), JsonObject.class);
        JsonObject query = jobj.get("query").getAsJsonObject();
        JsonObject pages = query.get("pages").getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> pagesSet = pages.entrySet();
        Map.Entry<String, JsonElement> first = pagesSet.iterator().next();
        JsonObject page = first.getValue().getAsJsonObject();
        JsonElement extract = page.get("extract");
        return extract;
    }




}
