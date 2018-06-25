package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.HashMap;
import java.util.Map;

import DataWikipedia.DataWikipedia;
import SearchService.SearchService;
import ayds.dictionary.alpha.Model.Repository.FormatCheckerLetters;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.foxtrot.services.YandexService;

public class ServiceFactoryImpl implements ServiceFactory{

    Map<Source,ServiceAdapter> mapSourceService;

    public ServiceFactoryImpl(DataWikipedia dataWikipedia, SearchService searchService, YandexService serviceY){

        mapSourceService = new HashMap<>();
        ServiceAdapter serviceWikipedia = new ServiceWikiAdapter(dataWikipedia,new FormatCheckerLetters());
        mapSourceService.put(Source.Wikipedia,serviceWikipedia);
        ServiceAdapter serviceBHL       = new ServiceBHLAdapter(searchService);
        mapSourceService.put(Source.bigHugeLabs,serviceBHL);
        ServiceAdapter serviceYandex       = new ServiceYandexAdapter(serviceY);
        mapSourceService.put(Source.Yandex,serviceYandex);
    }

    @Override
    public Map<Source, ServiceAdapter> getServices() {
        return mapSourceService;
    }
}
