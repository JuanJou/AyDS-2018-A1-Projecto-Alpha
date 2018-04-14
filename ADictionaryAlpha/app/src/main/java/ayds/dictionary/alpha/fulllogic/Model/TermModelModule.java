package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

public class TermModelModule {

        private static TermModelModule instance;
        private TermModel termModel;

        private TermModelModule(Context context)
        {
            Servicio s=new ServicioWikipediaJSON();
            Repositorio repo=new RepositorioImpl(context,s);
            termModel =  new TermModelImpl(repo);
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
