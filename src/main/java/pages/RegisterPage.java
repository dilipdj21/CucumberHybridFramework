package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstname;

	@FindBy(id = "input-lastname")
	private WebElement lasttname;

	@FindBy(id = "input-email")
	private WebElement emailaddress;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmpassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacypolicyOption;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement newsLetter;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailAddressWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public void enterfirstname(String firstnametext) {
		elementUtils.typeTextIntoElement(firstname, firstnametext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterlastName(String lastnametext) {
		elementUtils.typeTextIntoElement(lasttname, lastnametext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enteremailAddress(String emailtext) {
		elementUtils.typeTextIntoElement(emailaddress, emailtext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void entertelephone(String telephonenumber) {
		elementUtils.typeTextIntoElement(telephone, telephonenumber, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterpassword(String passwordtext) {
		elementUtils.typeTextIntoElement(password, passwordtext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterconfirmpassword(String confirmpasswordtext) {
		elementUtils.typeTextIntoElement(confirmpassword, confirmpasswordtext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickoNPrivacyPolicy() {
		elementUtils.clickOnElement(privacypolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnNewsLetter() {
		elementUtils.clickOnElement(newsLetter, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getFirstnameWarningMessage() {
		return elementUtils.getTextFromElement(firstnameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getLastnameWarningMessage() {
		return elementUtils.getTextFromElement(lastnameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getEmailWarningMessage() {
		return elementUtils.getTextFromElement(emailAddressWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getTelephoneWarningMessage() {
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getPasswordWarningMessage() {
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
