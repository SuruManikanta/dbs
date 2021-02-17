package dbs;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseSetup;

public class CompareCreditCards extends BaseSetup{
	private WebDriver driver;
	private Cards cards;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void compareCreditCardsDetails() throws InterruptedException {
		cards = new Cards(driver);
		cards.compareCards("DBS Altitude Visa Signature Card", "DBS Black Visa Card");
		cards.verifyCardDetails("DBS Altitude Visa Signature Card","It's the fastest way to fly anywhere;VISA;S$30,000;S$45,000;1 Year");
		cards.verifyCardDetails("DBS Black Visa Card","Shopping is the new black;VISA;S$30,000;S$45,000;1 Year");
	}
	
}
