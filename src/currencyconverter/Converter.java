/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Converter {
    
    double result = 0;
    public Converter(String fromCurrency, String toCurrency, double amount){
        
        String urlString = "https://api.apilayer.com/currency_data/convert?to=" + toCurrency + "&from=" + fromCurrency + "&amount=" + amount;
        
        
        System.out.println("THE URLSTRING IS " + urlString);
        try {
            File keyFile = new File("key.txt");
            Scanner scanner = new Scanner(keyFile);
            String APIkey = scanner.nextLine();
            
            //URL url = new URL("https://api.apilayer.com/currency_data/convert?to=VND&from=AUD&amount=1.0");
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestProperty("apikey", APIkey);
            con.setRequestMethod("GET");
            
            con.connect();
            
            int responseCode = con.getResponseCode();
            //System.out.println(responseCode);
            
            //System.out.println(APIkey);
            
            if(responseCode == 200)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                //StringBuffer response = new StringBuffer();
                JSONReader reader = new JSONReader(in);
                
                result = reader.getQuote();
                
            }
                
            } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double getResult(){
        return result;
    }
    
}
