
package se.kth.iv1350.integration;

/**
 * This identifies an Item and is used to compare if they are the same.
 */
public class ItemIdentifier {

    int itemID;

    /**
     * Constructs the ItemIdentifier.
     * @param id the identifier for this item.
     */
    public ItemIdentifier(int id) {
        itemID = id;
    }

    /**
     * Checks if an object is equal to this.
     * @param o the object to be checked.
     * @return result of comparison.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemIdentifier) {
            ItemIdentifier compID = (ItemIdentifier) o;
            return itemID == compID.getItemID();
        }
        return false;
    }

    /**
     * Returns a HashCode for this object.
     *
     * @return the HashCode for this object.
     */
    @Override
    public int hashCode() {
        return getItemID();
    }

    /**
     * Returns the ItemID as an integer.
     * @return the itemID
     */
    public int getItemID() {
        return itemID;
    }

}
