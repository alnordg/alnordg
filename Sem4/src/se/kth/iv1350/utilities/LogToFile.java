/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is used to write to a file. 
 */
public class LogToFile {

    File log;
    
    /**
     *
     * @param fileName
     */
    public LogToFile(String fileName) {
        setFile(fileName);
    }
    
    /**
     * This method prints the received message to the file specified for the program.
     * @param message
     */
    public void writeToFile(String message) {
        try (FileWriter fw = new FileWriter(log, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter fileWriter = new PrintWriter(bw)) {
            fileWriter.println(message);

        } catch (IOException e) {
            System.err.println("ERROR WRITING TO FILE");
            System.err.println(e);
        }
    }
    
    public void setFile(String fileName){
        log = new File(fileName);
    }
}
