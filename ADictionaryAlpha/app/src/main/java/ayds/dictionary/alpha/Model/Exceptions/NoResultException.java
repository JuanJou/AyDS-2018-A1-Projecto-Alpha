package ayds.dictionary.alpha.Model.Exceptions;

public class NoResultException extends ModelException {

    private static String message="No hay resultados";

    public NoResultException(){
        super(message);
    }

}
