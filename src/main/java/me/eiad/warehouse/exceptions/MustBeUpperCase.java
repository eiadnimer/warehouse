package me.eiad.warehouse.exceptions;

public class MustBeUpperCase extends RuntimeException{
    public MustBeUpperCase(String message) {
        super(message);
    }
}
