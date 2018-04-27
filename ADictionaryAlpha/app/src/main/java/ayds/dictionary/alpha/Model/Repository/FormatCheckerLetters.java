package ayds.dictionary.alpha.Model.Repository;

public class FormatCheckerLetters implements FormatChecker {
    @Override
    public boolean isWellFormed(String term) {
        return term!=null && term.matches("[a-zA-Z]+");
    }
}
