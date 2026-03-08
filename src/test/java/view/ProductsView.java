package view;

import driver.MobileDriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductsView {

    private AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement productsTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productos;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private WebElement cartIcon;

    public ProductsView() {
        this.driver = MobileDriverManager.getDriver();
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
                this
        );
    }

    public boolean isOnProductsScreen() {
        return productsTitle.isDisplayed();
    }

    public boolean isProductsDisplay() {
        return productos.isDisplayed();
    }

    public void tapAddToCart() {
        addToCartButton.click();
    }

    public String getProductsCount() {
        return cartIcon.getText();
    }

    public By productoPorNombre(String nombreProducto) {
        return By.xpath(
                "//*[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV' and @text='"
                        + nombreProducto + "']/.."
        );
    }

    public String scrollToText(String text){
        return "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"" + text + "\"))";
    }

    public String scrollToAddToCart(){
        return "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartBt\"))";
    }

}
