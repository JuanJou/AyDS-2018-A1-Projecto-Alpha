package ayds.dictionary.alpha.Model.DataBase.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import ayds.dictionary.alpha.Model.Source;

@Entity
public class Concept {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String term;
    private String meaning;
    private String source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSource() {

        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

