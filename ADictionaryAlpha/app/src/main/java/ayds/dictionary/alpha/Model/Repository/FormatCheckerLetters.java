package ayds.dictionary.alpha.Model.Repository;

import java.util.regex.Pattern;

public class FormatCheckerLetters implements FormatChecker {
    @Override
    public boolean isWellFormed(String term) {
        return term!=null && Pattern.compile("[a-zA-Z]+").matcher(term).find();
    }
}
