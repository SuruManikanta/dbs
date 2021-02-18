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
	public void compareCards(String card1,String card2){
		try {
			wait(3000);
			click(getCard(card1));
			click(getCard(card2));
			click("//button[@id='cardCompareBtn']");
		}
		catch(Exception e) {
			Reporter.log(e.getMessage());
		}
	}
	public String getCard(String card) {
		return "//div[text()='"+card+"']//ancestor::div[@class='cardContainer']//label";
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