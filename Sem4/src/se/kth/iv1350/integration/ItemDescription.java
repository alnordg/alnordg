package se.kth.iv1350.integration;

/**
 *This class describes the Item
 */
public class ItemDescription {

	private String itemDescription;

	//private int price;

    /**
     * Constructor for the item.
     * @param description what the item is.
     */
        
        public ItemDescription(String description){
            itemDescription = description;
        }
        
        public String toString(){
            return itemDescription;
        }
}
