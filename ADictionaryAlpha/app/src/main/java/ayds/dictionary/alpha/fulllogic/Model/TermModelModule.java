package ayds.dictionary.alpha.fulllogic.Model;

public class TermModelModule {

        private static TermModelModule instance;
        private TermModel termModel;

        private TermModelModule() {
            termModel =  new TermModelImpl();
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
    
}
