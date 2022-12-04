/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class CurrencyConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("a");
        CurrencyConverter obj = new CurrencyConverter();
        obj.createInterface();
        obj.runConverter();
        
        
    }
    
    public void runConverter(){
        try {
            Converter converter = new Converter();
        } catch (Exception ex) {
            //Logger.getLogger(CurrencyConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createInterface(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppDialogInterface dialog = new AppDialogInterface(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
}
