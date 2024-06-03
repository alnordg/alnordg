package se.kth.iv1350.integration;

/**
 * This exception is thrown if the item database fails. 
 */
public class DatabaseFailureException extends RuntimeException {
    int itemThatCrashedDatabase;
    /**
     * Creates a new instance of <code>DatabaseFailureException</code> without
     * detail message.
     * @param itemID
     */
    public DatabaseFailureException(int itemID) {
        super("DatabaseFailure. Caused by item: " + itemID);
        itemThatCrashedDatabase = itemID;
    }

    /**
     * Constructs an instance of <code>DatabaseFailureException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DatabaseFailureException(String msg) {
        super(msg);
    }
    
}
