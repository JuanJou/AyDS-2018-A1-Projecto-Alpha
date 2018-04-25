package ayds.dictionary.alpha.Controller;

import ayds.dictionary.alpha.Model.TermModel;
import ayds.dictionary.alpha.View.SearchItemView;

class SearchItemControllerImpl implements SearchItemController {

    private TermModel termModel;
    private SearchItemView searchItemView;

    SearchItemControllerImpl(TermModel termModel) {
        this.termModel = termModel;
    }


    @Override
    public void setSearchItemView(SearchItemView searchItemView) {
        this.searchItemView = searchItemView;
    }

    @Override
    public void onEventSearch(String term) {
        termModel.updateTerm(term);
    }
}
