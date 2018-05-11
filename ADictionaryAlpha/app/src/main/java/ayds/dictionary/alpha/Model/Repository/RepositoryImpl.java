package ayds.dictionary.alpha.Model.Repository;

import java.io.IOException;
import java.net.UnknownHostException;

import DataWikipedia.DataWikipedia;
import ayds.dictionary.alpha.Model.DataBase.DataBaseTerm;
import ayds.dictionary.alpha.Model.Exceptions.NoConnectionException;
import ayds.dictionary.alpha.Model.Exceptions.NoResultException;
import ayds.dictionary.alpha.Model.Exceptions.NotWellFormedException;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.alpha.Model.Term;

class RepositoryImpl implements Repository {

    private DataBaseTerm dataBaseTerm;
    private DataWikipedia wikiApi;
    private FormatChecker checker;


    RepositoryImpl(DataBaseTerm bd, DataWikipedia wiki, FormatChecker checker) {

        this.dataBaseTerm = bd;
        this.wikiApi = wiki;
        this.checker = checker;

        bd.connect();
        wiki.connect();
    }

    public Term getDefinition(String name) throws Exception{

        Source source = Source.Wikipedia;

        if (checker.isWellFormed(name)) {
            String definition=searchInService(name);
            Term finalTerm=new Term(name);
            finalTerm.setDefinition(definition);
            finalTerm.setSource(source);
            return finalTerm;
        } else {
            throw new NotWellFormedException();
        }
    }

    private String searchInService(String name) throws Exception{
        String definition;

        definition = dataBaseTerm.getMeaning(name);

        if (definition != null) {
            definition = "[*]" + definition;
        } else {
            try {
                definition = wikiApi.getMeaning(name);
                if (definition == null) {
                    throw new NoResultException();
                }

            } catch (UnknownHostException e) {
                throw new NoConnectionException();
            } catch (IOException e) {
                e.printStackTrace();
            }

            dataBaseTerm.saveTerm(name, definition);
        }
        return definition;
    }
}