package se.kth.iv1350.model;


import se.kth.iv1350.utilities.Discount;
import se.kth.iv1350.utilities.AmountOfMoney;

import se.kth.iv1350.model.SaleInformation;
import se.kth.iv1350.model.Tax;

/**
 * Contains the final price of the transaction.
 */
public class TotalPrice {

	private  AmountOfMoney price;

	private double tax;

    /**
     * Initializes the class.
     * It also adds the current tax rate to the price.
     * @param finalSaleInfo the information of the sale that was finished.
     */
    public TotalPrice(AmountOfMoney finalSaleInfo) {
		price = finalSaleInfo;
                Tax taxRate = new Tax();
                tax = taxRate.getCurrenttaxRates();
               addTax();
	}

	private void addTax() {
            price.updateAmount(price.getAmount()*tax);
	}

    /**
     * Changes the price with the amount specified by the provided discount object.
     * @param discount the provided discount.
     */
    public void applyDiscount(Discount discount) {
            price.updateAmount(price.getAmount()*discount.getDiscount());
	}

    /**
     * *Gets the current price.
     * @return
     */
    public AmountOfMoney getPrice() {
		return price;
	}

}
