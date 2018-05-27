package ayds.dictionary.alpha.Model.Exceptions;

public class ErrorHandlerModule {

    private static ErrorHandlerModule instance;
    private ErrorHandler errorHandler;

    private ErrorHandlerModule(){
        errorHandler=new ErrorHandler();
    }


    public static ErrorHandlerModule getInstance(){
        if (instance==null){
            instance=new ErrorHandlerModule();
        }
        return instance;
    }

    public ErrorHandler getErrorHandler(){
        return errorHandler;
    }

}
