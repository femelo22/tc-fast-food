package br.com.lfmelo.infrastructure.exceptions;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandleException {

//    @Autowired LogClient logClient;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Operation(hidden = true)
    public ResponseEntity<StandardError> objectNotFoundException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        BindingResult bindingResult = ex.getBindingResult();

        StandardError error = new StandardError(bindingResult);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Method Argument Not Valid Exception");
        error.setDate(LocalDateTime.now());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<StandardError> objectNotFoundException(NotFoundException ex, HttpServletRequest request) {
//
//        StandardError error = new StandardError();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage("Not Found Exception");
//        error.setDate(LocalDateTime.now());
//        error.setPath(request.getRequestURI());
//
////        logClient.ingestLog(createLog("Not Found Exception", "Entidade não encontrada", ex.getMessage()));
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//    }
}
