package stepdefinitions.openmrssteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.opemmrspages.OpenMrsLoginPage;
import pages.opemmrspages.OpenMrsMainPage;
import pages.opemmrspages.OpenMrsRegisterPage;
import utils.DriverHelper;

import java.util.Map;

public class RegisterPatientSteps {
    WebDriver driver = DriverHelper.getDriver();
    OpenMrsLoginPage openMrsLoginPage = new OpenMrsLoginPage(driver);
    OpenMrsMainPage openMrsMainPage = new OpenMrsMainPage(driver);
    OpenMrsRegisterPage openMrsRegisterPage = new OpenMrsRegisterPage(driver);

    @Given("the user logs in to OpenMRS with following credentials")
    public void the_user_logs_in_to_open_mrs_with_following_credentials(DataTable dataTable) {
        // know that: dataTable will come as a parameter when you provide data table in the feature file
        // And delete the first part of the Datatable and import it.
        Map<String, String> usernamePasswordMap = dataTable.asMap();
//        String username=usernamePasswordMap.get("username");
//        String password=usernamePasswordMap.get("password");
//        System.out.println(username+"   "+password);
        openMrsLoginPage.loginOpenMrs(usernamePasswordMap.get("username"), usernamePasswordMap.get("password"));
    }

    @When("the user registers a new patient with following information")
    public void the_user_registers_a_new_patient_with_following_information(DataTable dataTable) throws InterruptedException {
        Map<String, String> patiInfoMap = dataTable.asMap();
        openMrsMainPage.clickRegisterPatientButton();
        openMrsRegisterPage.sendName(patiInfoMap.get("GivenName"), patiInfoMap.get("FamilyName"));
        openMrsRegisterPage.sendGender(patiInfoMap.get("Gender"));
        openMrsRegisterPage.sendBirthDate(patiInfoMap.get("Day"), patiInfoMap.get("Month"), patiInfoMap.get("Year"));
        openMrsRegisterPage.sendAdress(patiInfoMap.get("Address"), patiInfoMap.get("City"), patiInfoMap.get("State"),
                patiInfoMap.get("Country"), patiInfoMap.get("ZipCode"));
        openMrsRegisterPage.sendPhoneNumber(patiInfoMap.get("PhoneNumber"));
        openMrsRegisterPage.sendRelativeInfo(patiInfoMap.get("relationType"), patiInfoMap.get("RelativeName"));
        openMrsRegisterPage.clickConfirmButton();
    }

    @Then("the user validates the patient name and familyName")
    public void the_user_validates_the_patient_name_and_family_name(io.cucumber.datatable.DataTable dataTable) {
Map<String,String>  getInfoForAssert=dataTable.asMap();
        Assert.assertEquals(getInfoForAssert.get("GivenName"),openMrsRegisterPage.getGivenName());
        Assert.assertEquals(getInfoForAssert.get("FamilyName"),openMrsRegisterPage.getFamilyName());
    }

}