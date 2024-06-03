package se.kth.iv1350.view;

import java.time.LocalDateTime;
import se.kth.iv1350.utilities.LogToFile;
import se.kth.iv1350.utilities.AmountOfMoney;
import se.kth.iv1350.model.PaymentObserver;

public class PrintRevenueToFile implements PaymentObserver {
    private AmountOfMoney total = new AmountOfMoney(0);
    private int transactionNO = 0;

    @Override
    public void newPayment(AmountOfMoney amountPaid) {
        total.add(amountPaid);
        transactionNO++;
        LogToFile log = new LogToFile("revenueLog.txt");
        log.writeToFile(total.toString() + " Transaction: " + transactionNO + " at:" + LocalDateTime.now());
    }
}
