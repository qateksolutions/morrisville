package page_objects.online_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;
import command_providers.AssertThat;
import command_providers.WaitFor;

public class YourAccount extends MenuNavigation{
    private final By LogoutLink = By.linkText("Log out");

    public YourAccount(WebDriver driver) {
        super(driver);
    }

    public YourAccount pageIsLoaded() {
        WaitFor.elementToBePresent(driver, LogoutLink);
        AssertThat.elementAssertions(driver, LogoutLink).elementDisplayed();
        return this;
    }

    public LogIn logOut() {
        ActOn.element(driver, LogoutLink).click();
        return new LogIn(driver);
    }
}
