package ayds.dictionary.alpha.fulllogic.Model;

import android.arch.persistence.room.Room;
import android.content.Context;

import ayds.dictionary.alpha.fulllogic.room.ConceptDataBase;


public class DataBase implements PersistentData {

    private Context context;
    private ConceptDataBase db;


    public DataBase(Context context) {
        this.context = context;
    }

    @Override
    public String getDefinition(String term) {

        Term concept = db.termDao().findByName(term);
        if (concept != null) {
            return concept.getDefinition();
        }
        return null;

    }

    @Override
    public void conect() {

        db = Room.databaseBuilder(context,
                ConceptDataBase.class, "dictionary.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();

    }

    public void saveTerm(Term term) {

        Term concept = new Term();
        concept.setName(term.getName());
        concept.setDefinition(term.getDefinition());
        concept.setSource(1);
        db.termDao().insert(concept);
    }
}
