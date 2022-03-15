package stepdefinitions.productsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.productpages.ProductLoginPage;
import pages.productpages.ProductMainPage;
import pages.productpages.ProductOrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductOrderSteps {
    WebDriver driver = DriverHelper.getDriver();
    ProductLoginPage productLoginPage = new ProductLoginPage(driver);
    ProductMainPage productMainPage = new ProductMainPage(driver);
    ProductOrderPage productOrderPage = new ProductOrderPage(driver);

    @Given("the user navigates to product website homepage and click orderButton")
    public void the_user_navigates_to_product_website_homepage_and_click_order_button() {
        productLoginPage.loginsite(ConfigReader.readProperty("productusername"),
                ConfigReader.readProperty("productpassword"));
        productMainPage.clickOrderButton();
    }

    @When("the user enters the product information {string} and {string}")
    public void the_user_enters_the_product_information_and(String productName, String quantitiy) {
        productOrderPage.sendProductionInfo(productName, quantitiy);
    }

    @When("the users enters the adress information {string}, {string},{string},{string},{string}")
    public void the_users_enters_the_adress_information(String customerName, String street, String city, String state
            , String zipcode) {
        productOrderPage.sendAdressInfo(customerName, street, city, state, zipcode);
    }

    @When("the users enter the card information {string}, {string},{string}")
    public void the_users_enter_the_card_information(String cardtype, String cardNumber, String expirationDate) throws InterruptedException {
        productOrderPage.selectCard(cardtype);
        productOrderPage.sendPaymentInformation(cardNumber, expirationDate);
    }

    @Then("the user validates success message")
    public void the_user_validates_success_message() throws InterruptedException {
        productOrderPage.clickProcessButton();
        Assert.assertEquals("New order has been successfully added.", productOrderPage.getSuccessMessage());
    }

    @Then("the user validates product details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void the_user_validates_product_details(String customerName, String productName, String quantity,
                                                   String street, String city, String state, String zipcode,
                                                   String cardtype, String cardNumber, String expirationDate) {
        productMainPage.clickviewAllOrderButton();
        productOrderPage.getInfo(customerName, productName, quantity, street, city, state, zipcode, cardtype, cardNumber, expirationDate);



    }
}