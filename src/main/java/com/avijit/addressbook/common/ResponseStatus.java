package com.avijit.addressbook.common;

public enum ResponseStatus {

    SUCCESS("1000", "Success"),
    ALREADY_EXITS("1409", "Already Exits"),
    NOT_FOUND("1404", "Not found");

    private final String value;
    private final String description;

    ResponseStatus(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return value;
    }

    public String description() {
        return description;
    }

}
