package testng_exercise;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGWebDriver {
    WebDriver driver;

    @BeforeMethod
    public void initializeBrowser() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        System.out.println("Browser is launched");
    }

    @Test
    public void verifyHomePageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String capturedTitle = driver.getTitle();
        Assert.assertEquals(capturedTitle,expectedTitle);
        System.out.println("Browser Title is validated");
    }

   @AfterMethod
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser is closed");
    }
}
