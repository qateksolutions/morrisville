package automation_test;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.online_store.Home;
import utilities.Log;

public class BuyProductFromAccessories {
    WebDriver driver;

    @BeforeTest
    public void initiateBrowser() {
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("buyProductFromAccessoriesTest");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("http://store.demoqa.com/");
    }

    @Test
    public void buyProductFromAccessoriesTest() {
        new Home(driver)
                .moveToProductCategory()
                .goToAccessories()
                .pageIsLoaded()
                .searchProduct("Magic Mouse")
                .pageIsLoaded()
                .ClickOnAddCart()
                .goToCart()
                .pageIsLoaded()
                .validateProductIsAdded("Magic Mouse");
    }

    @AfterTest
    public void testCleanup() {
        ActOn.browser(driver).closeBrowser();
        Log.endTestCase("buyProductFromAccessoriesTest");
    }
}
