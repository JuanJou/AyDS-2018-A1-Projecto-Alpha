package ayds.dictionary.alpha.fulllogic.Model;

public class TermModelImpl implements TermModel {

    private Term terminoActual;
    private TermModelListener oyente;
    private Repositorio repo;

    public TermModelImpl(Repositorio repo){
        this.repo=repo;
    }

    @Override
    public void updateTerm(String nombre) {

        if(nombre!=null && !nombre.equals("")) {
            terminoActual = repo.getTerm(nombre);

            oyente.didUpdateTerm(terminoActual);
        }
    }

    @Override
    public void setListener(TermModelListener listener) {
        oyente=listener;
    }
}
