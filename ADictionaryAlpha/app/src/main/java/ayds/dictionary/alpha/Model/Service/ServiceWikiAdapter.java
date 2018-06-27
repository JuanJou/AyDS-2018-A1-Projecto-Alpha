package ayds.dictionary.alpha.Model.Service;

import java.io.IOException;
import DataWikipedia.DataWikipedia;
import ayds.dictionary.alpha.Model.Exceptions.NoConnectionException;
import ayds.dictionary.alpha.Model.Exceptions.NoResultException;
import ayds.dictionary.alpha.Model.Exceptions.NotWellFormedException;
import ayds.dictionary.alpha.Model.Repository.FormatChecker;


class ServiceWikiAdapter implements ServiceAdapter{

    private DataWikipedia serviceWikipedia;
    private FormatChecker  checker;

    public ServiceWikiAdapter(DataWikipedia serviceWikipedia, FormatChecker checker){

        this.serviceWikipedia = serviceWikipedia;
        this.checker=checker;
    }

    @Override
    public String getTerm(String term) throws Exception {

        String ret = null;
        try {
            if (checker.isWellFormed(term)) {
                ret = serviceWikipedia.getMeaning(term);
                if (ret == null)
                    throw new NoResultException();
            } else
                throw new NotWellFormedException();
        }catch(IOException e){
            throw new NoConnectionException();
        }
        return ret;
    }
}
