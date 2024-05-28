package me.eiad.warehouse.exceptions;

public class IdMustBePositive extends RuntimeException{
    public IdMustBePositive(String message) {
        super(message);
    }
}
