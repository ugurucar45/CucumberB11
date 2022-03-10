package stepdefinitions.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginPageSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    //positive
    @Given("the user navigates to the WebOrder website")
    public void the_user_navigates_to_the_web_order_website() {
        driver.navigate().to(ConfigReader.readProperty("urlweborder"));
    }

    @When("the user provides credentials")
    public void the_user_provides_credentials() {
        loginPage.login(ConfigReader.readProperty("weborderusername"), ConfigReader.readProperty("weborderpassword"));
    }

    @Then("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Assert.assertEquals(driver.getTitle(), "ORDER DETAILS - Weborder");
    }

    //negative scenario1
    @Given("the user navigates to the WebOrder website again")
    public void the_user_navigates_to_the_web_order_website_again() {
        driver.navigate().to(ConfigReader.readProperty("urlweborder"));
    }

    @When("the user provides correct username and wrong password")
    public void the_user_provides_correct_username_wrong_password() {
        loginPage.login(ConfigReader.readProperty("weborderusername"), "sasa");

    }

    @Then("the user validates the {string} errorMessage")
    public void the_user_validates_the_error_message(String expectedMessage) {
        Assert.assertTrue(loginPage.validateErrorMessage(expectedMessage));
    }

//    @When("the user provides wrong username and password")
//    public void the_user_provides_wrong_username_and_password() {
//        loginPage.login("ugue", "ucar");
//    }

    @When("the user provides wrong {string} and {string}")
    public void the_user_provides_wrong_username_and_passwords(String username, String password) {
        loginPage.login(username, password);
    }
}
