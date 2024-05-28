package me.eiad.warehouse.exceptions;


public class FieldMustNotBeEmpty extends RuntimeException {

    public FieldMustNotBeEmpty(String message) {
        super(message);
    }
}
