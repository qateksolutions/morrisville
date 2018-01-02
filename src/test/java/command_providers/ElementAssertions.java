package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.Log;

public class ElementAssertions {
    protected WebDriver driver;
    protected By locator;

    public ElementAssertions(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAssertions elementExist() {
        Log.info("Asserting that element is exist for the locator: " + locator);
        Boolean element = driver.findElements(locator).isEmpty();
        Assert.assertTrue(element,"The expected element does not exist");
        return this;
    }

    public ElementAssertions elementDisplayed() {
        Log.info("Asserting that element is displayed for the locator: " + locator);
        Boolean SearchResults = driver.findElement(locator).isDisplayed();
        Assert.assertTrue(SearchResults,"The expected element is not displayed");
        return this;
    }

    public ElementAssertions elementEnabled() {
        Log.info("Asserting that element is enabled for the locator: " + locator);
        Boolean SearchResults = driver.findElement(locator).isEnabled();
        Assert.assertTrue(SearchResults,"The expected element is not enabled");
        return this;
    }

    public ElementAssertions elementSelected() {
        Log.info("Asserting that element is selected for the locator: " + locator);
        Boolean SearchResults = driver.findElement(locator).isSelected();
        Assert.assertTrue(SearchResults,"The expected element is not selected");
        return this;
    }
}
