package ayds.dictionary.alpha.fulllogic.Model;

import android.arch.persistence.room.Database;
import android.content.Context;


public class BaseDeDatos implements DataConPersistencia {

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

    public void guardarTermino(Term termino){
        DataBase.saveTerm(termino.getNombre(),termino.getDefinicion());
    }
}
