package ayds.dictionary.alpha.Model.Repository.Service;

import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import services.Service;


public class ServiceYandexAdapter implements ServiceAdapter {

    private Service yandexAPI;

    public ServiceYandexAdapter(Service yandexAPI){

        this.yandexAPI = yandexAPI;
    }

    @Override
    public String getTerm(String term) {

        String ret = null;

        try {
            ret = yandexAPI.getMeaning(term);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
