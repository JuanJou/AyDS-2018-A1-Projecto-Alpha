package ayds.dictionary.alpha.Model;

public class ErrorHandler {

    private ErrorHandlerListener listener;

    public void setErrorHandlerListener(ErrorHandlerListener listener){
        this.listener=listener;
    }

    public void throwException(ModelException exc){
        listener.catchException(exc.getMessage());
    }


}
