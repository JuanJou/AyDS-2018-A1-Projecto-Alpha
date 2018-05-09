package ayds.dictionary.alpha.Model.DataBase;

import android.arch.persistence.room.Room;
import android.content.Context;

import ayds.dictionary.alpha.Model.DataBase.room.ConceptDataBase;
import ayds.dictionary.alpha.Model.DataBase.room.Concept;


class DataBaseTermImpl implements DataBaseTerm {

    private Context context;
    private ConceptDataBase db;

    DataBaseTermImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getMeaning(String term) {

        Concept concept = db.termDao().findByName(term);

        if (concept != null) {
            return concept.getMeaning();
        }
        return null;
    }

    @Override
    public void connect() {

        db = Room.databaseBuilder(context,
                ConceptDataBase.class, "dictionary.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();

    }

    public void saveTerm(String term, String meaning) {
        Concept concept = new Concept();
        concept.setTerm(term);
        concept.setMeaning(meaning);
        concept.setSource(1);
        db.termDao().insert(concept);
    }
}
