package ayds.dictionary.alpha.View;

import android.content.Context;

public class SearchItemViewModule {

    private static SearchItemViewModule instance;
    private Context context;

    private SearchItemViewModule() {

    }

    public static SearchItemViewModule getInstance() {
        if (instance == null) {
            instance = new SearchItemViewModule();
        }
        return instance;
    }

    void setContext(Context context) {

        this.context = context;
    }

    public Context getContext(){
        return context;
    }


}
