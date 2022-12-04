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
    public Converter() throws Exception{
        try {
            File keyFile = new File("key.txt");
            Scanner scanner = new Scanner(keyFile);
            String APIkey = scanner.nextLine();
            
            URL url = new URL("https://api.apilayer.com/currency_data/convert?to=VND&from=AUD&amount=5");
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
                
                System.out.println(reader.getQuote());
                
            }
                
            } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
