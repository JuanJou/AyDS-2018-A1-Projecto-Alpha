package ayds.dictionary.alpha.Model.Repository.Service;

import java.io.IOException;
import java.text.Format;

import ayds.dictionary.alpha.Model.Exceptions.NoConnectionException;
import ayds.dictionary.alpha.Model.Exceptions.NotWellFormedException;
import ayds.dictionary.alpha.Model.Repository.FormatChecker;
import ayds.dictionary.foxtrot.services.YandexService;


public class ServiceYandexAdapter implements ServiceAdapter {

    private YandexService yandexAPI;
    private FormatChecker checker;

    public ServiceYandexAdapter(YandexService yandexAPI,FormatChecker checker){

        this.yandexAPI = yandexAPI;
        this.checker=checker;
    }

    @Override
    public String getTerm(String term) throws Exception {

        String ret = null;
        try{
            if (checker.isWellFormed(term))
                ret = yandexAPI.getMeaning(term);
            else
                throw new NotWellFormedException();
        }catch(IOException e){
            throw new NoConnectionException();
        }


        return ret;
    }
}
