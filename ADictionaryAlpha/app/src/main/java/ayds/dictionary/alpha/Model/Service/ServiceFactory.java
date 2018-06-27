package ayds.dictionary.alpha.Model.Service;

import java.util.Map;

import ayds.dictionary.alpha.Model.Source;

public interface ServiceFactory {

    Map<Source,ServiceAdapter> getServices();
}
