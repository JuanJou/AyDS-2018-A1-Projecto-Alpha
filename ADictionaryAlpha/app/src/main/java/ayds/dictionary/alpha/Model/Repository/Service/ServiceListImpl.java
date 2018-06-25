package ayds.dictionary.alpha.Model.Repository.Service;


import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import SearchService.ServiceNotReachableException;
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
    public String getTerm(String term, Source source) throws Exception {

        return serviceFactory.getServices().get(source).getTerm(term);
    }
}
