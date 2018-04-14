package ayds.dictionary.alpha.fulllogic.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String definicion;
    private int source;


    public void setNombre(String name){
        nombre=name;
    }

    public void setDefinicion(String def){
        definicion=def;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDefinicion(){
        return definicion;
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
