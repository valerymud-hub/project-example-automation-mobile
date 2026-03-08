package step;

import org.openqa.selenium.WebElement;
import view.ProductsView;
import io.appium.java_client.AppiumBy;
import driver.MobileDriverManager;

public class ProductStep {

    ProductsView productsView = new ProductsView();

    public void scrollToText(String text){
        MobileDriverManager.getDriver().findElement(AppiumBy
                .androidUIAutomator(productsView.scrollToText(text)));
    }

    public void scrollToAddToCartButton() {
        MobileDriverManager.getDriver().findElement(AppiumBy
                .androidUIAutomator(productsView.scrollToAddToCart()));
    }

    public void seleccionarProducto(String producto) {
        WebElement webElement = MobileDriverManager.getDriver().findElement(
                productsView.productoPorNombre(producto));
        webElement.click();
    }

    public void agregarProducto(int unidades) {
        for (int i = 0; i < unidades; i++) {
            productsView.tapAddToCart();
        }
    }

    public String obtenerCantidadProductos() {
        return productsView.getProductsCount();
    }

}
