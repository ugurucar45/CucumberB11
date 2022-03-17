package pages.amazonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.amazonsteps.AmazonSignUpSteps;
import utils.BrowserUtils;

public class AmazonSignUpPage {
    public AmazonSignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement helloSignIn;
    @FindBy(id = "createAccountSubmit")
    private WebElement createNewAccount;
    @FindBy(id="ap_customer_name")
    private WebElement username;
    @FindBy(id = "ap_email")
    private WebElement email;
    @FindBy(id = "ap_password")
    private WebElement password;
    @FindBy(id = "ap_password_check")
    private WebElement repassword;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(tagName = "h1")
    private WebElement headerText;

    public void clickCreateNew() throws InterruptedException {
        helloSignIn.click();
        Thread.sleep(1000);
        createNewAccount.click();
    }
    public String getHeaderText(){
        return BrowserUtils.getTextMethod(headerText);
    }
    public void sendElements(String username,String email,String pass,String pass2) throws InterruptedException {
        this.username.sendKeys(username);
        this.email.sendKeys(email);
        this.password.sendKeys(pass);
        this.repassword.sendKeys(pass2);
        Thread.sleep(1000);
    }
    public void clickContinue(){
        continueButton.click();
    }

}
