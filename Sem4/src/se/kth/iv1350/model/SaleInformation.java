package se.kth.iv1350.model;

import se.kth.iv1350.utilities.SaleDTO;
import se.kth.iv1350.utilities.AmountOfMoney;
import se.kth.iv1350.integration.Item;
import se.kth.iv1350.integration.ItemIdentifier;
import java.util.*;

/**
 * This class contains the data pertaining to the current transaction.
 */
public class SaleInformation {

    private AmountOfMoney runningTotal;

    private SoldItems soldItems;

    private Item lastSoldItem;

    

    /**
     * this returns the final price when the sale has been finished.
     * @return the final price.
     */
    public TotalPrice getFinalAmount() {
        return new TotalPrice(runningTotal);
    }

    /**
     * This adds an item to the current sale.
     * @param saleUpdate the item that is to be added to the sale.
     * @return a sale DTO containing all the current data.
     */
    public SaleDTO updateSale(Item saleUpdate) {
        
        runningTotal.add(saleUpdate.getPrice());
        soldItems.add(saleUpdate);
        lastSoldItem = saleUpdate;
        return getSaleInformation();
    }

    /**
     *Initializes the sale information. 
     */
    public SaleInformation() {
       
        runningTotal = new AmountOfMoney(0);
        soldItems = new SoldItems();
    }
    
    /**
     * Returns the current sale information
     * @return a DTO containing the current sale information.
     */
    public SaleDTO getSaleInformation(){
        return new SaleDTO(runningTotal,lastSoldItem,soldItems);
    }

    /**
     * Returns the running total.
     * @return the running total.
     */
    public AmountOfMoney getRunningTotal() {
        return runningTotal;
    }

    /**
     * Returns the object containing all items sold during this transaction.
     * @return soldItems containing all sold Items.
     */
    public SoldItems getSoldItems() {
        return soldItems;
    }

    /**
     * Gets the last item entered.
     * @return the last entered Item.
     */
    public Item getLastSoldItem() {
        return lastSoldItem;
    }

}
