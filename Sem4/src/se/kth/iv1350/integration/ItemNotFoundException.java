
package se.kth.iv1350.integration;

/**
 * This exception is thrown when the searched item does not exist in the database.
 */
public class ItemNotFoundException extends Exception {
    int itemID;
    /**
     * Creates a new instance of <code>ItemNotFoundException</code> without
     * detail message.
     * @param itemID
     */
    public ItemNotFoundException(int itemID) {
        super("The requested item does not exist in the registry. ItemID: "+ itemID);
        this.itemID = itemID; 
    }
    /**
     * Gets the itemID that could not be found;
     * @return itemID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Constructs an instance of <code>ItemNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
