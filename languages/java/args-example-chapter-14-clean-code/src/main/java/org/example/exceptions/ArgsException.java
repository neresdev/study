package org.example.exceptions;

public class ArgsException extends RuntimeException {
    private char errorArgumentId = '\0';
    private String errorParameter = null;
//    private ErrorCode errorCode = OK;
}
