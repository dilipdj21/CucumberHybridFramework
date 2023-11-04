package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	RegisterPage registerpage;

	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getdriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable datatable) {
		Map<String, String> datamap = datatable.asMap(String.class, String.class);
		registerpage = new RegisterPage(driver);
		registerpage.enterfirstname(datamap.get("firstname"));
		registerpage.enterlastName(datamap.get("lasttname"));
		registerpage.enteremailAddress(CommonUtils.getEmailWithTimeStamp());
		registerpage.entertelephone(datamap.get("telephone"));
		registerpage.enterpassword(datamap.get("passwrod"));
		registerpage.enterconfirmpassword(datamap.get("confirmpassword"));
	}

	@When("User enters the details into below fields with duplicate email")
	public void User_enters_the_details_into_below_fields_with_duplicate_email(DataTable datatable) {
		Map<String, String> datamap = datatable.asMap(String.class, String.class);
		registerpage = new RegisterPage(driver);
		registerpage.enterfirstname(datamap.get("firstname"));
		registerpage.enterlastName(datamap.get("lasttname"));
		registerpage.enteremailAddress(datamap.get("email"));
		registerpage.entertelephone(datamap.get("telephone"));
		registerpage.enterpassword(datamap.get("passwrod"));
		registerpage.enterconfirmpassword(datamap.get("confirmpassword"));
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerpage = new RegisterPage(driver);
		registerpage.clickoNPrivacyPolicy();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		registerpage = new RegisterPage(driver);
		registerpage.clickOnContinueButton();

	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountsuccesspage.getPageHeading());
	}

	@And("User selects Yes for news letter")
	public void user_selects_yes_for_news_letter() {
		registerpage = new RegisterPage(driver);
		registerpage.clickOnNewsLetter();
	}

	@Then("User account should get a proper warning message")
	public void user_account_should_get_a_proper_warning_message() {
		registerpage = new RegisterPage(driver);
		Assert.assertTrue(
				registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User doesnt enter any details into fields")
	public void user_doesnt_enter_any_details_into_fields() {
		registerpage = new RegisterPage(driver);
	}

	@Then("User account should get a proper warning message for mandatory fields")
	public void user_account_should_get_a_proper_warning_message_for_mandatory_fields() {
		registerpage = new RegisterPage(driver);
		Assert.assertTrue(
				registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerpage.getFirstnameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastnameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerpage.getTelephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordWarningMessage());
	}

}
