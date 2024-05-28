package me.eiad.warehouse.exceptions;

public class AmountIsMinus extends RuntimeException {
    public AmountIsMinus(String message) {
        super(message);
    }
}
