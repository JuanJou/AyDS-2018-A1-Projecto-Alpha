package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

public class TermModelModule {

        private static TermModelModule instance;
        private TermModel termModel;

        private TermModelModule(Context context) {
            termModel =  new TermModelImpl(context);
        }

        public static TermModelModule getInstance(Context context) {
            if(instance == null) {
                instance =  new TermModelModule(context);
            }
            return instance;
        }

        public TermModel getTermModel() {
            return termModel;
        }
    
}
