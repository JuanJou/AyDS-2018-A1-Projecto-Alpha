package ayds.dictionary.alpha.Model.Repository.Service;

import java.io.IOException;
import DataWikipedia.DataWikipedia;
import DataWikipedia.DataWikipediaModule;

public class ServiceWikiAdapter implements ServiceAdapter{

    private DataWikipedia serviceWikipedia;

    public ServiceWikiAdapter(){

        serviceWikipedia = DataWikipediaModule.getInstance().getDataWikipedia();
        serviceWikipedia.connect();
    }

    @Override
    public String getTerm(String term) {

        String ret = null;
        try {
            ret = serviceWikipedia.getMeaning(term);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
