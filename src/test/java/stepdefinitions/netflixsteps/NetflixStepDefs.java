package stepdefinitions.netflixsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.netflixpages.netflixLoginPage;

public class NetflixStepDefs {
    WebDriver driver;
    netflixLoginPage netflixLoginPage;

    @When("I navigate to Netflix login page")
    public void i_navigate_to_netflix_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");
    }

    @When("I enter not valid email")
    public void i_enter_not_valid_email() {
        netflixLoginPage = new netflixLoginPage(driver);
        netflixLoginPage.enterEmail("test@test.com");
    }

    @When("I enter not valid password")
    public void i_enter_not_valid_password() {
        netflixLoginPage.enterPassword("passwordFRFRF");
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        netflixLoginPage.clickSubmit();
    }

    @Then("I see Incorrect password element")
    public void i_see_incorrect_password_element() {

        Assert.assertTrue(netflixLoginPage.incorrectPassword.isDisplayed());
    }

    @And("I enter not valid {string}")
    public void iEnterNotValid(String email) {
        netflixLoginPage = new netflixLoginPage(driver);
        netflixLoginPage.enterEmail(email);
    }
}
