package ayds.dictionary.alpha.Model.Repository;

import DataWikipedia.DataWikipediaModule;
import ayds.dictionary.alpha.Model.DataBase.DataBaseModule;

public class RepositoryModule {

    private Repository repository;
    private static RepositoryModule instance;

    private RepositoryModule(){

        DataBaseModule dataBaseModule = DataBaseModule.getInstance();
        DataWikipediaModule dataWikipedia = DataWikipediaModule.getInstance();
        FormatChecker checker=new FormatCheckerLetters();

        repository = new RepositoryImpl(dataBaseModule.getDataBaseTerm(), dataWikipedia.getDataWikipedia(),checker);
    }

    public static RepositoryModule getInstance(){
        if(instance == null){
            instance = new RepositoryModule();
        }
        return instance;
    }

    public Repository getRepository(){
        return repository;
    }
}
