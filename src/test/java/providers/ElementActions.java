package providers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ElementActions {
    protected By locator;
    protected WebDriver driver;

    public ElementActions(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    protected WebElement getElement() {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            System.out.println("Clicked on the locator: " + locator);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found for the locator: " + locator + " exception is: " + locator);
        }
        return element;
    }

    public ElementActions click() {
        System.out.println("Attempting to click on the element at '{}'" + locator);
        getElement().click();
        return this;
    }

    public ElementActions setValue(String value) {
        System.out.println("Attempting to set value on the element at '{}'" + locator);
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }

    public String getText() {
        System.out.println("Attempting to get text on the element at '{}'" + locator);
        return getElement().getText();
    }

    public ElementActions selectOption(String value) {
        System.out.println("Attempting to select option from the dropdown at '{}'" + locator);
        Select select =  new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }
}
