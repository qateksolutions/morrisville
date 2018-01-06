package page_objects.online_store;

import command_providers.AssertThat;
import command_providers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut extends MenuNavigation {
    private final By Continue = By.xpath("//*[@id='checkout_page_container']/div/a/span[text()='Continue']");
    private final By ProductInformation = By.xpath("//*[@id='checkout_page_container']/div/table/tbody/tr/td/a");

    public CheckOut(WebDriver driver) {
        super(driver);
    }

    public CheckOut pageIsLoaded() {
        WaitFor.elementToBeVisible(driver, Continue);
        return this;
    }

    public CheckOut validateProductIsAdded(String productName) {
        AssertThat.elementAssertions(driver, ProductInformation).elementContains(productName);
        return this;
    }
}
