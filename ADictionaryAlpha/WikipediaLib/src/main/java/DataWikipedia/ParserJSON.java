package DataWikipedia;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;

class ParserJSON implements Parser {

    @Override
    public String parserDefinition(String responseWikipedia) {
        JsonElement elementJSON = getElement(responseWikipedia);

        if (elementJSON == null || elementJSON.getAsString().equals("")) {
            return null;
        } else {
            return elementJSON.getAsString().replace("\\n", "\n");
        }
    }

    private JsonElement getElement(String responseWikipedia) {
        Gson gson = new Gson();
        JsonObject jobj = gson.fromJson(responseWikipedia, JsonObject.class);
        JsonElement query = jobj.get("query");
        JsonObject queryJSON=query.getAsJsonObject();
        JsonElement pages = queryJSON.get("pages");
        if (pages==null)
            return null;
        JsonObject pagesJSON=pages.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> pagesSet = pagesJSON.entrySet();
        Map.Entry<String, JsonElement> first = pagesSet.iterator().next();
        JsonObject page = first.getValue().getAsJsonObject();
        JsonElement extract = page.get("extract");
        return extract;
    }
}