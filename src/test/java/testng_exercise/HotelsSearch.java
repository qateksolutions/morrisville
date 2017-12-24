package testng_exercise;

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
    private final By AdultDropdown= By.xpath("//*[@id='gcw-hotel-form-hp-hotel']//label/span[text()='Guests']/../select[contains(@class,'gcw-guests-field')]");
    private final By SearchButton= By.xpath("//*[@id='gcw-hotel-form-hp-hotel']//label/button[contains(@class,'gcw-submit')]");
    private final By SortByRecommended = By.xpath("//*[@id='sortContainer']//button[@data-opt-group='Recommended']");

    @BeforeMethod
    public void browserInitialization(){
        ChromeDriverManager.getInstance().setup();
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.expedia.com/");
        driver.manage().window().maximize();
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(SortByRecommended));
        Boolean SearchResults= driver.findElement(SortByRecommended).isDisplayed();
        Assert.assertTrue(SearchResults,"There is No Hotel Results");
        System.out.println("Searched Hotel is returned results");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
