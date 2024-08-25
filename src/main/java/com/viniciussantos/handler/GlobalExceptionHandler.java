package com.viniciussantos.handler;

import com.viniciussantos.exception.DepartamentoMismatchException;
import com.viniciussantos.exception.RecursoNaoEncontradoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
/**
 * Manipulador global de exceções para capturar e tratar exceções de forma centralizada.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Manipula a exceção RecursoNaoEncontradoException.
     *
     * @param ex A exceção lançada.
     * @param request O objeto WebRequest que contém os detalhes da requisição.
     * @return ResponseEntity com o erro formatado e o status HTTP.
     */
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<?> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex , WebRequest request) {
        // Logar o erro, se necessário
        // Retornar a mensagem de erro com o status HTTP 404
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).substring(4) // remove "uri=" prefixo
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartamentoMismatchException.class)
    public ResponseEntity<?> handleDepartamentoMismatchException(DepartamentoMismatchException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).substring(4) // remove "uri=" prefixo
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    /**
     * Manipula todas as exceções não capturadas por handlers específicos.
     *
     * @param ex A exceção lançada.
     * @param request O objeto WebRequest que contém os detalhes da requisição.
     * @return ResponseEntity com o erro formatado e o status HTTP.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).substring(4) // remove "uri=" prefixo
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * Manipula a exceção EmptyResultDataAccessException.
     *
     * @param ex A exceção lançada.
     * @return ResponseEntity com a mensagem de erro e o status HTTP.
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado");
    }

}