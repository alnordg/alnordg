package model;

/**
 * A listener interface for objects that handle sales and payments.
 */
public interface SaleObserver {
    /**
     * Called when a payment occurs.
     * @param amount The amount that was paid.
     */
    void newPayment(double amount);

    /**
     * Called when a new sale occurs.
     * @param totalPrice The total price of the sale.
     */
    void newSale(double totalPrice);
}
