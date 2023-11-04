package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement searchButton;

	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnLogin() {
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnRegister() {
		elementUtils.clickOnElement(register, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterValidSearch(String validProductText) {
		elementUtils.typeTextIntoElement(searchBoxField, validProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterInValidSearch(String invalidProductText) {
		elementUtils.typeTextIntoElement(searchBoxField, invalidProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
