package testng_exercise;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import command_providers.ActOn;
import command_providers.AssertThat;
import command_providers.WaitFor;
import utilities.Log;

public class HotelsSearch {
    public WebDriver driver;
    private final By HotelTab= By.id("tab-hotel-tab-hp");
    private final By InputFieldGoingTo= By.id("hotel-destination-hp-hotel");
    private final By InputFieldCheckInDate= By.id("hotel-checkin-hp-hotel");
    private final By InputFieldCheckOutDate= By.id("hotel-checkout-hp-hotel");
    private final By AdultDropdown= By.xpath("//*[@id='gcw-hotel-form-hp-hotel']//label/span[text()='Guests']/../select[contains(@class,'gcw-guests-field')]");
    private final By SearchButton= By.xpath("//*[@id='gcw-hotel-form-hp-hotel']//label/button[contains(@class,'gcw-submit')]");
    private final By SortByRecommended = By.xpath("//*[@id='sortContainer']//button[@data-opt-group='Recommended']");

    @BeforeTest
    public void browserInitialization(){
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("HotelsSearchTest");
        ChromeDriverManager.getInstance().setup();
        driver= new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.expedia.com/");
    }

    @Test
    public void run(){
        ActOn.element(driver,HotelTab).click();
        WaitFor.elementToBePresent(driver, InputFieldGoingTo);
        ActOn.element(driver, InputFieldGoingTo).setValue("DFW");
        ActOn.element(driver, InputFieldCheckInDate).setValue("02/15/2018");
        ActOn.element(driver,InputFieldCheckOutDate).setValue("02/16/2018");
        ActOn.element(driver, AdultDropdown).selectOption("1 adult, 0 children");
        ActOn.element(driver, SearchButton).click();
        WaitFor.elementToBeVisible(driver, SortByRecommended);
        AssertThat.elementAssertions(driver, SortByRecommended).elementDisplayed();

    }

    @AfterTest
    public void close(){
        ActOn.browser(driver).closeBrowser();
        Log.endTestCase("HotelsSearchTest");}
}
