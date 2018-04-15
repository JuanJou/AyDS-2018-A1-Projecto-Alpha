package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;


public class BaseDeDatos implements Servicio {

    private Context context;

    public BaseDeDatos(Context context){
        this.context=context;
    }

    @Override
    public String obtenerDefinicion(String term) {
        return DataBase.getMeaning(term);
    }

    @Override
    public void conectar() {
        DataBase.createNewDatabase(context);
    }
}
