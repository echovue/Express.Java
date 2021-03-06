package Express.Java;
import Express.Java.listeners.ClearDataActionListener;
import Express.Java.listeners.PopulateCreditCardSaleSOAPActionListener;
import Express.Java.listeners.PopulateCreditCardSaleXMLActionListener;
import Express.Java.listeners.PopulateEBTBalanceInquiryXMLActionListener;
import Express.Java.listeners.PopulateEBTCardSaleXMLActionListener;
import Express.Java.listeners.PopulateHealthCheckSOAPActionListener;
import Express.Java.listeners.PopulateHealthCheckXMLActionListener;
import Express.Java.listeners.SendTransactionActionListener;
import Express.Java.models.ConfigurationData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ExpressMain extends JFrame {

	private JPanel contentPane;
	private ConfigurationData configData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpressMain frame = new ExpressMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExpressMain() {
		
		URL configFile = ExpressMain.class.getClass().getResource("/config.cfg");
        try {
            InputStream configFileStream = configFile.openStream();
            Properties p = new Properties();
            p.load(configFileStream);
            configFileStream.close();

            configData = new ConfigurationData();
            
            configData.AccountID= (String)p.get("AccountID");
            configData.AccountToken= (String)p.get("AccountToken");
            configData.AcceptorID= (String)p.get("AcceptorID");
            configData.ApplicationID= (String)p.get("ApplicationID");
            configData.ApplicationVersion= (String)p.get("ApplicationVersion");
            configData.ApplicationName= (String)p.get("ApplicationName");
            configData.ExpressSOAPEndpoint= (String)p.get("ExpressSOAPEndpoint");
            configData.ExpressXMLEndpoint= (String)p.get("ExpressXMLEndpoint");  
            configData.SoapAction = null;
        	
        } catch (Exception e) {  
            System.out.println("error reading from config file");
            System.exit(1);
        }
        
		setTitle("Express.Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 890);
		getContentPane().setLayout(null);	
		
		
		JLabel lblRequest = new JLabel("Request:");
		lblRequest.setBounds(10, 79, 86, 14);
		getContentPane().add(lblRequest);
			
		JTextArea txtRequest = new JTextArea();
		JScrollPane sp = new JScrollPane(txtRequest);
		sp.setBounds(10, 104, 750, 350);
		getContentPane().add(sp);
		
		JLabel lblResponse = new JLabel("Response:");
		lblResponse.setBounds(10, 464, 86, 14);
		getContentPane().add(lblResponse);
				
		JTextArea txtResponse = new JTextArea();
		JScrollPane sp2 = new JScrollPane(txtResponse);
		sp2.setBounds(10, 489, 750, 350);
		getContentPane().add(sp2);
		
		JButton btnSaleRequestXml = new JButton("Sale Request XML");
		btnSaleRequestXml.addActionListener(new PopulateCreditCardSaleXMLActionListener(txtRequest, configData));
		btnSaleRequestXml.setBounds(10, 11, 137, 23);
		getContentPane().add(btnSaleRequestXml);
		
		JButton btnSaleRequestSoap = new JButton("Sale Request SOAP");
		btnSaleRequestSoap.addActionListener(new PopulateCreditCardSaleSOAPActionListener(txtRequest, configData));
		btnSaleRequestSoap.setBounds(157, 11, 160, 23);
		getContentPane().add(btnSaleRequestSoap);

		JButton btnEBTBalanceInquiry = new JButton("EBT Balance Inquiry XML");
		btnEBTBalanceInquiry.addActionListener(new PopulateEBTBalanceInquiryXMLActionListener(txtRequest, configData));
		btnEBTBalanceInquiry.setBounds(327, 11, 180, 23);
		getContentPane().add(btnEBTBalanceInquiry);

		JButton btnSendTransaction = new JButton("Send Transaction");
		btnSendTransaction.addActionListener(new SendTransactionActionListener(configData, txtRequest, txtResponse));
		btnSendTransaction.setBounds(517, 11, 137, 23);
		getContentPane().add(btnSendTransaction);

		JButton btnHealthCheckXml = new JButton("Health Check XML");
		btnHealthCheckXml.addActionListener(new PopulateHealthCheckXMLActionListener(txtRequest, configData));
		btnHealthCheckXml.setBounds(10, 45, 137, 23);
		getContentPane().add(btnHealthCheckXml);
		
		JButton btnHealthCheckSoap = new JButton("Health Check SOAP");
		btnHealthCheckSoap.addActionListener(new PopulateHealthCheckSOAPActionListener(txtRequest, configData));
		btnHealthCheckSoap.setBounds(157, 45, 160, 23);
		getContentPane().add(btnHealthCheckSoap);

		JButton btnEBTSaleXML = new JButton("EBT Sale XML");
		btnEBTSaleXML.addActionListener(new PopulateEBTCardSaleXMLActionListener(txtRequest, configData));
		btnEBTSaleXML.setBounds(327, 45, 180, 23);
		getContentPane().add(btnEBTSaleXML);

		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addActionListener(new ClearDataActionListener(txtRequest, txtResponse));
		btnClearData.setBounds(517, 45, 137, 23);
		getContentPane().add(btnClearData);

	}
}
