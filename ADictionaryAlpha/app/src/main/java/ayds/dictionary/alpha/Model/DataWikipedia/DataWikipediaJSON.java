package ayds.dictionary.alpha.Model.DataWikipedia;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DataWikipediaJSON implements DataWikipedia {

    protected WikipediaAPI wiki;
    private Parser parserResponse;

    DataWikipediaJSON(){

        parserResponse = new ParserJSON();
    }

    @Override
    public String getMeaning(String term) {

        Response<String> response;
        try {
            response = wiki.getTerm(term).execute();

            if (response==null)
                return "No hay respuesta";

            String definitionWiki = parserResponse.parserDefinition(response.body());

            return definitionWiki;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void connect() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        wiki = retrofit.create(WikipediaAPI.class);
    }

}
