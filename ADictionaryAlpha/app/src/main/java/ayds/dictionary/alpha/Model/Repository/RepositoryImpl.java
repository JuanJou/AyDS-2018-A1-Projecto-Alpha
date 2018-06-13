package ayds.dictionary.alpha.Model.Repository;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import DataWikipedia.DataWikipedia;
import ayds.dictionary.alpha.Model.DataBase.DataBaseTerm;
import ayds.dictionary.alpha.Model.Exceptions.NoConnectionException;
import ayds.dictionary.alpha.Model.Exceptions.NoResultException;
import ayds.dictionary.alpha.Model.Exceptions.NotWellFormedException;
import ayds.dictionary.alpha.Model.Repository.Service.ServiceList;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.alpha.Model.Term;

class RepositoryImpl implements Repository {

    private DataBaseTerm dataBaseTerm;
    private ServiceList serviceList;
    private FormatChecker checker;


    RepositoryImpl(DataBaseTerm bd, FormatChecker checker, ServiceList serviceList) {

        this.dataBaseTerm = bd;
        this.serviceList = serviceList;
        this.checker = checker;

        bd.connect();
    }

    public List<Term> getDefinition(String name) throws Exception{

        if (checker.isWellFormed(name)) {
            return searchInService(name);
        } else {
            throw new NotWellFormedException();
        }
    }

    private List<Term> searchInService(String name) throws Exception{

        String definition = null;

        List<Term> listTerm = new ArrayList<>();

        for(Source source : serviceList.getSources()) {

            definition = dataBaseTerm.getMeaning(name,source);

            if (definition != null) {
                definition = "[*]" + definition;
            } else {
                    definition = serviceList.getTerm(name,source);
                    if (definition == null) {
                        throw new NoResultException();
                    }


                dataBaseTerm.saveTerm(name, definition, source);
            }

            Term term = new Term(name);
            term.setDefinition(definition);
            term.setSource(source);

            listTerm.add(term);
        }
        return listTerm;
    }
}