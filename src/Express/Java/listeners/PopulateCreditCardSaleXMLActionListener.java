package Express.Java.listeners;


import Express.Java.models.ConfigurationData;
import Express.Java.models.CreditCardSaleXML;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class PopulateCreditCardSaleXMLActionListener implements ActionListener{
	    private JTextArea txtRequest;
	    private ConfigurationData configData;

	    public PopulateCreditCardSaleXMLActionListener(JTextArea txtRequest, ConfigurationData configData) {
	        super();
	        this.txtRequest = txtRequest;
	        this.configData = configData;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
			
			try { 
	            this.configData.SoapAction = null;
	            
				this.txtRequest.setText(CreditCardSaleXML.CreditCardSaleToXML(CreditCardSaleXML.GetCreditCardSale(this.configData)));
				
				} 
				catch (Exception ex) {  
					this.txtRequest.setText(ex.getMessage());
				}
	    }
}
