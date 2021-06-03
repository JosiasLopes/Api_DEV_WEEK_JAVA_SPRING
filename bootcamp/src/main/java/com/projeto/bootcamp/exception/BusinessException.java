package com.projeto.bootcamp.exception;


//a camda exception trata as excesoes de negocios
//e é acessada pelo service
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
