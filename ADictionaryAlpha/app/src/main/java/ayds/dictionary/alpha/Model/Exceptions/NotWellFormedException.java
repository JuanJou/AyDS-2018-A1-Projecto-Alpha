package ayds.dictionary.alpha.Model.Exceptions;

public class NotWellFormedException extends ModelException {

    private static String message="Expresion mal formada";

    public NotWellFormedException(){
        super(message);
    }


}
