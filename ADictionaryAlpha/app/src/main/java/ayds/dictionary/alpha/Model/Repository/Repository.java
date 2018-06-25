package ayds.dictionary.alpha.Model.Repository;

import java.util.List;
import ayds.dictionary.alpha.Model.Term;

public interface Repository {

    List<Term> getDefinition(String name);
}
