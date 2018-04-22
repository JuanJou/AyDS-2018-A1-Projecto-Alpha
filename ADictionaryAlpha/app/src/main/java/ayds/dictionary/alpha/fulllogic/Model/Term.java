package ayds.dictionary.alpha.fulllogic.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String definition;
    private int source;


    public void setName(String name){
        this.name=name;
    }

    public void setDefinition(String def){
        definition=def;
    }

    public String getName(){
        return name;
    }

    public String getDefinition(){
        return definition;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
