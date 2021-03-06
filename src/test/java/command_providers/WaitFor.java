package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;


public class WaitFor {
    private static final int MAX_WAIT_IN_SECONDS = 30;

    public static void elementToBePresent(WebDriver driver, By locator) {
        Log.info("Waiting for the element to be present: " + locator);
        new WebDriverWait(driver, MAX_WAIT_IN_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void elementToBeVisible(WebDriver driver, By locator) {
        Log.info("Waiting for the element to be visible: " + locator);
        new WebDriverWait(driver, MAX_WAIT_IN_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void elementToBeClickable(WebDriver driver, By locator) {
        Log.info("Waiting for the element to be clickable: " + locator);
        new WebDriverWait(driver, MAX_WAIT_IN_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void elementToBeSelectable(WebDriver driver, By locator) {
        Log.info("Waiting for the element to be Selectable: " + locator);
        new WebDriverWait(driver, MAX_WAIT_IN_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeSelected(locator));
    }
}
