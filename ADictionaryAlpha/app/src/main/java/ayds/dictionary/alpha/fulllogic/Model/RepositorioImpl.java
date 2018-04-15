package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

import java.util.List;

public class RepositorioImpl implements Repositorio {

    protected List<Servicio> servicios;

    public RepositorioImpl(Context context,List<Servicio> servicios){
        this.servicios=servicios;
    }

    public Term getTerm(String nombre){

        Term nuevoTermino=new Term();
        nuevoTermino.setNombre(nombre);


        String definicion=null;
        int source=1;


        for(Servicio s:servicios){
            definicion=s.obtenerDefinicion(nombre);
            if (definicion!=null){
                nuevoTermino.setDefinicion(definicion);
                nuevoTermino.setSource(source);
                return nuevoTermino;
            }
            source++;
        }
        nuevoTermino.setDefinicion("No hay resultados");
        nuevoTermino.setSource(0);
        return nuevoTermino;
    }

}

