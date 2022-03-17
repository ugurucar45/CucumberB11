package pages.netflixpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class netflixLoginPage {

    public netflixLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@name=\"userLoginId\"]" )
    WebElement emailField;

    @FindBy (xpath = "//input[@id=\"id_password\"]")
    WebElement passwordField;

    @FindBy (xpath = "//button[@type=\"submit\" and @data-uia=\"login-submit-button\"]")
    WebElement submitButton;

    @FindBy (xpath = "//div[@data-uia=\"text\"]")
    public WebElement incorrectPassword;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickSubmit(){
        submitButton.click();
    }




}
