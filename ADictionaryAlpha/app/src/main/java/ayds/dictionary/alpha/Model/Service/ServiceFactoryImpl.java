package ayds.dictionary.alpha.Model.Service;

import java.util.HashMap;
import java.util.Map;

import DataWikipedia.DataWikipedia;
import SearchService.SearchService;
import ayds.dictionary.alpha.Model.Repository.FormatCheckerLetters;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.foxtrot.services.YandexService;

class ServiceFactoryImpl implements ServiceFactory{

    Map<Source,ServiceAdapter> mapSourceService;

    public ServiceFactoryImpl(DataWikipedia dataWikipedia, SearchService searchService, YandexService serviceY){

        mapSourceService = new HashMap<>();

        ServiceAdapter serviceWikipedia = new ServiceWikiAdapter(dataWikipedia,new FormatCheckerLetters());
        ServiceAdapter serviceBHL       = new ServiceBHLAdapter(searchService,new FormatCheckerLetters());
        ServiceAdapter serviceYandex    = new ServiceYandexAdapter(serviceY,new FormatCheckerLetters());

        mapSourceService.put(Source.Yandex,serviceYandex);
        mapSourceService.put(Source.bigHugeLabs,serviceBHL);
        mapSourceService.put(Source.Wikipedia,serviceWikipedia);
    }

    @Override
    public Map<Source, ServiceAdapter> getServices() {
        return mapSourceService;
    }
}
