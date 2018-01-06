package page_objects.online_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;

public class MenuNavigation {
    private final By HomeLink = By.linkText("Home");
    private final By AccessoriesLink = By.linkText("Accessories");
    private final By ProductCategory = By.linkText("Product Category");
    private final By MyAccountLink = By.id("account");
    private final By TextSearchBox = By.name("s");
    protected WebDriver driver;

    public MenuNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public Home goToHome() {
        ActOn.element(driver,HomeLink).click();
        return new Home(driver);
    }

    public MyAccount goToMyAccount() {
        ActOn.element(driver, MyAccountLink).click();
        return new MyAccount(driver);
    }

    public MenuNavigation moveToProductCategory() {
        ActOn.element(driver, ProductCategory).moveTo();
        return this;
    }

    public Accessories goToAccessories() {
        ActOn.element(driver, AccessoriesLink).click();
        return new Accessories(driver);
    }

    public ProductSearch searchProduct(String searchItem) {
        ActOn.element(driver, TextSearchBox).setValue(searchItem);
        ActOn.element(driver, TextSearchBox).pressEnterKeyFromKeyboard();
        return new ProductSearch(driver);
    }
}
