package com.avijit.addressbook.common.exception;

public class NotFoundException extends Exception {

    private String code;

    public NotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}