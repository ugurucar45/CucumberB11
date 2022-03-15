package pages.productpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLoginPage {
    public ProductLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "ctl00_MainContent_username")
    WebElement userName;
    @FindBy(id = "ctl00_MainContent_password")
    WebElement password;
    @FindBy(name = "ctl00$MainContent$login_button")
    WebElement loginButton;

    public void loginsite(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }



}
