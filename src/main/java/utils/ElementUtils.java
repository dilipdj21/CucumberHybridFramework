package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, long durationinseconds) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}

	public void clickOnElement(WebElement element, long durationinseconds) {

		WebElement webelement = waitForElement(element, durationinseconds);
		webelement.click();
	}

	public void typeTextIntoElement(WebElement element, String texttobetyped, long durationinseconds) {

		WebElement webelement = waitForElement(element, durationinseconds);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
//		WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webelement.click();
		webelement.clear();
		webelement.sendKeys(texttobetyped);
	}

	public void selectOptionInDropdownw(WebElement element, String dropdownoption, long durationinseconds) {

		WebElement webelement = waitForElement(element, durationinseconds);
		Select select = new Select(webelement);
//		select.selectByIndex(dropdownoption);
		select.selectByVisibleText(dropdownoption);
//		select.selectByValue(dropdownoption);		
	}

	public Alert waitForAlerts(long durationinseconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void acceptAlert(long durationinseconds) {

		Alert alert = waitForAlerts(durationinseconds);
		alert.accept();
	}

	public void dismissAlert(long durationinseconds) {
		Alert alert = waitForAlerts(durationinseconds);
		alert.dismiss();
	}

	public WebElement waitForVisibilityOFElement(WebElement element, long durationinseconds) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
			webelement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}

	public void mouseHoverAndClick(WebElement element, long durationinseconds) {

		WebElement webelement = waitForVisibilityOFElement(element, durationinseconds);
		Actions action = new Actions(driver);
		action.moveToElement(webelement).click().build().perform();
	}

	public void javaSCriptClick(WebElement element, long durationinseconds) {
		WebElement webelement = waitForVisibilityOFElement(element, durationinseconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", webelement);
	}

	public void javaScriptType(WebElement element, long durationinseconds, String textToBeTyped) {

		WebElement webelement = waitForVisibilityOFElement(element, durationinseconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webelement);
	}

	public String getTextFromElement(WebElement element, long durationinseconds) {
		WebElement webelement = waitForElement(element, durationinseconds);
		return webelement.getText();
	}

	public boolean displayStatusOfElement(WebElement element, long durationinseconds) {
		try {
			WebElement webelement = waitForVisibilityOFElement(element, durationinseconds);
			webelement.isDisplayed();
		} catch (Throwable e) {
			e.printStackTrace();
//			return false;
		}
		return false;
	}

}
