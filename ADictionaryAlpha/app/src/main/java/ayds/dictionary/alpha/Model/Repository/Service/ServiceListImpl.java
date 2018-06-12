package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.Map;
import java.util.Set;
import ayds.dictionary.alpha.Model.Source;

public class ServiceListImpl implements ServiceList{

    private Map<String,ServiceAdapter> mapServices;

    public ServiceListImpl(Map<String,ServiceAdapter> mapServices){
        this.mapServices = mapServices;
    }

    @Override
    public Set<String> getSources(){

        return mapServices.keySet();
    }

    @Override
    public String getTerm(String term, String source){

        return mapServices.get(source).getTerm(term);
    }
}
