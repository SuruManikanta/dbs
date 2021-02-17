package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	//Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}

	//Wait
	public void waitVisibility(By by){
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void click(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		waitVisibility(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public String getDisplayedText(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if(element.isDisplayed())
			return element.getText();
		else
			return null;
	}
}
