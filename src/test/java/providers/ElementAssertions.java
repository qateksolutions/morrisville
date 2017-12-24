package providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ElementAssertions {
    protected WebDriver driver;
    protected By locator;

    public ElementAssertions(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAssertions elementExist() {
        System.out.println("Asserting that element is exist for the locator '{}'" + locator);
        Boolean element = driver.findElements(locator).isEmpty();
        Assert.assertTrue(element,"The expected element does not exist");
        return this;
    }
}
