package pages.opemmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OpenMrsRegisterPage {
    public OpenMrsRegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "givenName")
    private WebElement name;
    @FindBy(name = "familyName")
    private WebElement surnname;
    @FindBy(id = "next-button")
    private WebElement nextButton;
    @FindBy(id = "gender-field")
    private WebElement gender;
    @FindBy(name = "birthdateDay")
    private WebElement bDay;
    @FindBy(name = "birthdateMonth")
    private WebElement bMonth;
    @FindBy(xpath = "//input[@name='birthdateYear']")
    private WebElement bYear;
    @FindBy(id = "address1")
    private WebElement adress;
    @FindBy(id = "cityVillage")
    private WebElement city;
    @FindBy(id = "stateProvince")
    private WebElement state;
    @FindBy(id = "country")
    private WebElement country;
    @FindBy(id = "postalCode")
    private WebElement zipCode;
    @FindBy(name = "phoneNumber")
    private WebElement phoneNumber;
    @FindBy(name = "relationship_type")
    private WebElement relationType;
    @FindBy(xpath = "//input[@placeholder='Person Name']")
    private WebElement relativeName;
    @FindBy(id = "dataCanvas")
    private WebElement allData;
    @FindBy(id = "submit")
    private WebElement confirmButton;
    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    private WebElement assertGivenName;
    @FindBy(xpath = "//span[@class='PersonName-familyName']")
    private WebElement assertFamilyName;
//    @FindBy
//    private WebElement ;

    public void sendName(String name, String familyname) throws InterruptedException {
        this.name.sendKeys(name);
        this.surnname.sendKeys(familyname);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendGender(String gender) throws InterruptedException {
        BrowserUtils.selectBy(this.gender, gender, "text");
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendBirthDate(String day, String months, String bYear) throws InterruptedException {
        this.bDay.sendKeys(day);
        BrowserUtils.selectBy(bMonth, months, "text");
        this.bYear.sendKeys(bYear);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendAdress(String adress, String city,String state,String country,String zipcode) throws InterruptedException {
        this.adress.sendKeys(adress);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.country.sendKeys(country);
        this.zipCode.sendKeys(zipcode);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendPhoneNumber(String phoneNumbe) throws InterruptedException {
        this.phoneNumber.sendKeys(phoneNumbe);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendRelativeInfo(String relationType, String relativeName) throws InterruptedException {
        BrowserUtils.selectBy(this.relationType, relationType, "text");
        this.relativeName.sendKeys(relativeName);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }
    public String getGivenName(){
        return BrowserUtils.getTextMethod(assertGivenName);
    }
    public String getFamilyName(){
        return BrowserUtils.getTextMethod(assertFamilyName);
    }

}
