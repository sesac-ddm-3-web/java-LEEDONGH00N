package ch11.exception;

public class OutOfStockException extends OrderException{
    public OutOfStockException(String message) {
        super(message);
    }
}