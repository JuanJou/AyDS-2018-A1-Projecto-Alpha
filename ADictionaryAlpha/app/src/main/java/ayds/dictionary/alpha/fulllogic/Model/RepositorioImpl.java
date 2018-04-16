package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

import java.util.List;

public class RepositorioImpl implements Repositorio {

    protected DataConPersistencia baseDeDatos;
    protected Data wikiApi;

    public RepositorioImpl(Context context,DataConPersistencia bd,Data wiki){
        this.baseDeDatos=bd;
        this.wikiApi=wiki;
    }

    public Term getTerm(String nombre){

        Term nuevoTermino=new Term();
        nuevoTermino.setNombre(nombre);


        String definicion=null;
        int source=2;

        definicion=baseDeDatos.obtenerDefinicion(nombre);

        if (definicion!=null){
            source=1;
            definicion="[*]"+definicion;
        }
        else{
            definicion=wikiApi.obtenerDefinicion(nombre);
            baseDeDatos.guardarTermino(nuevoTermino);
        }

        nuevoTermino.setDefinicion(definicion);
        nuevoTermino.setSource(source);
        return nuevoTermino;
    }

}

