package ch11.exception;

public class DataFormatException extends NumberFormatException {
    public DataFormatException(String message) {
        super(message);
    }
}
