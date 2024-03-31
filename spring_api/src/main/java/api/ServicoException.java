package api;

public class ServicoException extends RuntimeException {

    public ServicoException() {
    }

    public ServicoException(String message) {
        super(message);
    }

    public ServicoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicoException(Throwable cause) {
        super(cause);
    }

    public ServicoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

