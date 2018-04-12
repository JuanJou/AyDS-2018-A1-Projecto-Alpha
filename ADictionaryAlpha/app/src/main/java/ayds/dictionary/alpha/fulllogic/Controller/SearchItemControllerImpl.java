package ayds.dictionary.alpha.fulllogic.Controller;

import ayds.dictionary.alpha.fulllogic.Model.TermModel;
import ayds.dictionary.alpha.fulllogic.View.SearchItemView;

class SearchItemControllerImpl implements SearchItemController {

  private TermModel termModel;
  private SearchItemView searchItemView;

  SearchItemControllerImpl(TermModel termModel) {
    this.termModel = termModel;
  }


  @Override public void setSearchItemView(SearchItemView searchItemView) {
    this.searchItemView = searchItemView;
  }

  @Override
  public void onEventSearch(String term) {
    termModel.updateTerm(term);
  }
}
