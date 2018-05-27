package DataWikipedia;

public class DataWikipediaModule {

    private static DataWikipediaModule instance;
    private DataWikipedia dataWikipedia;

    private DataWikipediaModule(){
        dataWikipedia = new DataWikipediaJSON();
    }

    public static DataWikipediaModule getInstance(){

        if(instance == null){
            instance = new DataWikipediaModule();
        }
        return instance;
    }

    public DataWikipedia getDataWikipedia(){
        return dataWikipedia;
    }
}
