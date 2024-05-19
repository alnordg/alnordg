package se.kth.iv1350.model;

import se.kth.iv1350.integration.Item;
import se.kth.iv1350.integration.ItemIdentifier;
import java.util.*;


/**
 * Contains all items sold during one transaction.
 * It uses a map of the items as well as how many times they have been entered.
 */
public class SoldItems {
    private HashMap<Item,Integer> soldItems;

    /**
     *Initializes the HashMap used to store the items.
     */
    public SoldItems() {
        soldItems = new HashMap<>();
    }
    
    /**
     * This method adds an item to the map if it has not been scanned before.
     * If it has the quantity is raised by one.
     * @param lastScannedItem the item that was scanned.
     */
    public void add(Item lastScannedItem){
        Item ID = lastScannedItem;
        if(soldItems.containsKey(ID)){
            soldItems.put(ID, soldItems.get(ID) + 1);
        }else{
            soldItems.put(ID, 1);
        }
    }
    /**
     * Returns how many times the provided Item has been scanned.
     * Returns '0' if the Item has never been scanned before.
     * @param itemToGetDataFor the sought Item.
     * @return how many times the provided Item has been scanned.
     */
    public int getQuantity(Item itemToGetDataFor){
        if(soldItems.containsKey(itemToGetDataFor)){
            return soldItems.get(itemToGetDataFor);
        }else{
            return 0;
        }
    }
    
    public String toString(){
        StringBuilder buildListOfSoldItems = new StringBuilder();
        Iterator iteratorForSoldItems = soldItems.entrySet().iterator();
        while(iteratorForSoldItems.hasNext()){
            Map.Entry pair = (Map.Entry) iteratorForSoldItems.next();
            buildListOfSoldItems.append(pair.getKey() + " x" + pair.getValue()+"\n");
        }
        return buildListOfSoldItems.toString();
    }

    
}
