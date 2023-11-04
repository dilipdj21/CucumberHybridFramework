package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		driver = DriverFactory.getdriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
	}

	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailtext) {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailId(emailtext);

	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordtext) {
		loginpage.enterPassword(passwordtext);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLogin();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		AccountPage accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.verifyDisplayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailId(CommonUtils.getEmailWithTimeStamp());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);

	}

	@Then("User should get a proper warning message about credential mismatch")
	public void user_should_get_a_proper_warning_message_about_credential_mismatch() {
		loginpage = new LoginPage(driver);
		Assert.assertTrue(
				loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User doesnt enter email address into email field")
	public void user_doesnt_enter_email_address_into_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailId("");
	}

	@And("User doesnt enter password address into password field")
	public void user_doesnt_enter_password_address_into_password_field() {
		loginpage.enterPassword("");
	}

}
