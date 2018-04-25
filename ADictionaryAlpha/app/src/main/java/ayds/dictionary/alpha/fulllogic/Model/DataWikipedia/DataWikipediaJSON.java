package ayds.dictionary.alpha.fulllogic.Model;

import java.io.IOException;

import ayds.dictionary.alpha.fulllogic.Model.DataBase.Data;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DataWikipediaJSON implements Data {

    protected WikipediaAPI wiki;

<<<<<<< HEAD:ADictionaryAlpha/app/src/main/java/ayds/dictionary/alpha/fulllogic/Model/DataWikipedia/DataWikipediaJSON.java
    public String obtenerDefinicion(String term) {
        Response<String> respuesta = null;
=======
    public DataWikipediaJSON(){

    }

    public String getDefinition(String term) {
        Response<String> response = null;
>>>>>>> 8de15e41bf32ccd736728b9164ccace6a73a8aa7:ADictionaryAlpha/app/src/main/java/ayds/dictionary/alpha/fulllogic/Model/DataWikipediaJSON.java
        try {
            response = wiki.getTerm(term).execute();

            String definition = JSONTransformer.transformDefinitionWikiAPI(response);

            return definition;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

<<<<<<< HEAD:ADictionaryAlpha/app/src/main/java/ayds/dictionary/alpha/fulllogic/Model/DataWikipedia/DataWikipediaJSON.java
    public void conectar() {
=======


    public void conect(){
>>>>>>> 8de15e41bf32ccd736728b9164ccace6a73a8aa7:ADictionaryAlpha/app/src/main/java/ayds/dictionary/alpha/fulllogic/Model/DataWikipediaJSON.java
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        wiki = retrofit.create(WikipediaAPI.class);
    }

}
