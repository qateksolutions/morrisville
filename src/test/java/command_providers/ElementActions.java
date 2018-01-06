package command_providers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        Log.info("Attempting to set value on the element at: " + locator + " with value " + value);
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }

    public String getText() {
        Log.info("Attempting to get text on the element at: " + locator);
        return getElement().getText();
    }

    public ElementActions selectOption(String value) {
        Log.info("Attempting to select option from the dropdown at: " + locator + " with value " + value);
        Select select =  new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }

    public ElementActions moveTo() {
        Actions builder = new Actions(driver);
        builder.moveToElement(getElement()).perform();
        return this;
    }

    public ElementActions pressEnterKeyFromKeyboard() {
        getElement().sendKeys(Keys.ENTER);
        return this;
    }
}
