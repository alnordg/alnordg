package se.kth.iv1350.startup;

import se.kth.iv1350.utilities.LogToFile;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import se.kth.iv1350.view.View;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.RegistryCreator;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.DatabaseFailureException;

/**
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        RegistryCreator registries = new RegistryCreator();

        Printer printer = new Printer();

        Controller contr = new Controller(registries, printer);

        View view = new View(contr);
        LogToFile logger = new LogToFile("log.txt");

        try {
            view.sampleExcecution();
        } catch (Exception e) {
            System.out.flush();
            System.err.println(e);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            logger.writeToFile(stackTrace + "     This occurred at: " + LocalDateTime.now());
        }

    }
}
