package providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActOn {
    public static ElementActions element(WebDriver driver, By locator) {
        return new ElementActions(driver, locator);
    }

    public static BrowserActions browser(WebDriver driver) {
        return new BrowserActions(driver);
    }
}
