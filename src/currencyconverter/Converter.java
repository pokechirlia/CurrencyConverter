/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Converter {
    public Converter(){
        try {
            URL url = new URL("https://api.apilayer.com/currency_data/convert?to=VND&from=AUD&amount=5");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestProperty("apikey", "boDU9Vlt8MUpJLStiXGWzZgRCqTgLUiA");
            con.setRequestMethod("GET");
            
            con.connect();
            
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            
            if(responseCode == 200)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                //StringBuffer response = new StringBuffer();
                String inputLine;
                while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
