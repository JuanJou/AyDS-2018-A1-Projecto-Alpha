package ayds.dictionary.alpha.Model.Repository.Service;

import java.util.Map;
import java.util.Set;

import ayds.dictionary.alpha.Model.Source;

public interface ServiceFactory {

    Map<Source,ServiceAdapter> getServices();
}
