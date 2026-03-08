@testfeature
Feature: Carrito de compras

  @test
  Scenario Outline: Agregar productos al carrito
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente con "<UNIDADES>" unidades

    Examples:
      | PRODUCTO                     | UNIDADES |
      | Sauce Labs Backpack          | 1        |
      | Test.sllTheThings() T-Shirt  | 1        |
      | Sauce Labs Onesie            | 2        |