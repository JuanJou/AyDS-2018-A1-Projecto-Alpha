package ayds.dictionary.alpha.Model.DataBase.room;

import android.arch.persistence.room.*;

import java.util.List;

import ayds.dictionary.alpha.Model.Source;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ConceptDao {

    @Query("SELECT * FROM Concept")
    List<Concept> getAll();

    @Query("SELECT * FROM Concept WHERE term LIKE :term AND source LIKE :source LIMIT 1")
    Concept findByNameAndSource(String term, String source);

    @Insert(onConflict = REPLACE)
    void insert(Concept concept);
}
