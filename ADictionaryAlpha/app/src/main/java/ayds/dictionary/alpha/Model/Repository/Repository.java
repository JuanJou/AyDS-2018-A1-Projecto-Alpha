package ayds.dictionary.alpha.Model.Repository;

import ayds.dictionary.alpha.Model.ErrorHandler;

public interface Repository {

    String getDefinition(String name);

    void setErrorHandler(ErrorHandler listener);
}
