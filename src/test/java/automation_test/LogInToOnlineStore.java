package automation_test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.online_store.Home;
import command_providers.ActOn;
import utilities.Log;

public class LogInToOnlineStore {
    private WebDriver driver;

    @BeforeTest
    public void initiateBrowser() {
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("logInToOnlineStoreTest");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("http://store.demoqa.com/");
    }

    @Test
    public void logInToOnlineStoreTest() {
        new Home(driver)
                .goToMyAccount()
                .pageIsLoaded()
                .typeUserName("qatek")
                .typePassword("Automation1!")
                .ClickOnLogin()
                .pageIsLoaded()
                .ClickLogOut()
                .pageIsLoaded()
                .backToOnlineStore();
    }

    @AfterTest
    public void testCleanup() {
        ActOn.browser(driver).closeBrowser();
        Log.endTestCase("logInToOnlineStoreTest");
    }
}
