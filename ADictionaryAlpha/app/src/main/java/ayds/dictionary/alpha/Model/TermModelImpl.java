package ayds.dictionary.alpha.Model;

import ayds.dictionary.alpha.Model.Repository.Repository;

class TermModelImpl implements TermModel {

    private TermModelListener oyente;
    private Repository repo;

    TermModelImpl(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void updateTerm(String name) {
        oyente.didUpdateTerm(repo.getDefinition(name));
    }

    @Override
    public void setListener(TermModelListener listener) {
        oyente = listener;
    }

    @Override
    public void setErrorHandler(ErrorHandler listener) {
        repo.setErrorHandler(listener);
    }
}
