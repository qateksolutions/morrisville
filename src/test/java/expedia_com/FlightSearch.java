package expedia_com;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FlightSearch {
    public WebDriver driver;
    private final By FlightTab = By.id("tab-flight-tab-hp");
    private final By OneWayButton = By.id("flight-type-one-way-label-hp-flight");
    private final By InputFieldFlyFrom = By.id("flight-origin-hp-flight");
    private final By InputFieldFlyTo = By.id("flight-destination-hp-flight");
    private final By InputFieldDepartingDate = By.id("flight-departing-single-hp-flight");
    private final By AdultDropdown = By.id("flight-adults-hp-flight");
    private final By SearchButton = By.xpath("//*[@id='gcw-flights-form-hp-flight']//label/button[@class='btn-primary btn-action gcw-submit']");
    private final By NoFlightsFound = By.xpath("//*[@id='ajax-error']/div[@data-test-id='no-flights-found-error']");

    @BeforeMethod
    public void browserInitialization() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.expedia.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void run() {
        driver.findElement(FlightTab).click();
        System.out.println("Clicked on Flights Tab");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(OneWayButton));
        driver.findElement(OneWayButton).click();
        System.out.println("Clicked on One Way button");

        driver.findElement(InputFieldFlyFrom).sendKeys("MIA");
        System.out.println("Typed Flight From value");

        driver.findElement(InputFieldFlyTo).sendKeys("DFW");
        System.out.println("Typed Flight To value");

        driver.findElement(InputFieldDepartingDate).sendKeys("12/24/2017");
        System.out.println("Typed Departing Date");

        Select adultDropdown = new Select(driver.findElement(AdultDropdown));
        adultDropdown.selectByVisibleText("2");
        System.out.println("Selected total passengers Number");

        wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
        driver.findElement(SearchButton).click();
        System.out.println("Clicked on Search button");

        Boolean searchResults = driver.findElements(NoFlightsFound).isEmpty();
        Assert.assertTrue(searchResults,"There is no flight results");
        System.out.println("Search flight is returned results");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
