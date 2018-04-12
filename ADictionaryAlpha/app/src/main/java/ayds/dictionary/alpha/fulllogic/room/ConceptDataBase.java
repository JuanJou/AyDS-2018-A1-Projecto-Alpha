package ayds.dictionary.alpha.fulllogic.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ayds.dictionary.alpha.fulllogic.Model.Term;

@Database(entities = {Term.class}, version = 1)
public abstract class ConceptDataBase extends RoomDatabase {
  public abstract ConceptDao termDao();
}
