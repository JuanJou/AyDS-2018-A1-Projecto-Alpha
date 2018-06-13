package ayds.dictionary.alpha.Model;

public class Term {

    private Source source;
    private String term;
    private String definition;

    public Term(String term){
        this.term=term;
    }

    public void setDefinition(String definition){

        this.definition=definition;
    }

    public void setSource(Source source){

        this.source=source;
    }

    public String getTerm(){

        return term;
    }

    public String getDefinition(){

        return definition;
    }

    public Source getSource(){

        return source;
    }

}
