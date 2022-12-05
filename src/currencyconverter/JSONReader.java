/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class JSONReader {
    private String jsonString = "";
    private double quote = 0;
    private boolean success = false;
    
    public JSONReader(BufferedReader in)
    {
        String inputLine;
        try {
            while((inputLine = in.readLine()) != null)
            {
                jsonString += inputLine + "\n";
                if(inputLine.contains("\"quote\""))
                     quote = Double.parseDouble(inputLine.substring(inputLine.lastIndexOf(": ") + 1));
                if(inputLine.contains("\"success\""))
                     success = Boolean.parseBoolean(inputLine.substring(inputLine.lastIndexOf(": ") + 1));
                
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double getQuote()
    {
        return quote;
    }
}
