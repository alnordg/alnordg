package controller;

/**
 * Thrown when there is an error adding an item.
 */
public class CouldNotAddItemException extends Exception{
    
    /**
     * Creates a new instance with a descriptive message.
     */
    public CouldNotAddItemException(String message, Exception cause) {
        super(message, cause);
    }
}