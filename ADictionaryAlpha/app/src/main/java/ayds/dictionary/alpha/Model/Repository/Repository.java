package ayds.dictionary.alpha.Model.Repository;

import ayds.dictionary.alpha.Model.Exceptions.ErrorHandler;
import ayds.dictionary.alpha.Model.Term;

public interface Repository {

    Term getDefinition(String name) throws Exception;
}
