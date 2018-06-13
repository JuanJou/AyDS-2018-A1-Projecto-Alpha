package ayds.dictionary.alpha.Model.Repository.Service;


import java.util.Set;
import ayds.dictionary.alpha.Model.Source;

public class ServiceListImpl implements ServiceList{

    private ServiceFactory serviceFactory;

    public ServiceListImpl(ServiceFactory serviceFactory){
        this.serviceFactory = serviceFactory;
    }

    @Override
    public Set<Source> getSources(){

        return serviceFactory.getServices().keySet();
    }

    @Override
    public String getTerm(String term, Source source){

        return serviceFactory.getServices().get(source).getTerm(term);
    }
}
