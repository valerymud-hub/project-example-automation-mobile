package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import view.ProductsView;
import step.ProductStep;

public class ProductStepDefinition {

    ProductsView productsView = new ProductsView();
    ProductStep productStep = new ProductStep();

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_SauceLabs() {
        Assert.assertTrue("No se muestra la pantalla de productos",
                productsView.isOnProductsScreen());
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        Assert.assertTrue("No se mostró la lista de productos",
                productsView.isProductsDisplay());
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_cantidad_del_siguiente_producto(int unidades, String producto) {
        productStep.scrollToText(producto);
        productStep.seleccionarProducto(producto);
        productStep.scrollToAddToCartButton();
        productStep.agregarProducto(unidades);
    }

    @Then("valido el carrito de compra actualice correctamente con {string} unidades")
    public void valido_el_carrito_de_compra_actualice_correctamente(String unidades) {
        Assert.assertEquals(productStep.obtenerCantidadProductos(), unidades);
    }

}
