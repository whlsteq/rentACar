package kodlama.io.rentACar.core.utilities.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);//super base class a yolla demek oluyor yani burda RuntimeException a gonder diyor.
    }
}
