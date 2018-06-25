package ayds.dictionary.alpha.Model.Exceptions;

public interface ErrorHandlerListener {

    void catchException(String exceptionSource,String exceptionMessage);

}