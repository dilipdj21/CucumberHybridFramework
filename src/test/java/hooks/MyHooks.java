package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {

	WebDriver driver;

	@Before
	public void setup() {

		Properties properties = ConfigReader.initializeProperties();
		DriverFactory.initalizeBrowser(properties.getProperty("browser"));
		driver = DriverFactory.getdriver();
		driver.get(properties.getProperty("url"));

	}

	@After
	public void teardown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			byte[] srcScreeshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreeshot, "image/png", scenarioName);
		}
		driver.quit();
	}
}
