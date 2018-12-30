package Express.Java.listeners;

import Express.Java.models.ConfigurationData;
import Express.Java.models.EBTSaleXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopulateEBTCardSaleXMLActionListener implements ActionListener{
	    private JTextArea txtRequest;
	    private ConfigurationData configData;

	    public PopulateEBTCardSaleXMLActionListener(JTextArea txtRequest, ConfigurationData configData) {
	        super();
	        this.txtRequest = txtRequest;
	        this.configData = configData;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
			
			try { 
	            this.configData.SoapAction = null;
	            
				this.txtRequest.setText(EBTSaleXML.EBTCardSaleToXML(EBTSaleXML.GetEBTSale(this.configData)));
				
				} 
				catch (Exception ex) {  
					this.txtRequest.setText(ex.getMessage());
				}
	    }
}
