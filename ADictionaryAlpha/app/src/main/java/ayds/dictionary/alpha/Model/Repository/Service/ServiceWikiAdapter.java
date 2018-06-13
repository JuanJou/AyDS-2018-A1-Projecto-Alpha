package ayds.dictionary.alpha.Model.Repository.Service;

import java.io.IOException;
import DataWikipedia.DataWikipedia;


public class ServiceWikiAdapter implements ServiceAdapter{

    private DataWikipedia serviceWikipedia;

    public ServiceWikiAdapter(DataWikipedia serviceWikipedia){

        this.serviceWikipedia = serviceWikipedia;
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
