package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.HashMap;
import java.util.Map;

import ayds.dictionary.alpha.Model.Source;

public class ServiceListModule {

    private ServiceList serviceList;
    private static ServiceListModule instance;


    private ServiceListModule(){

        Map<String,ServiceAdapter> mapSourceService = new HashMap<>();
        ServiceAdapter serviceWikipedia = new ServiceWikiAdapter();
        mapSourceService.put("Wikipedia",serviceWikipedia);
        ServiceAdapter serviceBHL       = new ServiceBHLAdapter();
        mapSourceService.put("bigHugeLabs",serviceBHL);
        ServiceAdapter serviceYandex       = new ServiceYandexAdapter();
        mapSourceService.put("Yandex",serviceYandex);

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
