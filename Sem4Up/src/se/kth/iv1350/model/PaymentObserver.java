/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.model;

import se.kth.iv1350.utilities.AmountOfMoney;

/**
 *
 */
public interface PaymentObserver {
    void newPayment(AmountOfMoney amountPaid);
}
