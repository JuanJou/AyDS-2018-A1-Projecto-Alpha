package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.List;
import java.util.Map;

import ayds.dictionary.alpha.Model.Source;

public class ServiceListImpl {

    private List<Source> listServices;
    private Map<Source,ServiceAdapter> mapServices;


    public ServiceListImpl(List<Source> listServices){
        this.listServices = listServices;
    }


    public List<Source> getSources(){

        return listServices;
    }

    public String getTerm(String term, Source source){

        return mapServices.get(source).getTerm(term);
    }
}
