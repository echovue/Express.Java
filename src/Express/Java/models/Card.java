package Express.Java.models;

import javax.xml.bind.annotation.XmlElement;

public class Card {
	@XmlElement(name = "CardNumber")
	public String CardNumber;
	@XmlElement(name = "ExpirationMonth")
	public String ExpirationMonth;
	@XmlElement(name = "ExpirationYear")
	public String ExpirationYear;
	@XmlElement(name = "PINBlock")
	public String PINBlock;
	@XmlElement(name = "KeySerialNumber")
	public String KeySerialNumber;
}
