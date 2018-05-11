package ayds.dictionary.alpha.Model.Repository;

import ayds.dictionary.alpha.Model.ErrorHandler;
import ayds.dictionary.alpha.Model.Term;

public interface Repository {

    Term getDefinition(String name);

    void setErrorHandler(ErrorHandler listener);
}
