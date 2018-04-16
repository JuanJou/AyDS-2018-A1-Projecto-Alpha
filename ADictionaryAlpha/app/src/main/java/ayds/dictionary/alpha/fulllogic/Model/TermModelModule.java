package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

import java.util.ArrayList;

public class TermModelModule {

        private static TermModelModule instance;
        private TermModel termModel;

        private TermModelModule(Context context)
        {
            Data wiki=new DataWikipediaJSON();
            DataConPersistencia bd=new BaseDeDatos(context);
            bd.conectar();
            wiki.conectar();
            Repositorio repo=new RepositorioImpl(context,bd,wiki);
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
