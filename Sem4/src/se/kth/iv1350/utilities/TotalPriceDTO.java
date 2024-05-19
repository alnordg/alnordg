package se.kth.iv1350.utilities;

import se.kth.iv1350.model.TotalPrice;

/**
 * A DTO for the TotalPrice class.
 */
public class TotalPriceDTO {
    private final AmountOfMoney totalPrice;

    /**
     *Initializes the DTO
     * @param totalPrice
     */
    public TotalPriceDTO(TotalPrice totalPrice) {
        this.totalPrice = totalPrice.getPrice();
    }

    /**
     * returns the final price
     * @return
     */
    public AmountOfMoney getTotalPrice() {
        return totalPrice;
    }
    
    public String toString(){
        return totalPrice.toString();
    }
    
}
