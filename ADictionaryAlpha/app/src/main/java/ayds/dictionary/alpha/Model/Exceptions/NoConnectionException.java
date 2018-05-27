package ayds.dictionary.alpha.Model.Exceptions;

public class NoConnectionException extends ModelException {

    private static String message="Sin conexion";

    public NoConnectionException(){
        super(message);
    }

}
