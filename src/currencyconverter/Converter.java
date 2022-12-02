/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.net.MalformedURLException;
import java.net.URL;
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
            System.out.println("its running here");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
