package view;

import controller.Controller;
import integration.Printer;
import integration.SystemCreator;
import java.lang.Math;
import model.ItemDTO;
import model.Receipt;
import model.Sale;

/**
 * The view is a representation of what the customer and cashier sees as well as
 * how the customer and cashier interacts with the system.
 * 
 */
public class View {
    private double VAT = 25;
	private Controller controller;
        
    /**
     * Creates an instance of the view
     * @param controller A reference to an instance of the controller class. Is
     * used to connect the view to the rest of the system.
     */
    public View(Controller controller) {
        this.controller = controller;
    }
    /**
     * Represents the action of the cashier scanning an item, thereby adding it
     * to the sale. If the itemidentifier is incorrect it prints an error message.
     * @param itemId The identifier of the item, used to find it in the
     * database.
     * @param quantity The quantity of the item that is scanned.
     */
    public void addItem(int itemId, int quantity) {
    	ItemDTO currentItem = controller.addItem(itemId, quantity);
    	if(currentItem != null) {
    		printItemOnScreen(currentItem, quantity);
    	} else {
    		System.out.println("Item: not found");
    	}
    }

    /**
     * The method represents the action of the cashier starting a new sale.
     */
    public void runSale(SystemCreator creator) {
    	controller.startNewSale(creator);
        System.out.println("New sale was started.");
    }
    
    /**
     * pay Represents the action of the customer paying for the sale. It also
     * calculates the amount of change that the customer is to receive and it
     * saves the information about the sale in the external systems AccountingSystem
     * and InventorySystem.
     * 
     * @param amount The amount of money that the customer pays.
     */
    public void pay(double amount) {
    	double amountPaid = amount;
    	double change = controller.pay(amount);
        if(change > 0) {
            printTotalPriceAndChange(amountPaid, change);
        } else {
            System.out.println("Insufficient ammount paid.");
        }
        
    	
    }
    
    /**
     * This method represents the cashier scanning items, it also prints the
     * information about the scanned items aswell as the running total.
     */
    public void addItemsAndPrintToConsole(){
        addItem(0, 2);
        addItem(0, 2);
        addItem(1, 3);
        addItem(2, 4);
        addItem(3, 4);
        addItem(0, 1);
    }
    
    /**
     * requestReceipt prints out all the information on the receipt.
     */
    public void printReceipt() {
        Receipt receipt = controller.requestReceipt();
        controller.printReceipt(receipt); 
    }
     
    private void printItemOnScreen(ItemDTO IDTO, int quantity) {
    	double runningTotal = controller.getRunningTotal();
    	System.out.println("Item: " + IDTO.getItemDescription() + " x" + quantity + " Price: " + IDTO.getPrice() * quantity + " VAT " + this.VAT + " % " + " Running Total: " + runningTotal);
    }
    
    
    private void printTotalPriceAndChange(double amountPaid, double change) {
        double totalPrice = controller.indicateAllItemsRegistered();
        System.out.println("Total cost (Including VAT): " + totalPrice);
    	System.out.println("Amount paid : " + amountPaid + " Change: " + Math.round(change * 100.0) / 100.0);
    }
   
}