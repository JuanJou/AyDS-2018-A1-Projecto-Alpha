package ayds.dictionary.alpha.fulllogic.View;

import ayds.dictionary.alpha.fulllogic.Controller.SearchItemController;

public class ItemViewModule {

    private static ItemViewModule instance;

    private ItemViewModule() { }

    public static ItemViewModule getInstance() {
        if (instance == null) {
            instance = new ItemViewModule();
        }
        return instance;
    }

    public SearchItemView obtenerVista(SearchItemController searchItemController){
        SearchItemViewImpl searchItemView = new SearchItemViewImpl(searchItemController,
                TermModelModule.getInstance().getTermModel());

        return searchItemView;
    }

}
