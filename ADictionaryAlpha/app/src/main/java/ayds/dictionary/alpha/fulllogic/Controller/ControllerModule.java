package ayds.dictionary.alpha.fulllogic.Controller;

import ayds.dictionary.alpha.fulllogic.View.ItemViewModule;
import ayds.dictionary.alpha.fulllogic.Controller.SearchItemController;
import ayds.dictionary.alpha.fulllogic.Model.TermModelModule;
import ayds.dictionary.alpha.fulllogic.View.SearchItemView;

public class ControllerModule {

    private static ControllerModule instance;

    private ControllerModule() { }

    public static ControllerModule getInstance() {
        if (instance == null) {
            instance = new ControllerModule();
        }
        return instance;
    }

    void startApplication() {
        SearchItemController controller = getSearchItemController();

        SearchItemView view = openSearchItemWindowAndGetView(controller);

        controller.setSearchItemView(view);
    }

    private SearchItemController getSearchItemController() {
        return new SearchItemControllerImpl(TermModelModule.getInstance().getTermModel());
    }

    private SearchItemView openSearchItemWindowAndGetView(SearchItemController searchItemController) {
        return ItemViewModule.getInstance().obtenerVista(searchItemController);
    }
}
