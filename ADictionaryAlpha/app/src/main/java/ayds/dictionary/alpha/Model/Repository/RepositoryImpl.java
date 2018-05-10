package ayds.dictionary.alpha.Model.Repository;

import java.io.IOException;
import java.net.UnknownHostException;

import ayds.dictionary.alpha.Model.DataBase.DataBaseTerm;
import DataWikipedia.DataWikipedia;
import ayds.dictionary.alpha.Model.ErrorHandler;

class RepositoryImpl implements Repository {

    private DataBaseTerm dataBaseTerm;
    private DataWikipedia wikiApi;
    private FormatChecker checker;
    private ErrorHandler errorHandler;

    RepositoryImpl(DataBaseTerm bd, DataWikipedia wiki, FormatChecker checker) {

        this.dataBaseTerm = bd;
        this.wikiApi = wiki;
        this.checker = checker;

        bd.connect();
        wiki.connect();
    }

    public String getDefinition(String name) {

        if (checker.isWellFormed(name)) {
            String definition;
            int source = 2;

            definition = dataBaseTerm.getMeaning(name);

            if (definition != null) {
                source = 1;
                definition = "[*]" + definition;
            } else {

                try {
                    definition = wikiApi.getMeaning(name);
                    if (definition == null) {
                        errorHandler.noResult();
                    }

                } catch (UnknownHostException e) {
                    errorHandler.noConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dataBaseTerm.saveTerm(name, definition);
            }

            return definition;
        } else {
            errorHandler.inputNotWellFormed();
            return null;
        }
    }

    public void setErrorHandler(ErrorHandler listener) {
        errorHandler = listener;
    }
}