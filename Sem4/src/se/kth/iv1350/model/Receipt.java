package se.kth.iv1350.model;

import se.kth.iv1350.utilities.SaleDTO;
import se.kth.iv1350.utilities.AmountOfMoney;

/**
 * Contains the transaction data.
 * It is used to print a receipt that is to be given to the customer.
 */
public class Receipt {
        private SaleDTO saleInformation;
        private AmountOfMoney change;
        private AmountOfMoney paidMoney;

    /**
     * Initializes all fields.
     * @param saleInformation the information from the finished sale.
     * @param change how much change was paid back.
     * @param paidMoney How much the customer paid.
     */
    public Receipt(SaleDTO saleInformation, AmountOfMoney change, AmountOfMoney paidMoney) {
        this.saleInformation = saleInformation;
        this.change = change;
        this.paidMoney = paidMoney;
        
        
    }

    private String getSoldItems(){
            
        return saleInformation.getSoldItems().toString();
    }
    
    public String toString(){
        StringBuilder buildReciept = new StringBuilder();
        buildReciept.append("\nThank you for shopping here today!\n");
        buildReciept.append("You've bought: \n");
        buildReciept.append(getSoldItems());
        buildReciept.append("\nFinal price: " +saleInformation.getRunningTotal());
        buildReciept.append("\nAmount paid: " +paidMoney);
        buildReciept.append("\nChange: " +change+"\n");
        return buildReciept.toString();
    }

}
