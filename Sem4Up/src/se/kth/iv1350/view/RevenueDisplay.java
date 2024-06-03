package se.kth.iv1350.view;

import se.kth.iv1350.utilities.AmountOfMoney;
import se.kth.iv1350.model.PaymentObserver;

public class RevenueDisplay implements PaymentObserver {
    private AmountOfMoney totalRevenue;

    public RevenueDisplay() {
        totalRevenue = new AmountOfMoney(0);
    }

    @Override
    public void newPayment(AmountOfMoney amountPaid) {
        totalRevenue.add(amountPaid);
        StringBuilder finalString = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int lengthOfSum = totalRevenue.toString().length();
        int width = lengthOfSum + 10;
        if (width < 15) {
            width = 15;
        }
        for (int i = 0; i < width; i++) {
            sb.append('#');
        }
        sb.append("\n");
        for (int j = 0; j < 3; j++) {
            sb.append("#");
            for (int i = 0; i < width - 2; i++) {
                sb.append(' ');
            }
            sb.append("#\n");
        }
        sb.append("#");
        int sideLength = (width - lengthOfSum) / 2;
        for (int i = 0; i < sideLength - 1; i++) {
            sb.append(' ');
        }
        sb.append(totalRevenue.toString());
        for (int i = 0; i < sideLength - 1; i++) {
            sb.append(' ');
        }
        sb.append("#\n");
        for (int j = 0; j < 3; j++) {
            sb.append("#");
            for (int i = 0; i < width - 2; i++) {
                sb.append(' ');
            }
            sb.append("#\n");
        }
        for (int i = 0; i < width; i++) {
            sb.append('#');
        }
        System.out.println(sb.toString());
    }
}
