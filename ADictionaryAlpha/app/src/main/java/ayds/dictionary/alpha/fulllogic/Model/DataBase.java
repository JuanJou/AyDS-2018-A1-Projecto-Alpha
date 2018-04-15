package ayds.dictionary.alpha.fulllogic.Model;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.util.List;

import ayds.dictionary.alpha.fulllogic.room.*;

public class DataBase {

  private static ConceptDataBase db;

  public static void createNewDatabase(Context context) {
    db = Room.databaseBuilder(context,
                              ConceptDataBase.class, "dictionary.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
  }

  public static void testDB() {

    List<Term> concepts = db.termDao().getAll();

    for (Term concept :
        concepts) {
      Log.e("**", "id =" + concept.getId());
      Log.e("**", "term =" + concept.getNombre());
      Log.e("**", "meaning =" + concept.getDefinicion());
      Log.e("**", "source =" + concept.getSource());

    }
  }

  public static void saveTerm(String term, String meaning) {
    Term concept =  new Term();
    concept.setNombre(term);
    concept.setDefinicion(meaning);
    concept.setSource(1);
    db.termDao().insert(concept);
  }

  public static String getMeaning(String term) {

    Term concept = db.termDao().findByName(term);

    if (concept != null) {
      return concept.getDefinicion();
    }
    return null;
  }

}
