package Exceptions;

public class IncorrectArgumentException extends Exception {

    private String argument;

    public String getArgument() {
        return argument;
    }

    public IncorrectArgumentException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage() + " - задан не корректно!";
    }
}
