package com.projeto.bootcamp.exception;

public class ExceptionResponse {
    private String messsage;

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public ExceptionResponse(String messsage) {
        this.messsage = messsage;
    }
}
