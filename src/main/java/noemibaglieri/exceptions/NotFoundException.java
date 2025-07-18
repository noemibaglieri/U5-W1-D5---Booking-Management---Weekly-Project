package noemibaglieri.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long userId) {
        super("The requested id * " + userId + " * was not found.");
    }

    public NotFoundException(String name) {
        super("Resource with name * " + name + " * not found.");

    }
}