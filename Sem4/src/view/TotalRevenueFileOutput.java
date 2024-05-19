package view;
import java.io.*;

// Assuming SaleObserver is defined in model package
import model.SaleObserver;

/**
 * TotalRevenueFileOutput implements the interface SaleObserver.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue;
    private PrintWriter file;

    /**
     * Creates a new instance of TotalRevenueFileOutput and initializes the PrintWriter for file writing.
     */
    public TotalRevenueFileOutput() {
        try {
            // Create the file and ensure auto-flush for immediate writing
            File revenueFile = new File("revenue.txt");
            if (!revenueFile.exists()) {
                revenueFile.createNewFile();
            }
            this.file = new PrintWriter(new FileWriter(revenueFile, true), true);
            System.out.println("File 'revenue.txt' created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating or accessing file 'revenue.txt': " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Method to record a new sale event, updating total revenue and writing to file.
     * @param totalPrice The total price of the sale (including VAT)
     */
    @Override
    public void newSale(double totalPrice) {
        this.totalRevenue += totalPrice;
        this.file.println("Total Revenue: " + this.totalRevenue);
    }

    /**
     * Placeholder method for newPayment, currently unimplemented.
     * @param amount The payment amount
     */
    @Override
    public void newPayment(double amount) {
        throw new UnsupportedOperationException("Method 'newPayment' is not implemented.");
    }
}
