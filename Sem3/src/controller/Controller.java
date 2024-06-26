package controller;

import model.CashRegister;
import model.ItemDTO;
import model.Receipt;
import model.Sale;
import integration.InventorySystem;
import integration.AccountingSystem;
import integration.SystemCreator;


/**
 * Controller is the class that ties together what happens in the view with what
 * the program needs to do
 * 
 */
public class Controller {
    private Sale sale;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private CashRegister cashRegister;
    private double runningTotal;
    
    /**
    * Creates a new instance of controller with references to inventorysystem
    * accountingsystem and cashRegister
    * @param inventorySystem The inventorySystem of the grocery store
    * @param accountingSystem The accountingSystem of the grocery store.
    * @param cashRegister The cashregister of the grocery store.
    */
    public Controller(InventorySystem inventorySystem, AccountingSystem accountingSystem, CashRegister cashRegister) {
    	this.inventorySystem = inventorySystem;
    	this.accountingSystem = accountingSystem;
    	this.cashRegister = cashRegister;
    }
    
    /**
     * The method creates an instance of the Sale class. It also turns on the
     * cash Register in the grocery store.
     */
    public void startNewSale(SystemCreator creator) {
        sale = new Sale(creator);
        sale.turnOnCashRegister();
    }
    
    /**
     * addItem adds an item to the current sale aswell as the quantity of that item
     * @param itemIdentifier a unique code that represents a unique item in the inventorysystem
     * @param itemQuantity represents the quantity of the item to be added
     * @return the method returns an item found in the inventorysystem.
     */
    public ItemDTO addItem(int itemIdentifier, int itemQuantity) {
    	ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
    	if(foundItem != null) {
	    	sale.addItem(foundItem, itemQuantity);
	    	return foundItem;
    	} else {
    		return null;
    	}
    }
    
    /**
     * pay calls upon the method pay in the class sale which represents
     * the act of the customer paying for a sale. It calculates the amount of change
     * that the customer is to receive and it saves sale information in the external
     * systems AccountingSystem and InventorySystem.
     * @param amount represents the amount the customer pays
     * @return returns the amount of change that the customer is to receive.
     */
    public double pay (double amount) {
    	 if(amount > sale.getTotalPrice()) {
            double change = sale.pay(amount);
            return change;
        } else {
            return -1.0;
        }
    }
    
    /**
     * Represents the action of the cashier indicating that all items have been registered
     * @return Returns the price of the sale so the cashier and customer can see it.
     */
    public double getRunningTotal() {
    	runningTotal = sale.getRunningTotal();
    	return runningTotal;
    }
    
    /**
     * The method represents the action of the cashier indicating that 
     * all the items are registered. This means that no more items will be scanned.
     * @return  the total price of the sale, including VAT.
     */
    public double indicateAllItemsRegistered() {
        double totalPrice = sale.getTotalPrice();
        return totalPrice;
    }
    /**
     * Creates an instance of the receipt class, which contains all the needed
     * information about the sale.
     * @return Returns an instance of the receipt class.
     */
    public Receipt requestReceipt() {
    	Receipt receipt = new Receipt(sale);
    	return receipt;
    }
}
