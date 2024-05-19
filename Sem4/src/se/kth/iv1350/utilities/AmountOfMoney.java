package se.kth.iv1350.utilities;

/**
 *
 */
public class AmountOfMoney {

    private String currency;

    private double amount;

    /**
     * Gets the amount of money.
     * @return the amount of money
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the currency
     * @return the currency of this amount.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Updated the amount contained to a new amount.
     * @param newAmount the new amount that the object is to be set to.
     */
    public void updateAmount(double newAmount) {
        amount = newAmount;
    }

    /**
     * Adds an amount of money to this amount.
     * @param addition the amount to be added.
     */
    public void add(AmountOfMoney addition) {
        amount += addition.getAmount();
    }

    /**
     *This is the default constructor for this object. It sets the amount contained and sets the currency to a default value.
     * @param startingAmount the starting value for this AmountOfMoney
     */
    public AmountOfMoney(double startingAmount) {
        amount = startingAmount;
        currency = "sek";
    }

    /**
     * This is an alternate constructor where you can specify the currency to be used.
     * @param startingAmount the starting value.
     * @param currency the currency this amount is in.
     */
    public AmountOfMoney(double startingAmount, String currency) {
        amount = startingAmount;
        this.currency = currency;
    }

    public String toString() {
        return String.format("%.2f", this.amount) + " " + currency;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof AmountOfMoney) {
            AmountOfMoney comparedAmountOfMoney= (AmountOfMoney) o;
            return amount == comparedAmountOfMoney.getAmount();
        }
        return false;
    }

}
