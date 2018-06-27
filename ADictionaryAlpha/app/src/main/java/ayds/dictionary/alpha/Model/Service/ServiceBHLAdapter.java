package ayds.dictionary.alpha.Model.Service;

import SearchService.SearchService;
import SearchService.ServiceNotReachableException;
import ayds.dictionary.alpha.Model.Exceptions.NoConnectionException;
import ayds.dictionary.alpha.Model.Exceptions.NoResultException;
import ayds.dictionary.alpha.Model.Exceptions.NotWellFormedException;
import ayds.dictionary.alpha.Model.Repository.FormatChecker;

class ServiceBHLAdapter implements ServiceAdapter{

    private SearchService searchService;
    private FormatChecker checker;

    public ServiceBHLAdapter(SearchService searchService,FormatChecker checker){
        this.searchService = searchService;
        this.checker=checker;
    }

    public String getTerm(String term) throws Exception {

        String ret = null;
        try{
            if (checker.isWellFormed(term)){
                ret = searchService.searchTerm(term);
                if (ret.equals("")){
                    throw new NoResultException();
                }
            }
            else
                throw new NotWellFormedException();
        }catch(ServiceNotReachableException e){
            throw new NoConnectionException();
        }

        return ret;
    }
}
