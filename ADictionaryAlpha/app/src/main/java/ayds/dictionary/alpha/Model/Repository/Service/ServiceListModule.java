package ayds.dictionary.alpha.Model.Repository.Service;


import SearchService.SearchServiceModule;
import services.ServiceModule;
import DataWikipedia.DataWikipediaModule;

public class ServiceListModule {

    private ServiceList serviceList;
    private static ServiceListModule instance;
    private ServiceFactory serviceFactory;


    private ServiceListModule(){




        serviceFactory = new ServiceFactoryImpl(
                DataWikipediaModule.getInstance().getDataWikipedia(),
                SearchServiceModule.getInstance().getSearchService(),
                ServiceModule.getInstance().getRemoteSource());

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
