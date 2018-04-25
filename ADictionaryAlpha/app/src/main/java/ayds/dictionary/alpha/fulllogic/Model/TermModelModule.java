package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;


public class TermModelModule {

        private static TermModelModule instance;
        private TermModel termModel;
        private static Context context;

        private TermModelModule()
        {
            Data wiki=new DataWikipediaJSON();
            PersistentData bd=new DataBase(context);
            bd.conect();
            wiki.conect();
            Repository repo=new RepositoryImpl(bd,wiki);
            termModel =  new TermModelImpl(repo);
        }

        public static TermModelModule getInstance() {
            if(instance == null) {
                instance =  new TermModelModule();
            }
            return instance;
        }

        public TermModel getTermModel() {
            return termModel;
        }

        public static void setContext(Context cont){
            context=cont;
        }
}
