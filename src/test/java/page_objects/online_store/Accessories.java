package page_objects.online_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.AssertThat;
import command_providers.WaitFor;

public class Accessories extends MenuNavigation {
    private final By PageHeader = By.xpath("//header/h1[text()='Accessories']");

    public Accessories(WebDriver driver) {
        super(driver);
    }

    public Accessories pageIsLoaded() {
        WaitFor.elementToBePresent(driver, PageHeader);
        AssertThat.elementAssertions(driver, PageHeader).elementDisplayed();
        return this;
    }
}
