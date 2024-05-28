package me.eiad.warehouse.exceptions;

public class NoDealInFuture extends RuntimeException{
    public NoDealInFuture(String message) {
        super(message);
    }
}
