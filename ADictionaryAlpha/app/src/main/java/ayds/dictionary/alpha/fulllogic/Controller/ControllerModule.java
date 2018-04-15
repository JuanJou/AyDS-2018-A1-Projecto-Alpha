package ayds.dictionary.alpha.fulllogic.Controller;

import android.content.Context;

import ayds.dictionary.alpha.fulllogic.Model.TermModelModule;

public class ControllerModule {

    private static ControllerModule instance;
    private SearchItemController searchItemController;

    private ControllerModule(Context context) {
        searchItemController = new SearchItemControllerImpl(TermModelModule.getInstance(context).getTermModel());
    }

    public static ControllerModule getInstance(Context context) {
        if (instance == null) {
            instance = new ControllerModule(context);
        }
        return instance;
    }

    public SearchItemController getSearchItemController() {
        return searchItemController;
    }

}
