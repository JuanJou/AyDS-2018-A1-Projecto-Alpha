package ayds.dictionary.alpha.Model.Exceptions;

public class ErrorHandler {

    private ErrorHandlerListener listener;

    public void setErrorHandlerListener(ErrorHandlerListener listener){
        this.listener=listener;
    }

    public void throwException(Exception exc){
        if (exc instanceof ModelException){
            listener.catchException(exc.getMessage());
        }
        else{
            listener.catchException("Error inseperado");
        }
    }


}
