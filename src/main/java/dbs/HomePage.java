package dbs;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public void navigateToCreditCards() {
		clickCardTab();
		clickCreditCardTab();
	}
	public void clickCardTab() {
		click("//div[contains(@class,'navbar-links-left')]//a[text()='Cards']");
	}
	public void clickCreditCardTab() {
		click("//a[text()='Credit Cards']");
	}
}
