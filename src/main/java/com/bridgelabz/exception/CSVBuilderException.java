package com.bridgelabz.exception;

public class CSVBuilderException extends Exception {

    public ExceptionType exceptionType;

    public CSVBuilderException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;

    }

    public enum ExceptionType {
        UNABLE_TO_PARSE;
    }
}
