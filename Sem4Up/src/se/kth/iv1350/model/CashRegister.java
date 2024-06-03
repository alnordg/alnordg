package se.kth.iv1350.model;

import se.kth.iv1350.utilities.AmountOfMoney;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles payments. 
 * It contains a balance that is consistent between transactions. 
 */
public class CashRegister {

    private AmountOfMoney balance;
    private List<PaymentObserver> revenueObservers = new ArrayList<>();

    /**
     * This method receives an amount of money from the customer as well as how much is to be paid.
     * It calls any observers it has with the data it received.
     * @param amountPaid the amount of money paid by the customer.
     * @param finalPrice the price to be paid.
     * @return the difference between the two amounts. The change given back to the customer.
     * @throws se.kth.iv1350.model.InsufficientFundsException
     */
    public AmountOfMoney registerPayment(AmountOfMoney amountPaid, AmountOfMoney finalPrice) throws InsufficientFundsException {

        AmountOfMoney change = calculateChange(amountPaid, finalPrice);
        for(PaymentObserver display:revenueObservers){
        display.newPayment(finalPrice);
        }
        return change;

    }

    private AmountOfMoney calculateChange(AmountOfMoney amountPaid,AmountOfMoney finalPrice) throws InsufficientFundsException {
        double change = amountPaid.getAmount() - finalPrice.getAmount();
        
        if (change < 0) {
            String errorMessage = "You did not pay enough money, you are missing " + new AmountOfMoney(-change, amountPaid.getCurrency()).toString();
            throw new InsufficientFundsException(errorMessage);
        }
        System.out.println(finalPrice);
        updateBalance(finalPrice);
        return new AmountOfMoney(change);
    }

    /**
     * Updates the amount of money in the cash register. 
     * It checks if the amount entered is more than 0, and if not it will throw an exception.
     * @param totalPrice the amount of money to be added to the cash register.
     * @throws InvalidParameterException
     */
    public void updateBalance(AmountOfMoney totalPrice) throws InvalidParameterException {
        if (totalPrice.getAmount() < 0) {
            throw new InvalidParameterException("Not possible to add a negative amount");
        }
        balance.add(totalPrice);
    }

    /**
     * This initializes the cash register and sets its starting balance.
     *
     * @param balance is used to set the starting balance.
     */
    public CashRegister(AmountOfMoney balance) {
        this.balance = balance;
    }
    /**
     * Second constructor that takes and implementation of the the TotalRevenueView and adds it to the list of observers.
     * @param balance is used to set the starting balance
     * @param view is used to display something from the program.
     */
    public CashRegister(AmountOfMoney balance,PaymentObserver view) {
        this.balance = balance;
        this.revenueObservers.add(view);
    }
    /**
     * Adds an observer to the list.
     * @param viewer the observer that is to be added;
     */
    public void setObserver(PaymentObserver viewer){
        this.revenueObservers.add(viewer);
    }

    /**
     * Returns the current balance.
     * @return the current balance.
     */
    public AmountOfMoney getBalance() {
        return balance;
    }

}
