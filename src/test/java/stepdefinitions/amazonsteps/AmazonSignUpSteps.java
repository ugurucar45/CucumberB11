package stepdefinitions.amazonsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.amazonpages.AmazonSignUpPage;
import utils.DriverHelper;

import java.util.List;

public class AmazonSignUpSteps {
    WebDriver driver = DriverHelper.getDriver();
    AmazonSignUpPage amazonSignUpPage = new AmazonSignUpPage(driver);

    @When("the user clicks the sign in and create your amazon account button")
    public void the_user_clicks_the_sign_in_and_create_your_amazon_account_button() throws InterruptedException {
        amazonSignUpPage.clickCreateNew();
    }

    @Then("the user validate the header")
    public void the_user_validate_the_header(io.cucumber.datatable.DataTable dataTable) {
        List<String> element = dataTable.asList();
        Assert.assertEquals(amazonSignUpPage.getHeaderText(), element.get(0));
    }

    @Then("the user provides the information")
    public void the_user_provides_the_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> elements = dataTable.asList();
        amazonSignUpPage.sendElements(elements.get(0), elements.get(1), elements.get(2), elements.get(3));
        amazonSignUpPage.clickContinue();
    }

    @Then("the user {int}")
    public void the_user(Integer int1) {

    }

}
