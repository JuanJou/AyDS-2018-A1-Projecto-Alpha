package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;

public class RepositorioImpl {

    protected Servicio servicioWiki;
    protected DataBase baseDeDatos;

    public RepositorioImpl(Context context){
        servicioWiki.conectar();
        crearBaseDeDatos(context);
    }

    public Term getTerm(String nombre){

        Term nuevoTermino=new Term();

        int source=2;

        String text = DataBase.getMeaning(nombre);

        if (text != null) { // exists in db
            source=1;
            text = "[*]" + text;
        } else {
            text=servicioWiki.obtenerDefinicion(nombre);
        }
        nuevoTermino.setDefinicion(text);
        nuevoTermino.setSource(source);
        nuevoTermino.setNombre(nombre);
        return nuevoTermino;
    }


    private void crearBaseDeDatos(Context context) {
        DataBase.createNewDatabase(context);
    }


}

