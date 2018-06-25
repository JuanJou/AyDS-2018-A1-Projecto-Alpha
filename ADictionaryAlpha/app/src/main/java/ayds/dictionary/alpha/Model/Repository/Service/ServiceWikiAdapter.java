package ayds.dictionary.alpha.Model.Repository.Service;

import java.io.IOException;
import DataWikipedia.DataWikipedia;
import ayds.dictionary.alpha.Model.Exceptions.NoResultException;
import ayds.dictionary.alpha.Model.Exceptions.NotWellFormedException;
import ayds.dictionary.alpha.Model.Repository.FormatChecker;


public class ServiceWikiAdapter implements ServiceAdapter{

    private DataWikipedia serviceWikipedia;
    private FormatChecker  checker;

    public ServiceWikiAdapter(DataWikipedia serviceWikipedia, FormatChecker checker){

        this.serviceWikipedia = serviceWikipedia;
        this.checker=checker;
    }

    @Override
    public String getTerm(String term) throws Exception {

        String ret = null;
        if (checker.isWellFormed(term)){
            ret = serviceWikipedia.getMeaning(term);
            if (ret==null)
                throw new NoResultException();
        }
        else
            throw new NotWellFormedException();
        return ret;
    }
}
