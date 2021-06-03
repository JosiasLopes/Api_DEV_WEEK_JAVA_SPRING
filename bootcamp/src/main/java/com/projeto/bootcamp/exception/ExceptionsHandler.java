package com.projeto.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//a anotation abaixo diz para o spring vigiar esssa classe
//a classe vai herdar de ResponseEntityExceptionHandler pra tratar exceptions de response
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    //a anotation abaixo diz para o spring verificar exceptions de x classe
    //o que for programado dentro do metoo é  que vai acontecer
    //o metodo retorna um reponse nos passamos no body desse response a mensagem
    //a mensagem passada vem da classe exption do business
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(BusinessException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
    }
}
