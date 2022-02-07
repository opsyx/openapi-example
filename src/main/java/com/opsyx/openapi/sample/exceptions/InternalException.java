package com.opsyx.openapi.sample.exceptions;

public class InternalException extends RuntimeException{

    public InternalException(Throwable t) {
        super(t);
    }

}
