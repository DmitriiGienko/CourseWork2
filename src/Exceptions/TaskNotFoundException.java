package Exceptions;

public class TaskNotFoundException extends Exception{
   private String s;

    public TaskNotFoundException(String message) {
        super(message);
    }
}
