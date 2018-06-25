package ayds.dictionary.alpha.Model.Repository.Service;

import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import ayds.dictionary.foxtrot.services.YandexService;


public class ServiceYandexAdapter implements ServiceAdapter {

    private YandexService yandexAPI;

    public ServiceYandexAdapter(YandexService yandexAPI){

        this.yandexAPI = yandexAPI;
    }

    @Override
    public String getTerm(String term) throws IOException, SAXException, ParserConfigurationException {

        String ret = null;
        ret = yandexAPI.getMeaning(term);

        return ret;
    }
}
