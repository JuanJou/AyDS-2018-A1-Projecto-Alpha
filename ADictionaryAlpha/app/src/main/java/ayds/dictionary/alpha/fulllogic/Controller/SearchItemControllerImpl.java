package controller;

import Model.TermModel;
import View.SearchItemView;

class SearchItemControllerImpl implements SearchItemController {

  private TermModel termModel;
  private SearchItemView searchItemView;

  SearchItemControllerImpl(TermModel termModel) {
    this.termModel = termModel;
  }

  @Override public void onSearchUpdate(String term) {

    termModel.updateTerm(term);

  }

  @Override public void setSearchItemView(SearchTermView searchItemView) {
    this.searchItemView = searchItemView;
  }
}
