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

public class DataWikipediaJSON implements Data {

    protected WikipediaAPI wiki;

    public DataWikipediaJSON(){

    }

    public String getDefinition(String term) {
        Response<String> response = null;
        try {
            response = wiki.getTerm(term).execute();

            String definition = JSONTransformer.transformDefinitionWikiAPI(response);

            return definition;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void conect(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        wiki=retrofit.create(WikipediaAPI.class);
    }

}
