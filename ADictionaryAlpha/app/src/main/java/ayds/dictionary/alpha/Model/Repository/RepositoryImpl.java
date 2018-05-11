package ayds.dictionary.alpha.Model.Repository;

import java.io.IOException;
import java.net.UnknownHostException;

import ayds.dictionary.alpha.Model.DataBase.DataBaseTerm;
import ayds.dictionary.alpha.Model.DataWikipedia.DataWikipedia;
import ayds.dictionary.alpha.Model.ErrorHandler;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.alpha.Model.Term;

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

    public Term getDefinition(String name) {

        if (checker.isWellFormed(name)) {
            String definition;
            Source source = Source.Wikipedia;

            definition = dataBaseTerm.getMeaning(name);

            if (definition != null) {
                source = Source.DataBase;
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
            Term finalTerm=new Term(name);
            finalTerm.setDefinition(definition);
            finalTerm.setSource(source);
            return finalTerm;
        } else {
            errorHandler.inputNotWellFormed();
            return null;
        }
    }

    public void setErrorHandler(ErrorHandler listener) {
        errorHandler = listener;
    }
}