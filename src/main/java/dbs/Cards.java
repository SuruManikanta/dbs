package dbs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import base.BasePage;

public class Cards extends BasePage{
	public Cards(WebDriver driver) {
		super(driver);
	}
	public void navigateToCreditCards() {
		click("//div[contains(@class,'navbar-links-left')]//a[text()='Cards']");
		click("//a[text()='Credit Cards']");
	}
	public void compareCards(String card1,String card2) throws InterruptedException {
		navigateToCreditCards();
		Thread.sleep(3000);
		click("//div[text()='"+card1+"']//ancestor::div[@class='cardContainer']//label");
		click("//div[text()='"+card2+"']//ancestor::div[@class='cardContainer']//label");
		click("//button[@id='cardCompareBtn']");
	}
	public void verifyCardDetails(String card,String cardDetails) {
		String actualCardDetails = getDisplayedText("//div[text()='"+card+"']//ancestor::div[contains(@id,'card')]//div[@class='section-seperator'][1]");
		String expectedCardDetails[] = cardDetails.split(";");
		for (String expected : expectedCardDetails) {
			if(!actualCardDetails.contains(expected)) {
				Reporter.log("Failed to display Card-"+card+" details : "+expected+"\n", true);
				Assert.fail("Failed to display Card-"+card+" details : "+expected);
			}
			Reporter.log("Successfully displayed card details : "+expected+" of card - "+card+"\n", true);
		}

	}
}