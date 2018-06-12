package ayds.dictionary.alpha.Model.Repository;

import ayds.dictionary.alpha.Model.DataBase.DataBaseModule;
import ayds.dictionary.alpha.Model.Repository.Service.ServiceListModule;

public class RepositoryModule {

    private Repository repository;
    private static RepositoryModule instance;

    private RepositoryModule(){

        DataBaseModule dataBaseModule = DataBaseModule.getInstance();
        FormatChecker checker=new FormatCheckerLetters();

        repository = new RepositoryImpl(dataBaseModule.getDataBaseTerm(),checker, ServiceListModule.getInstance().getServiceList());
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
