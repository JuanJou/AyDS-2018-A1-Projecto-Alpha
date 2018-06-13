package ayds.dictionary.alpha.Model.DataBase;

import ayds.dictionary.alpha.Model.Source;

public interface DataBaseTerm {

    String getMeaning(String term, Source source);

    void connect();

    void saveTerm(String term, String meaning, Source source);

}
