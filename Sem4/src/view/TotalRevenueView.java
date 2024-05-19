package view;

import model.SaleObserver;

/**
 * TotalRevenueView implements SaleObserver to display and manage total revenue.
 */
public class TotalRevenueView implements SaleObserver {
    private double totalRevenue;

    /**
     * Initializes the TotalRevenueView with zero total revenue.
     */
    public TotalRevenueView() {
        this.totalRevenue = 0;
    }

    /**
     * Updates the total revenue with a new payment amount.
     * @param amount The amount paid.
     */
    @Override
    public void newPayment(double amount) {
        totalRevenue += amount;
        displayTotalRevenue();
    }

    /**
     * Displays the current total revenue.
     */
    private void displayTotalRevenue() {
        System.out.println("Total Revenue: " + Math.round(totalRevenue));
    }

    /**
     * Retrieves the current total revenue.
     * @return The total revenue.
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public void newSale(double totalPrice) {
        throw new UnsupportedOperationException("Unimplemented method 'newSale'");
    }
}
