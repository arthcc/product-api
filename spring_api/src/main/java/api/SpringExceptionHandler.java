package api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public @RestControllerAdvice class SpringExceptionHandler {

    @ExceptionHandler(ServicoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleServicoException(ServicoException servicoException) {
        /* simplificando resposta */
        return servicoException.getMessage();
    }
}
