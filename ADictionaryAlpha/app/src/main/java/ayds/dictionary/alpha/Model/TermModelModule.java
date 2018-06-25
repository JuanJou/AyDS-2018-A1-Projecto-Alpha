package ayds.dictionary.alpha.Model;

import ayds.dictionary.alpha.Model.Exceptions.ErrorHandler;
import ayds.dictionary.alpha.Model.Exceptions.ErrorHandlerModule;
import ayds.dictionary.alpha.Model.Repository.RepositoryModule;


public class TermModelModule {

    private static TermModelModule instance;
    private TermModel termModel;

    private TermModelModule() {

        RepositoryModule repositoryModule = RepositoryModule.getInstance();

        termModel = new TermModelImpl(repositoryModule.getRepository());
    }

    public static TermModelModule getInstance() {
        if (instance == null) {
            instance = new TermModelModule();
        }
        return instance;
    }

    public TermModel getTermModel() {
        return termModel;
    }

}
