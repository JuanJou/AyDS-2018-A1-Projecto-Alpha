package ayds.dictionary.alpha.Model;

import ayds.dictionary.alpha.Model.Exceptions.ErrorHandler;

public interface TermModel {

    void updateTerm(String name);

    void setListener(TermModelListener listener);
}

