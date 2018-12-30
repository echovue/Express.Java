package Express.Java.models;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.PrintWriter;
import java.io.StringWriter;

@XmlRootElement(name = "EBTSale", namespace = "https://transaction.elementexpress.com")
public class EBTSaleXML {

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

	public static EBTSaleXML GetEBTSale(ConfigurationData configData)
	{
		EBTSaleXML ebtCardSale = new EBTSaleXML();
		ebtCardSale.Credentials = new Credentials();
		ebtCardSale.Credentials.AccountID = configData.AccountID;
		ebtCardSale.Credentials.AccountToken = configData.AccountToken;
		ebtCardSale.Credentials.AcceptorID = configData.AcceptorID;
		ebtCardSale.Application = new Application();
		ebtCardSale.Application.ApplicationID = configData.ApplicationID;
		ebtCardSale.Application.ApplicationVersion = configData.ApplicationVersion;
		ebtCardSale.Application.ApplicationName = configData.ApplicationName;

		ebtCardSale.Terminal = new Terminal();
		ebtCardSale.Terminal.TerminalID = "01";
		ebtCardSale.Terminal.CardholderPresentCode = "2";
		ebtCardSale.Terminal.CardInputCode = "5";
		ebtCardSale.Terminal.TerminalCapabilityCode = "3";
		ebtCardSale.Terminal.TerminalEnvironmentCode = "2";
		ebtCardSale.Terminal.CardPresentCode = "2";
		ebtCardSale.Terminal.MotoECICode = "1";
		ebtCardSale.Terminal.CVVPresenceCode = "1";

		ebtCardSale.Card = new Card();
		ebtCardSale.Card.CardNumber = "5076800001111113";
		ebtCardSale.Card.ExpirationMonth = "12";
		ebtCardSale.Card.ExpirationYear = "19";
		ebtCardSale.Card.PINBlock = "1234";
		ebtCardSale.Card.KeySerialNumber = "AAA";

		ebtCardSale.Transaction = new Transaction();
		ebtCardSale.Transaction.TransactionAmount = "6.55";
		ebtCardSale.Transaction.MarketCode = "7";

		ebtCardSale.EBT = new EBT();
		ebtCardSale.EBT.EBTTypeIndex = "1";

		return ebtCardSale;
	}
	
	public static String EBTCardSaleToXML(EBTSaleXML ebtCardSale) {
		String xmlString = "";
		
		try {					
			JAXBContext jaxbContext = JAXBContext.newInstance(EBTSaleXML.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(ebtCardSale, sw);
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
