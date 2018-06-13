package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.Map;
import java.util.Set;
import ayds.dictionary.alpha.Model.Source;

public class ServiceListImpl implements ServiceList{

    private Map<Source,ServiceAdapter> mapServices;

    public ServiceListImpl(Map<Source,ServiceAdapter> mapServices){
        this.mapServices = mapServices;
    }

    @Override
    public Set<Source> getSources(){

        return mapServices.keySet();
    }

    @Override
    public String getTerm(String term, Source source){

        return mapServices.get(source).getTerm(term);
    }
}
