package se.kth.iv1350.integration;
import se.kth.iv1350.utilities.Discount;
import java.util.*;
/*


*/

/**
 *This class is a mock database containing  customer IDs and their associated discounts.
 */

public class DiscountRegistry {
        private static final DiscountRegistry DISCOUNT_REGISTRY = new DiscountRegistry();
	private HashMap<Integer,Double> elligibleID;

    /**
     *
     * This method is used to find discounts associated with the provided ID.
     * 
     * @param customerID is the ID which is used to check if the customer is eligible for a discount
     * @return the discount associated with this ID. "1" is returned if the customer is not in the database.
     */
    public Discount getDiscount(int customerID) {
                Integer ID = new Integer(customerID);
		if(elligibleID.containsKey(ID)){

                    return new Discount(elligibleID.get(ID));
                }else{
                    return new Discount(1);
                }
	}

    /**
     *This method initializes the database.
     */
    private DiscountRegistry() {
            elligibleID = new HashMap<Integer, Double>();
           elligibleID.put(new Integer(19931128), 0.1);
           elligibleID.put(new Integer(19980523), 0.5);
           elligibleID.put(new Integer(19960709), 0.85);
           elligibleID.put(new Integer(19940613), 0.99);
           elligibleID.put(new Integer(19911121), 1.11);

	}
    public static DiscountRegistry getInstance(){
        return DISCOUNT_REGISTRY;
    }
}
