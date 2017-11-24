package gioandbill.br.clinica.exceptions;

import gioandbill.br.clinica.exceptions.PessoaIdMismatchException;
import gioandbill.br.clinica.exceptions.PessoaNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PessoaNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Pessoa não encontrada", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({PessoaIdMismatchException.class, ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
