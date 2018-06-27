package ayds.dictionary.alpha.Model.Service;

import java.util.Set;
import ayds.dictionary.alpha.Model.Source;

public interface ServiceList {

    Set<Source> getSources();
    String getTerm(String term, Source source) throws Exception;
}