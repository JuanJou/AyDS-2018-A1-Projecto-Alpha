package ayds.dictionary.alpha.Model.Repository.Service;

import SearchService.SearchService;
import SearchService.SearchServiceModule;
import SearchService.ServiceNotReachableException;

public class ServiceBHLAdapter implements ServiceAdapter{

    private SearchService searchService;

    public ServiceBHLAdapter(){
        searchService = SearchServiceModule.getInstance().getSearchService();
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
