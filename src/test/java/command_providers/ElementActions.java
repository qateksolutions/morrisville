package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Log;


public class ElementActions {
    private By locator;
    private WebDriver driver;

    public ElementActions(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    protected WebElement getElement() {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (NoSuchElementException e) {
            Log.error("Element not found for the locator: " + locator + " and exception is: " + e);
        }
        return element;
    }

    public ElementActions click() {
        Log.info("Attempting to click on the element at: " + locator);
        getElement().click();
        return this;
    }

    public ElementActions setValue(String value) {
        Log.info("Attempting to set value on the element at: " + locator);
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }

    public String getText() {
        Log.info("Attempting to get text on the element at: " + locator);
        return getElement().getText();
    }

    public ElementActions selectOption(String value) {
        Log.info("Attempting to select option from the dropdown at: " + locator);
        Select select =  new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }
}
