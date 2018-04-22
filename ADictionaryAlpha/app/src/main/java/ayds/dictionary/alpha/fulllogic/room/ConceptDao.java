package ayds.dictionary.alpha.fulllogic.room;

import android.arch.persistence.room.*;

import java.util.List;

import ayds.dictionary.alpha.fulllogic.Model.Term;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ConceptDao {

  @Query("SELECT * FROM Term")
  List<Term> getAll();

  @Query("SELECT * FROM Term WHERE name LIKE :term LIMIT 1")
  Term findByName(String term);

  @Insert(onConflict = REPLACE)
  void insert(Term concept);
}
