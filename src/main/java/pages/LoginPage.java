package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginbutton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;

	public void enterEmailId(String emailtext) {
//		email.sendKeys(emailtext);
		elementUtils.typeTextIntoElement(email, emailtext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String passwordtext) {
		elementUtils.typeTextIntoElement(password, passwordtext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnLogin() {
		elementUtils.clickOnElement(loginbutton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
}
