package page_objects.online_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;
import command_providers.AssertThat;
import command_providers.WaitFor;

public class MyAccount extends MenuNavigation {
    private final By PageHeader = By.xpath("//header/h1[text()='Your Account']");
    private final By UserName = By.id("log");
    private final By Password = By.id("pwd");
    private final By LoginButton = By.id("login");

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    public MyAccount pageIsLoaded() {
        WaitFor.elementToBePresent(driver, PageHeader);
        AssertThat.elementAssertions(driver, PageHeader).elementDisplayed();
        return this;
    }

    public MyAccount typeUserName(String userName) {
        ActOn.element(driver, UserName).setValue(userName);
        return this;
    }

    public MyAccount typePassword(String password) {
        ActOn.element(driver, Password).setValue(password);
        return this;
    }

    public YourAccount ClickOnLogin() {
        ActOn.element(driver, LoginButton).click();
        return new YourAccount(driver);
    }
}
