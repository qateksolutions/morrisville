package command_providers;

import org.openqa.selenium.WebDriver;
import utilities.Log;
import java.util.concurrent.TimeUnit;


public class BrowserActions {
    protected WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions openBrowser(String url) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Log.info("Launch browser with the provided URL: " + url);
        return this;
    }

    public BrowserActions closeBrowser() {
        driver.quit();
        Log.info("Closed the opened browser");
        return this;
    }
}
