package integration;

import model.Sale;

/**
 * Represents the Accounting system of a grocery store.
 * 
 */
public class AccountingSystem {
        /**
         * Creates an instance of the accounting system
         */
	public AccountingSystem() {
		
	}
	/**
         * Saves the information about the sale in the accountingsystem
         * @param sale contains all information about the sale
         */
	public void saveSaleInformation(Sale sale) {
            System.out.println("(Accountingsystem updated)");
	}
}
