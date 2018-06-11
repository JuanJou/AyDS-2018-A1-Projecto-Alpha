package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.List;

import ayds.dictionary.alpha.Model.Source;

public interface ServiceList {

    List<Source> getSources();
    String getTerm(String term, Source source);
}