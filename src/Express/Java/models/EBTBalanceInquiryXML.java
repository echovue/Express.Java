package Express.Java.models;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.PrintWriter;
import java.io.StringWriter;

@XmlRootElement(name = "EBTBalanceInquiry", namespace = "https://transaction.elementexpress.com")
public class EBTBalanceInquiryXML {

	@XmlElement(name = "Credentials")
	public Express.Java.models.Credentials Credentials;
	@XmlElement(name = "Application")
	public Express.Java.models.Application Application;
	@XmlElement(name = "Terminal")
	public Express.Java.models.Terminal Terminal;
	@XmlElement(name = "Card")
	public Express.Java.models.Card Card;
	@XmlElement(name = "Transaction")
	public Express.Java.models.Transaction Transaction;
	@XmlElement(name = "EBT")
	public Express.Java.models.EBT EBT;
	
	
	public static EBTBalanceInquiryXML GetEBTBalance(ConfigurationData configData)
	{
		EBTBalanceInquiryXML ebtBalanceInquiry = new EBTBalanceInquiryXML();
		ebtBalanceInquiry.Credentials = new Credentials();
		ebtBalanceInquiry.Credentials.AccountID = configData.AccountID;
		ebtBalanceInquiry.Credentials.AccountToken = configData.AccountToken;
		ebtBalanceInquiry.Credentials.AcceptorID = configData.AcceptorID;
		ebtBalanceInquiry.Application = new Application();
		ebtBalanceInquiry.Application.ApplicationID = configData.ApplicationID;
		ebtBalanceInquiry.Application.ApplicationVersion = configData.ApplicationVersion;
		ebtBalanceInquiry.Application.ApplicationName = configData.ApplicationName;
		
		ebtBalanceInquiry.Terminal = new Terminal();
		ebtBalanceInquiry.Terminal.TerminalID = "01";
		ebtBalanceInquiry.Terminal.CardholderPresentCode = "2";
		ebtBalanceInquiry.Terminal.CardInputCode = "5";
		ebtBalanceInquiry.Terminal.TerminalCapabilityCode = "3";
		ebtBalanceInquiry.Terminal.TerminalEnvironmentCode = "2";
		ebtBalanceInquiry.Terminal.CardPresentCode = "2";
		ebtBalanceInquiry.Terminal.MotoECICode = "1";
		ebtBalanceInquiry.Terminal.CVVPresenceCode = "1";
		
		ebtBalanceInquiry.Card = new Card();
		ebtBalanceInquiry.Card.CardNumber = "5076800001111113";
		ebtBalanceInquiry.Card.ExpirationMonth = "12";
		ebtBalanceInquiry.Card.ExpirationYear = "19";
		ebtBalanceInquiry.Card.PINBlock = "1234";
		ebtBalanceInquiry.Card.KeySerialNumber = "AAA";
		
		ebtBalanceInquiry.Transaction = new Transaction();
		ebtBalanceInquiry.Transaction.TransactionAmount = "0";
		ebtBalanceInquiry.Transaction.MarketCode = "7";

		ebtBalanceInquiry.EBT = new EBT();
		ebtBalanceInquiry.EBT.EBTTypeIndex = "1";
		
		return ebtBalanceInquiry;
	}
	
	public static String EBTBalanceInquiryToXML(EBTBalanceInquiryXML ebtBalanceInquiry) {
		String xmlString = "";
		
		try {					
			JAXBContext jaxbContext = JAXBContext.newInstance(EBTBalanceInquiryXML.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(ebtBalanceInquiry, sw);
			xmlString = sw.toString();
		}
		catch (Exception ex)
		{
		     final StringWriter sw = new StringWriter();
		     final PrintWriter pw = new PrintWriter(sw, true);
		     ex.printStackTrace(pw);
		     xmlString = sw.getBuffer().toString();		   
		}
		
        return xmlString;
	}	
	
	
}
