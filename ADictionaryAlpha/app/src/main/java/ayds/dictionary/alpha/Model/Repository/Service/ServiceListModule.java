package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.HashMap;
import java.util.Map;

import ayds.dictionary.alpha.Model.Source;

public class ServiceListModule {

    private ServiceList serviceList;
    private static ServiceListModule instance;


    private ServiceListModule(){

        Map<Source,ServiceAdapter> mapSourceService = new HashMap<>();
        ServiceAdapter serviceWikipedia = new ServiceWikiAdapter();
        mapSourceService.put(Source.Wikipedia,serviceWikipedia);
        ServiceAdapter serviceBHL       = new ServiceBHLAdapter();
        mapSourceService.put(Source.bigHugeLabs,serviceBHL);
        ServiceAdapter serviceYandex       = new ServiceYandexAdapter();
        mapSourceService.put(Source.Yandex,serviceYandex);

        serviceList = new ServiceListImpl(mapSourceService);
    }

    public static ServiceListModule getInstance(){
        if(instance == null){
            instance = new ServiceListModule();
        }
        return instance;
    }

    public ServiceList getServiceList(){

        return serviceList;
    }

}
