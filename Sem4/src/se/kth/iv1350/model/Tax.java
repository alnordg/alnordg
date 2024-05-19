package se.kth.iv1350.model;

import se.kth.iv1350.integration.TaxRates;

/**
 *
 */
public class Tax {

	private double currenttaxRates = 1.25;

    /**
     * Initializes the Tax class
     */
    public Tax() {
        
	}
        
        
/*      
        
	public SaleInformation addTax(SaleInformation saleInfo) {
		return null;
	}
*/

    /**
     *  Returns the current tax rate
     * @return the current tax rate
     */


    public double getCurrenttaxRates() {
        return currenttaxRates;
    }
}
