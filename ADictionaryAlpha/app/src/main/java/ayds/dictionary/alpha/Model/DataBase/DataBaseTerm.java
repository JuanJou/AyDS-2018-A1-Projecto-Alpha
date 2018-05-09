package ayds.dictionary.alpha.Model.DataBase;

public interface DataBaseTerm {

    String getMeaning(String term);

    void connect();

    void saveTerm(String term, String meaning);

}
