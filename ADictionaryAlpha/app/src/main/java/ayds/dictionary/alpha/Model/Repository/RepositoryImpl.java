package ayds.dictionary.alpha.Model.Repository;

import ayds.dictionary.alpha.Model.DataBase.DataBaseTerm;
import ayds.dictionary.alpha.Model.DataWikipedia.DataWikipedia;

class RepositoryImpl implements Repository {

    private DataBaseTerm dataBaseTerm;
    private DataWikipedia wikiApi;

    RepositoryImpl(DataBaseTerm bd, DataWikipedia wiki) {
        this.dataBaseTerm = bd;
        this.wikiApi = wiki;

        bd.connect();
        wiki.connect();
    }

    public String getDefinition(String name) {

        String definition;
        int source = 2;

        definition = dataBaseTerm.getMeaning(name);

        if (definition != null) {
            source = 1;
            definition = "[*]" + definition;
        } else {
            definition = wikiApi.getMeaning(name);
        }

        return definition;
    }

}

