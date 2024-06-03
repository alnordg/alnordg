package se.kth.iv1350.controller;

import se.kth.iv1350.integration.DatabaseFailureException;
import se.kth.iv1350.utilities.TotalPriceDTO;
import se.kth.iv1350.utilities.SaleDTO;
import se.kth.iv1350.utilities.AmountOfMoney;
import se.kth.iv1350.model.CashRegister;
import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.InsufficientFundsException;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.Item;
import se.kth.iv1350.integration.RegistryCreator;
import se.kth.iv1350.integration.ItemNotFoundException;
import se.kth.iv1350.model.PaymentObserver;

public class Controller {
    private Sale sale;
    private RegistryCreator registryCreator;
    private Receipt reciept;
    private Printer printer;
    private CashRegister cashRegister;
    private AmountOfMoney startingBalance = new AmountOfMoney(100);

    public void startNewSale() {
        sale = new Sale(cashRegister);
    }

    public Controller(RegistryCreator registers, Printer printer) {
        registryCreator = registers;
        this.printer = printer;
        cashRegister = new CashRegister(startingBalance);
    }

    public SaleDTO scanItem(int quantity, int itemID) throws ItemNotFoundException, DatabaseFailureException {
        Item scannedItem = (registryCreator.getItemRegistry()).getItem(itemID);
        return sale.sellItem(quantity, scannedItem);
    }

    public SaleDTO scanItem(int itemID) throws ItemNotFoundException, DatabaseFailureException {
        return scanItem(1, itemID);
    }

    public TotalPriceDTO finalizeSale() {
        return sale.finalizeSale();
    }

    public TotalPriceDTO isEligibleForDiscount(int customerID) {
        return sale.getDiscount(registryCreator.getDiscountRegistry().getDiscount(customerID));
    }

    public AmountOfMoney pay(AmountOfMoney paidAmount) throws InsufficientFundsException {
        AmountOfMoney change = sale.payForSale(paidAmount);
        SaleDTO finalSaleInformation = sale.getSaleData();
        reciept = new Receipt(finalSaleInformation, change, paidAmount);
        registryCreator.getExternalSystems().updateAccountingSystem(finalSaleInformation);
        registryCreator.getExternalSystems().updateInventorySystem(finalSaleInformation);
        printer.printReciept(reciept);
        return change;
    }

    public AmountOfMoney getCashRegisterBalance() {
        return cashRegister.getBalance();
    }

    public void addObserver(PaymentObserver observer) {
        cashRegister.setObserver(observer);
    }
}
