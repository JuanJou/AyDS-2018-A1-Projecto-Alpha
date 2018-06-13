package ayds.dictionary.alpha.Model.DataBase;

import android.arch.persistence.room.Room;
import android.content.Context;

import ayds.dictionary.alpha.Model.DataBase.room.ConceptDataBase;
import ayds.dictionary.alpha.Model.DataBase.room.Concept;
import ayds.dictionary.alpha.Model.Source;


class DataBaseTermImpl implements DataBaseTerm {

    private Context context;
    private ConceptDataBase db;

    DataBaseTermImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getMeaning(String term,Source source) {

        Concept concept = db.termDao().findByNameAndSource(term,source.name());

        if (concept != null) {
            return concept.getMeaning();
        }
        return null;
    }

    @Override
    public void connect() {

        db = Room.databaseBuilder(context,
                ConceptDataBase.class, "database.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();

    }

    @Override
    public void saveTerm(String term, String meaning, Source source) {
        Concept concept = new Concept();
        concept.setTerm(term);
        concept.setMeaning(meaning);
        concept.setSource(source.name());
        db.termDao().insert(concept);
    }
}
