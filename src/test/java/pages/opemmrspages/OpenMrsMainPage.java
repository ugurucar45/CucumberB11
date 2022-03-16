package pages.opemmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrsMainPage {
    public OpenMrsMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    private WebElement registerPatientButton;


    public void clickRegisterPatientButton() {
        registerPatientButton.click();
    }


}
