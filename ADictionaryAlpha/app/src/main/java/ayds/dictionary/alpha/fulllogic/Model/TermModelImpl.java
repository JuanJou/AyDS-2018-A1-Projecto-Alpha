package ayds.dictionary.alpha.fulllogic.Model;

public class TermModelImpl implements TermModel {

    private Term currentTerm;
    private TermModelListener listener;
    private Repository repo;

    public TermModelImpl(Repository repo){
        this.repo=repo;
    }

    @Override
    public void updateTerm(String name) {

        if(name!=null && !name.equals("")) {
            currentTerm = repo.getTerm(name);

            listener.didUpdateTerm(currentTerm);
        }
    }

    @Override
    public void setListener(TermModelListener listener) {
        this.listener=listener;
    }
}
