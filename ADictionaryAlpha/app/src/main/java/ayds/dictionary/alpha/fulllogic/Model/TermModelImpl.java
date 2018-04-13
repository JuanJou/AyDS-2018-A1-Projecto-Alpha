package ayds.dictionary.alpha.fulllogic.Model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class TermModelImpl implements TermModel {

    private Term terminoActual;
    private TermModelListener oyente;
    private Repositorio repo;

    public TermModelImpl(Repositorio repo){
        this.repo=repo;
    }


    @Override
    public void updateTerm(String nombre) {
        terminoActual=repo.getTerm(nombre);

        oyente.didUpdateTerm(terminoActual);
    }



    @Override
    public void setListener(TermModelListener listener) {
        oyente=listener;
    }
}
