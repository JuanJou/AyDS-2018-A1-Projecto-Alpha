package ayds.dictionary.alpha.Model.Service;


import SearchService.SearchServiceModule;
import ayds.dictionary.foxtrot.services.YandexServiceModule;
import DataWikipedia.DataWikipediaModule;

public class ServiceListModule {

    private ServiceList serviceList;
    private static ServiceListModule instance;
    private ServiceFactory serviceFactory;


    private ServiceListModule(){




        serviceFactory = new ServiceFactoryImpl(
                DataWikipediaModule.getInstance().getDataWikipedia(),
                SearchServiceModule.getInstance().getSearchService(),
                YandexServiceModule.getInstance().getRemoteSource());

        serviceList = new ServiceListImpl(serviceFactory);
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
