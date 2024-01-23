package Q1;

/**
 * Custom IllegalArgumentException class that extends the standard Java Exception class.
 * This class is used to indicate that an illegal argument has been passed to a method.
 */
public class IllegalArgumentException extends Exception {

    /**
     * Constructs a new IllegalArgumentException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public IllegalArgumentException(String message) {
        super(message);
    }
}
