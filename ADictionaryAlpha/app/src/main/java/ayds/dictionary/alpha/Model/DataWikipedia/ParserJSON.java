package ayds.dictionary.alpha.Model.DataWikipedia;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;

class ParserJSON implements Parser {

    @Override
    public String parserDefinition(String responseWikipedia) {
        JsonElement elementJSON = getElement(responseWikipedia);

        if (elementJSON == null) {
            return "No hay resultados";
        } else {
            return elementJSON.getAsString().replace("\\n", "\n");
        }
    }

    private JsonElement getElement(String responseWikipedia) {
        Gson gson = new Gson();
        JsonObject jobj = gson.fromJson(responseWikipedia, JsonObject.class);
        JsonObject query = jobj.get("query").getAsJsonObject();
        JsonObject pages = query.get("pages").getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> pagesSet = pages.entrySet();
        Map.Entry<String, JsonElement> first = pagesSet.iterator().next();
        JsonObject page = first.getValue().getAsJsonObject();
        JsonElement extract = page.get("extract");
        return extract;
    }
}