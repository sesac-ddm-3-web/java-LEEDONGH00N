package ch11.exception;

public class InsufficientBalanceException extends OrderException{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
