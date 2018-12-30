package Express.Java.listeners;


import Express.Java.models.ConfigurationData;
import Express.Java.models.EBTBalanceInquiryXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopulateEBTBalanceInquiryXMLActionListener implements ActionListener{
	    private JTextArea txtRequest;
	    private ConfigurationData configData;

	    public PopulateEBTBalanceInquiryXMLActionListener(JTextArea txtRequest, ConfigurationData configData) {
	        super();
	        this.txtRequest = txtRequest;
	        this.configData = configData;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
			
			try { 
	            this.configData.SoapAction = null;
	            
				this.txtRequest.setText(EBTBalanceInquiryXML.EBTBalanceInquiryToXML(EBTBalanceInquiryXML.GetEBTBalance(this.configData)));
				
				} 
				catch (Exception ex) {  
					this.txtRequest.setText(ex.getMessage());
				}
	    }
}
