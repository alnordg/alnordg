package se.kth.iv1350.integration;

import se.kth.iv1350.utilities.AmountOfMoney;

/**
 * This class represents an Item that exists in the store.
 */
public class Item {

	private final ItemIdentifier itemID;

	private final ItemDescription itemDescription;

	private boolean isValidItem;

	private final AmountOfMoney price;

	private final String itemCategory;

    /**
     *  This initializes the Item and sets the fields
     * @param itemID the identifier for the item.
     * @param description describes the item.
     * @param cost how much the item costs
     * @param category what category of item it is.
     */
    public Item(int itemID,ItemDescription description,AmountOfMoney cost,String category) {
            this.itemID = new ItemIdentifier(itemID);
            this.itemDescription = description;
            price = cost;
            itemCategory = category;
	}

    /**
     * Returns the ItemIdentifier
     * @return ItemIdentifier
     */
    public ItemIdentifier getItemID() {
        return itemID;
    }

    /**
     * Returns ItemDescription 
     * @return ItemDescription 
     */
    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    /**
     *return isValidItem
     * @return isValidItem
     */
    public boolean isIsValidItem() {
        return isValidItem;
    }

    /**
     *return price
     * @return return price
     */
    public AmountOfMoney getPrice() {
        return price;
    }
        
    /**
     *return itemCategory
     * @return itemCategory
     */
    public String getItemCategory() {
        return itemCategory;
    }
    /**
     * Generates a string representation of the item, which is the description.
     * @return the description of the item.
     */
    public String toString(){
        return itemDescription.toString();
    }

}
