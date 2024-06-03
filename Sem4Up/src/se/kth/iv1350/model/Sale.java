package se.kth.iv1350.model;

import se.kth.iv1350.utilities.Discount;
import se.kth.iv1350.utilities.TotalPriceDTO;
import se.kth.iv1350.utilities.SaleDTO;
import se.kth.iv1350.utilities.AmountOfMoney;
import se.kth.iv1350.integration.Item;
import se.kth.iv1350.integration.DiscountRegistry;

/**
 * This is the central class of the program. 
 * Each instance handles one transaction.
 */
public class Sale {

    private TotalPrice totalPrice;

    private SaleInformation saleInformation;

    private CashRegister cashRegister;

    private boolean ongoingSale;

    /**
     * Initializes a new sale.
     * @param cashRegister the cash register in the store. 
     *
     */
    public Sale(CashRegister cashRegister) {
        saleInformation = new SaleInformation();
        this.cashRegister = cashRegister;
        setTotalPrice();
        ongoingSale = true;
    }

    /**
     * This ends the current transaction.
     * It sets the ongoingSale variable to false to prevent adding more items to it.
     * @return the final price of the transaction.
     */
    public TotalPriceDTO finalizeSale() {
        setTotalPrice();
        ongoingSale = false;
        return new TotalPriceDTO(totalPrice);
    }
    
    private void setTotalPrice(){
        totalPrice = new TotalPrice(saleInformation.getRunningTotal());
    }

    /**
     * Adds an item to the transaction. 
     * The quantity determines how many of the item are to be added.
     * @param quantity how many of the item are to be added.
     * @param item the item to be added.
     * @return a DTO containing the current state of the transaction. 
     */
    public SaleDTO sellItem(int quantity, Item item) throws IllegalArgumentException{
        if(quantity<1){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (ongoingSale) {
            for (int i = 0; i < quantity; i++) {
                saleInformation.updateSale(item);
            }
        }
        return getSaleData();

    }


    /**
     * Returns the current state of the sale.
     * @return the current state of the sale.
     */
    public SaleDTO getSaleData() {
        return saleInformation.getSaleInformation();
    }

    /**
     * Handles the payment for the transaction.
     * @param amountPaid the amount of money handed over by the customer.
     * @return the change.
     * @throws se.kth.iv1350.model.InsufficientFundsException
     */
    public AmountOfMoney payForSale(AmountOfMoney amountPaid) throws InsufficientFundsException{
        AmountOfMoney change = new AmountOfMoney(0);
        if(!ongoingSale){
           change = cashRegister.registerPayment(amountPaid, totalPrice.getPrice());
       }
       
        return change;
    }

    /**
     * Returns a new total amount depending on the provided discount.
     * It will only apply the discount if the sale has been finished.
     * @param discount the discount that is to be added to the total price.
     * @return the new total.
     */
    public TotalPriceDTO getDiscount(Discount discount) {
        if(!ongoingSale){
        totalPrice.applyDiscount(discount); 
        }
        return new TotalPriceDTO(totalPrice);

    }

}
