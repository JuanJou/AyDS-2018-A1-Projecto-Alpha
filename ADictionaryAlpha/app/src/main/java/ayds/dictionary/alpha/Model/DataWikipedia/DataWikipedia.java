package ayds.dictionary.alpha.Model.DataWikipedia;

import java.io.IOException;

public interface DataWikipedia {

    String getMeaning(String term) throws IOException;

    void connect();
}
