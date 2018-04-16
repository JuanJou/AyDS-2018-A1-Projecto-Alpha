package ayds.dictionary.alpha.fulllogic.Model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

import ayds.dictionary.alpha.fulllogic.room.ConceptDataBase;


public class BaseDeDatos implements DataConPersistencia {

    private Context context;
    private ConceptDataBase db;


    public BaseDeDatos(Context context) {
        this.context = context;
    }

    @Override
    public String obtenerDefinicion(String term) {

        Term concept = db.termDao().findByName(term);

        if (concept != null) {
            return concept.getDefinicion();
        }
        return null;

    }

    @Override
    public void conectar() {

        db = Room.databaseBuilder(context,
                ConceptDataBase.class, "dictionary.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();

    }

    public void guardarTermino(Term termino) {

        Term concept = new Term();
        concept.setNombre(termino.getNombre());
        concept.setDefinicion(termino.getDefinicion());
        concept.setSource(1);
        db.termDao().insert(concept);
    }
}
