package ayds.dictionary.alpha.View;

public class TermView {

    private String source;
    private String text;

    public TermView(String source, String text) {
        this.source = source;
        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {

        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
