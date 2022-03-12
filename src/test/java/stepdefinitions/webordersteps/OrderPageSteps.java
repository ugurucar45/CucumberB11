package stepdefinitions.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.CreateGroupOrderPage;
import pages.weborderpages.LoginPage;
import pages.weborderpages.OrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class OrderPageSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    CreateGroupOrderPage createGroupOrderPage = new CreateGroupOrderPage(driver);

    @Given("the user is on weborder homepage")
    public void the_user_is_on_weborder_homepage() {
        driver.navigate().to(ConfigReader.readProperty("urlweborder"));
        loginPage.login(ConfigReader.readProperty("weborderusername"), ConfigReader.readProperty("weborderpassword"));

    }

    @When("the user selects {string} options")
    public void the_user_selects_options(String deliveryOption) {
        orderPage.getDeliveryOptions(deliveryOption);

    }

    @When("the user is on the groupOrderPage")
    public void the_user_is_on_the_group_order_page() {
        orderPage.clickGroupOrder();
        orderPage.clickNextButton();
        Assert.assertEquals(driver.getTitle(), "Create Group Order - Weborder");
    }

    @When("the user sends invites note {string}")
    public void the_user_sends_invites_note(String string) {
        createGroupOrderPage.sendInviteNote(string);
    }

    @When("the user sends invite list {string} and {string}")
    public void the_user_sends_invite_list_and(String email, String email1) {
        createGroupOrderPage.sendInviteList(email + " , " + email1);
    }

    @Then("the user validate the {string} adress")
    public void the_user_validate_the_adress(String expectedAdress) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(createGroupOrderPage.getOfficeAdress().contains(expectedAdress));
    }

    @Then("the user validates {string} text")
    public void the_user_validates_text(String expectedText) throws InterruptedException {
        createGroupOrderPage.clickCreateGroupButton();
        Assert.assertEquals(createGroupOrderPage.getHeader(), expectedText);
    }

    @Then("the user validates total participants is {int}")
    public void the_user_validates_total_participants_is(int expectedParticipant) {
        Assert.assertEquals(createGroupOrderPage.getParticipant(),expectedParticipant);
    }
}