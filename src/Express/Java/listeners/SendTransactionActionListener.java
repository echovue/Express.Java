package Express.Java.listeners;


import Express.Java.models.ConfigurationData;
import Express.Java.HttpSender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class SendTransactionActionListener implements ActionListener{

    private ConfigurationData configData;
    private JTextArea txtRequest;
    private JTextArea txtResponse;

    public SendTransactionActionListener(ConfigurationData configData, JTextArea txtRequest, JTextArea txtResponse) {
        super();
        this.configData = configData;
        this.txtResponse = txtResponse;
        this.txtRequest = txtRequest;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	String response = "";
    	
		try {
			String url = "";
			if (configData.SoapAction == null) {
				url = configData.ExpressXMLEndpoint;
			} else {
				url = configData.ExpressSOAPEndpoint;
			}
			
			response = HttpSender.SendData(url, configData.SoapAction, this.txtRequest.getText());
		} 
		catch (Exception ex) { 
			response = "Exception: " + ex.getMessage(); 
		}
		
		this.txtResponse.setText(response);
    }

}
