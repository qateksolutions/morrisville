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

public class HotelsSearch {
    public WebDriver driver;
    private final By HotelTab= By.id("tab-hotel-tab-hp");
    private final By InputFieldGoingTo= By.id("hotel-destination-hp-hotel");
    private final By InputFieldCheckInDate= By.id("hotel-checkin-hp-hotel");
    private final By InputFieldCheckOutDate= By.id("hotel-checkout-hp-hotel");
    private final By AdultDropdown= By.id("gcw-hotel-form-hp-hotel");
    private final By SearchButton= By.xpath("//*[@id=gcw-hotel-form-hp-hotel]//label/button[@class='btn-primary btn-action  gcw-submit']");
    private final By NoHotelFound= By.xpath("//*[@id='ajax-error']/div[@data-test-id='no-flights-found-error']");

    @BeforeMethod
    public void browserinitialization(){
        ChromeDriverManager.getInstance().setup();
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.expedia.com/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void run(){
        driver.findElement(HotelTab).click();
        System.out.println("Clicked on Hotels Tab");

        WebDriverWait wait= new WebDriverWait(driver, 20);

        driver.findElement(InputFieldGoingTo).sendKeys("DFW");
        System.out.println("Typed Destination To Value");

        driver.findElement(InputFieldCheckInDate).sendKeys("12/25/2017");
        System.out.println("Typed Check-in Date");

        driver.findElement(InputFieldCheckOutDate).sendKeys("12/28/2017");
        System.out.println("Typed Check-Out Date");

        Select adultDropdown= new Select(driver.findElement(AdultDropdown));
        adultDropdown.selectByVisibleText("1 adult, 0 children");
        System.out.println("Selected Total Guests Number");

        wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
        driver.findElement(SearchButton).click();
        System.out.println("Clicked on Search Button");

        Boolean SearchResults= driver.findElements(NoHotelFound).isEmpty();
        Assert.assertTrue(SearchResults,"There is No Hotel Results");
        System.out.println("Searched Hotel is returned results");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
