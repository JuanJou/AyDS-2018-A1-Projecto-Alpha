package ayds.dictionary.alpha.Model.DataBase;

public interface DataBaseTerm {

    String getMeaning(String term, String source);

    void connect();

    void saveTerm(String term, String meaning, String source);

}
