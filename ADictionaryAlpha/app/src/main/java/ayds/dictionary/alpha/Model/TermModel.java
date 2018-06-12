package ayds.dictionary.alpha.Model;


public interface TermModel {

    void updateTerm(String name);

    void setListener(TermModelListener listener);
}

