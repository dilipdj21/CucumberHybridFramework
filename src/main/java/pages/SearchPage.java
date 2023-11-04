package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement ProductDisplay;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatchingWarning;

	public boolean getValidProduct() {
//		return elementUtils.displayStatusOfElement(ProductDisplay, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return ProductDisplay.isDisplayed();
	}

	public String getNoProductMatchingMessage() {
		return elementUtils.getTextFromElement(noProductMatchingWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
