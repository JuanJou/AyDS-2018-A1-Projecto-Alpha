package ayds.dictionary.alpha.Model;

import ayds.dictionary.alpha.Model.Exceptions.ErrorHandler;
import ayds.dictionary.alpha.Model.Exceptions.ErrorHandlerModule;
import ayds.dictionary.alpha.Model.Repository.Repository;

class TermModelImpl implements TermModel {

    private TermModelListener oyente;
    private Repository repo;
    private ErrorHandler errorHandler;

    TermModelImpl(Repository repo,ErrorHandler errorHandler) {
        this.repo = repo;
        this.errorHandler=errorHandler;
    }

    @Override
    public void updateTerm(String name) {
        try {
            oyente.didUpdateTerm(repo.getDefinition(name));
        }
        catch(Exception e){
           errorHandler.throwException(e);
        }
    }

    @Override
    public void setListener(TermModelListener listener) {
        oyente = listener;
    }
}
