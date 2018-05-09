package ayds.dictionary.alpha.Model.DataBase;

import ayds.dictionary.alpha.View.SearchItemViewModule;

public class DataBaseModule {

    private static DataBaseModule instance;
    private DataBaseTerm dataBaseTerm;

    private DataBaseModule(){

        dataBaseTerm = new DataBaseTermImpl(SearchItemViewModule.getInstance().getContext());
    }

    public static DataBaseModule getInstance(){
        if(instance == null){
            instance = new DataBaseModule();
        }
        return instance;
    }

    public DataBaseTerm getDataBaseTerm(){
        return dataBaseTerm;
    }
}
