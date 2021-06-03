package com.projeto.bootcamp.exception;

import com.projeto.bootcamp.util.MessageUtil;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtil.NO_RECORDS_FOUNDED);
    }
}
