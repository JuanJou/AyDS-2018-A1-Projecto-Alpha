package ayds.dictionary.alpha.Model.DataBase.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Concept.class}, version = 2)
public abstract class ConceptDataBase extends RoomDatabase {
    public abstract ConceptDao termDao();
}
