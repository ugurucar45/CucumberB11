package stepdefinitions.etsysteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.etsypages.EtsyHomePage;
import utils.DriverHelper;

public class EtsySearchSteps {
    WebDriver driver= DriverHelper.getDriver();
    EtsyHomePage etsyHomePage=new EtsyHomePage(driver);
    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String etsyUrl) {
       driver.navigate().to(etsyUrl);
    }
    @When("the user searches with {string}")
    public void the_user_searches_with(String searchValue) {
    etsyHomePage.sendSearchKeys(searchValue);
    }
    @Then("the user validates the title {string}")
    public void the_user_validates_the_title(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }
}
