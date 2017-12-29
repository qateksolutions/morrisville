package testng_exercise;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import providers.ActOn;
import providers.AssertThat;
import providers.WaitFor;

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
        ActOn.browser(driver).openBrowser("https://www.expedia.com/");
    }

    @Test
    public void run(){
        ActOn.element(driver,HotelTab).click();
        WaitFor.elementToBePresent(driver, InputFieldGoingTo);
        ActOn.element(driver, InputFieldGoingTo).setValue("DFW");
        ActOn.element(driver, InputFieldCheckInDate).setValue("12/28/2017");
        ActOn.element(driver,InputFieldCheckOutDate).setValue("12/29/2017");
        ActOn.element(driver, AdultDropdown).selectOption("1 adult, 0 children");
        ActOn.element(driver, SearchButton).click();
        WaitFor.elementToBeVisible(driver, SortByRecommended);
        AssertThat.elementAssertions(driver, SortByRecommended).elementDisplayed();

    }

    @AfterMethod
    public void close(){
        ActOn.browser(driver).closeBrowser(); }
}
