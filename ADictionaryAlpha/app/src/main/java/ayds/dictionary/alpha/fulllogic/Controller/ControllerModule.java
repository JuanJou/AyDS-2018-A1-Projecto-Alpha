package controller;

import Model.TermModel;
import View.SearchItemView;
import View.ItemViewModule;

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

        EditUserView view = openEditUserWindowAndGetView(controller);

        controller.setEditUserView(view);
    }

    private SearchItemController getSearchItemController() {
        return new SearchItemControllerImpl(TermModelModule.getInstance().getTermModel());
    }

    private EditUserView openEditUserWindowAndGetView(SearchItemController searchUserController) {
        return ItemViewModule.getInstance().obtenerVista(searchItemController);
    }
}
