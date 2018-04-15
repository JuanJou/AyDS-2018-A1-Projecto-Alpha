package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

import java.util.ArrayList;

public class TermModelModule {

        private static TermModelModule instance;
        private TermModel termModel;

        private TermModelModule(Context context)
        {
            Servicio wiki=new ServicioWikipediaJSON();
            Servicio bd=new BaseDeDatos(context);
            ArrayList<Servicio> servs=new ArrayList<Servicio>();
            servs.add(bd);
            servs.add(wiki);
            Repositorio repo=new RepositorioImpl(context,servs);
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
