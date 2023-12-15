package com.example.ptmedia.exception;

import org.springframework.http.HttpStatus;

public class alreadyExsitException  extends  ptException{

    public alreadyExsitException( ) {
        super(HttpStatus.BAD_REQUEST, 101 );
    }
}
