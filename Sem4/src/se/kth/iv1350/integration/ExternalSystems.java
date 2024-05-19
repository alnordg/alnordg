package se.kth.iv1350.integration;

import se.kth.iv1350.utilities.SaleDTO;
import se.kth.iv1350.model.Receipt;

/**
 *This class represents external systems, ie. the accounting system and the inventory system.
 */
public class ExternalSystems {

    /**
     * Does nothing as we are not to interact with an actual system.
     * @param saleInformation final sale information used to update the system.
     */
    public void updateInventorySystem(SaleDTO saleInformation) {

	}

    /**
     * Does nothing as we are not to interact with an actual system.
     * @param saleInformation final sale information used to update the system.
     */
    public void updateAccountingSystem(SaleDTO saleInformation) {

	}

    /**
     * Initializes the external systems.
     */
    public ExternalSystems(){
        
	}


}
