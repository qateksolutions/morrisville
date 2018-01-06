package page_objects.online_store;

import command_providers.ActOn;
import command_providers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearch extends MenuNavigation{
    private final By AddToCart = By.xpath("//*[@id='grid_view_products_page_container']/div//input[@value='Add To Cart']");
    private final By CheckOut = By.xpath("//*[@id='header_cart']/a[@title='Checkout']");

    public ProductSearch(WebDriver driver) {
        super(driver);
    }

    public ProductSearch pageIsLoaded() {
        WaitFor.elementToBeVisible(driver, AddToCart);
        return this;
    }

    public ProductSearch ClickOnAddCart() {
        ActOn.element(driver, AddToCart).click();
        return this;
    }

    public CheckOut goToCart() {
        ActOn.element(driver, CheckOut).click();
        return new CheckOut(driver);
    }
}
