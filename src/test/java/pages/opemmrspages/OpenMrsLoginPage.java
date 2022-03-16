package pages.opemmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrsLoginPage {
    public OpenMrsLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement passWord;
    @FindBy(id = "Inpatient Ward")
    private WebElement inpatientWardButton;
    @FindBy(id = "loginButton")
    private WebElement loginBut;

    public void loginOpenMrs(String username,String password){
        this.userName.sendKeys(username);
        this.passWord.sendKeys(password);
        this.inpatientWardButton.click();
        this.loginBut.click();
    }







}