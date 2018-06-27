package ayds.dictionary.alpha.Model.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ayds.dictionary.alpha.Model.DataBase.DataBaseTerm;
import ayds.dictionary.alpha.Model.Exceptions.ErrorHandler;
import ayds.dictionary.alpha.Model.Service.ServiceList;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.alpha.Model.Term;

class RepositoryImpl implements Repository {

    private DataBaseTerm dataBaseTerm;
    private ServiceList serviceList;
    private ErrorHandler errorHandler;


    RepositoryImpl(DataBaseTerm bd, ServiceList serviceList,ErrorHandler errorHandler) {

        this.dataBaseTerm = bd;
        this.serviceList = serviceList;
        this.errorHandler=errorHandler;

        bd.connect();
    }

    public List<Term> getDefinition(String name){
            return searchInService(name);
    }

    private List<Term> searchInService(String name){

        String definition = null;

        List<Term> listTerm = new ArrayList<>();

        Map<Source,Exception> errores=new HashMap<>();

        for(Source source : serviceList.getSources()) {

            try{
                definition = dataBaseTerm.getMeaning(name,source);

                if (definition != null) {
                    definition = "[*]" + definition;
                } else {
                        definition = serviceList.getTerm(name,source);
                        dataBaseTerm.saveTerm(name, definition, source);
                }

                Term term = new Term(name);
                term.setDefinition(definition);
                term.setSource(source);

                listTerm.add(term);
            }
            catch(Exception e){
                errores.put(source,e);
            }
        }
        errorHandler.throwException(errores);
        return listTerm;
    }
}