package testng_exercise;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import command_providers.ActOn;
import command_providers.AssertThat;
import command_providers.WaitFor;
import utilities.Log;

public class FlightSearch {
    public WebDriver driver;
    private final By FlightTab = By.id("tab-flight-tab-hp");
    private final By OneWayButton = By.id("flight-type-one-way-label-hp-flight");
    private final By InputFieldFlyFrom = By.id("flight-origin-hp-flight");
    private final By InputFieldFlyTo = By.id("flight-destination-hp-flight");
    private final By InputFieldDepartingDate = By.id("flight-departing-single-hp-flight");
    private final By AdultDropdown = By.id("flight-adults-hp-flight");
    private final By SearchButton = By.xpath("//*[@id='gcw-flights-form-hp-flight']//label/button[contains(@class,'gcw-submit')]");
    private final By NonStopFlightCheckBox = By.id("stopFilter_stops-0");
    private final By NoFlightsFound = By.xpath("//*[@id='ajax-error']/div[@data-automation_test-id='no-flights-found-error']");

    @BeforeTest
    public void browserInitialization() {
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("FlightSearchTest");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.expedia.com/");
    }

    @Test
    public void run() {
        ActOn.element(driver, FlightTab).click();
        WaitFor.elementToBePresent(driver, OneWayButton);
        ActOn.element(driver, OneWayButton).click();
        ActOn.element(driver, InputFieldFlyFrom).setValue("MIA");
        ActOn.element(driver, InputFieldFlyTo).setValue("DFW");
        ActOn.element(driver, InputFieldDepartingDate).setValue("02/25/2018");
        ActOn.element(driver, AdultDropdown).selectOption("2");
        ActOn.element(driver, SearchButton).click();
        WaitFor.elementToBePresent(driver, NonStopFlightCheckBox);
        AssertThat.elementAssertions(driver, NoFlightsFound).elementExist();
    }

    @AfterTest
    public void close() {
        ActOn.browser(driver).closeBrowser();
        Log.endTestCase("FlightSearchTest");
    }
}
