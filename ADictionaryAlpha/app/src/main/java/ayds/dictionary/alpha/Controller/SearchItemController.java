package ayds.dictionary.alpha.Controller;

import ayds.dictionary.alpha.View.SearchItemView;

public interface SearchItemController {

    void onEventSearch(String term);

    void setSearchItemView(SearchItemView view);

}
