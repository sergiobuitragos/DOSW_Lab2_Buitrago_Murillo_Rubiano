package edu.eci.dosw.reto1;

/**
 * Thrown when a monetary amount used in a business calculation is invalid
 * (null or negative).
 */

public class InvalidAmountException extends IllegalArgumentException {

    public InvalidAmountException(String message) {
        super(message);
    }
}
