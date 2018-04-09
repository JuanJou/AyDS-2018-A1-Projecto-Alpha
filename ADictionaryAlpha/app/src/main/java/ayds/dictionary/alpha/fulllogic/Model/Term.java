package ayds.dictionary.alpha.fulllogic.Model;

import java.util.Date;

public class Term {

    private String nombre;
    private String definicion;
    private Date lastUpdate;


    public void setNombre(String name){
        nombre=name;
        lastUpdate=new Date();
    }

    public void setDefinicion(String def){
        definicion=def;
        lastUpdate=new Date();
    }


    public String getNombre(){
        return nombre;
    }

    public String getDefinicion(){
        return definicion;
    }




}
