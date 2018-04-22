package ayds.dictionary.alpha.fulllogic.Model;

public class RepositoryImpl implements Repository {

    protected PersistentData dataBase;
    protected Data wikiApi;

    public RepositoryImpl(PersistentData bd,Data wiki){
        this.dataBase=bd;
        this.wikiApi=wiki;
    }

    public Term getTerm(String name){

        Term newTerm=new Term();
        newTerm.setName(name);


        String definition=null;
        int source=2;

        definition=dataBase.getDefinition(name);

        if (definition!=null){
            source=1;
            definition="[*]"+definition;
        }
        else{
            definition=wikiApi.getDefinition(name);
            dataBase.saveTerm(newTerm);
        }

        newTerm.setDefinition(definition);
        newTerm.setSource(source);
        return newTerm;
    }

}

