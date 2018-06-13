package ayds.dictionary.alpha.Model.Repository.Service;

import SearchService.SearchService;
import SearchService.ServiceNotReachableException;

public class ServiceBHLAdapter implements ServiceAdapter{

    private SearchService searchService;

    public ServiceBHLAdapter(SearchService searchService){
        this.searchService = searchService;
    }

    public String getTerm(String term){

        String ret = null;
        try {
            ret = searchService.searchTerm(term);
        } catch (ServiceNotReachableException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
