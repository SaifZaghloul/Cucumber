package test.java.TCs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.Helpers.ElementFinder;
import Sections.Colors;
import Sections.Conflict;
import Sections.General;
import Sections.Interior;
import Sections.Mirrors;
import Sections.Models;
import Sections.Motors;
import Sections.Polster;
import Sections.Rims;
import Sections.Summary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LibraryTest {

	List<String> ChosenOptions = new ArrayList();
	float temp = 0;
	float initialTotal = 0;
	float initial = 0;
	float chosen = 0;
	// public static AndroidDriver driver;
	public static WebDriver driver;
	static public DesiredCapabilities cap = new DesiredCapabilities();
	ElementFinder eleFinder = new ElementFinder();
	General g = new General();
	Models model = new Models();
	Motors motor = new Motors();
	Colors color = new Colors();
	Rims rim = new Rims();
	Conflict conflict = new Conflict();
	Mirrors mirrors = new Mirrors();
	Polster polster = new Polster();
	Interior interior = new Interior();
	Summary summary = new Summary();

	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("chromedriver_linux64/chromedriver");

		// WebDriverManager.chromedriver().setup();

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("headless");

		driver = new ChromeDriver(chromeOptions);

		driver.get("https://stage2user:Wdin4twf@dev-1.con.bmw/modelrangeselection.html?country=at&language=de");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(5000);

	}

	@When("^user click on a car$")
	public void user_click_on_a_car() throws Throwable {

		g.ChooseCar();

		Thread.sleep(5000);

	}

	@Then("^he will be navigated to the car details page$")
	public void he_will_be_navigated_to_the_car_details_page() throws Throwable {

		g.PriceTab();

		Thread.sleep(5000);

		initialTotal = g.GetPrice();

	}

	@Then("^car details will be displayed$")
	public void car_details_will_be_displayed() throws Throwable {

		g.ConfigTab();

		Thread.sleep(5000);

	}

}
