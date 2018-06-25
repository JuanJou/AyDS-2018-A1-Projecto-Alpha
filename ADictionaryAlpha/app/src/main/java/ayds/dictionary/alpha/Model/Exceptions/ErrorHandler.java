package ayds.dictionary.alpha.Model.Exceptions;

import java.util.Map;

import ayds.dictionary.alpha.Model.Source;

public class ErrorHandler {

    private ErrorHandlerListener listener;

    public void setErrorHandlerListener(ErrorHandlerListener listener){
        this.listener=listener;
    }

    public void throwException(Map<Source,Exception> exceptions){
        for (Map.Entry<Source,Exception> entry:exceptions.entrySet()){
            listener.catchException(entry.getKey().name(),entry.getValue().getMessage());
        }
    }


}
