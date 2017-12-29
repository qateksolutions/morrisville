package page_objects.online_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;
import command_providers.AssertThat;
import command_providers.WaitFor;

public class LogIn {
    private final By LogoutConfirmation = By.xpath("//*[@id='login']/p[contains(text(),'You are now logged out')]");
    private final By BackToOnlineStoreLink = By.partialLinkText("Back to ONLINE STORE");
    private WebDriver driver;

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public LogIn pageIsLoaded() {
        WaitFor.elementToBePresent(driver, LogoutConfirmation);
        AssertThat.elementAssertions(driver, LogoutConfirmation).elementDisplayed();
        return this;
    }

    public Home backToOnlineStore() {
        ActOn.element(driver, BackToOnlineStoreLink).click();
        return new Home(driver);
    }
}
