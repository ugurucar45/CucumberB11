package pages.productpages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ProductOrderPage {
    public ProductOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement productName;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customersName;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement state;
    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    private WebElement zipCode;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement paymentVisa;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement paymentMasterCard;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement paymentAmericanExpress;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumber;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement cardExpirationDate;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    @FindBy(tagName = "strong")
    private WebElement orderMessage;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    private List<WebElement> table;


    public void sendProductionInfo(String productName, String quantity) {
        BrowserUtils.selectBy(this.productName, productName, "value");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void sendAdressInfo(String customerName, String street, String city, String state, String zip) {
        this.customersName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zip);
    }

    public void sendPaymentInformation(String cardNumber, String expirationDate) {
        this.cardNumber.sendKeys(cardNumber);
        this.cardExpirationDate.sendKeys(expirationDate);
    }

    public void selectCard(String cardType) throws InterruptedException {
        Thread.sleep(200);

        switch (cardType) {
            case "Visa":
                paymentVisa.click();
                break;
            case "MasterCard":
                paymentMasterCard.click();
                break;
            case "American Express":
                paymentAmericanExpress.click();
                break;
        }
    }

    public void clickProcessButton() throws InterruptedException {
        Thread.sleep(200);
        processButton.click();
    }

    public String getSuccessMessage() throws InterruptedException {
        Thread.sleep(200);
        return BrowserUtils.getTextMethod(orderMessage);
    }

    public void getInfo(String customerName, String productName, String quantity, String street,
                        String city, String state, String zipcode, String cardType, String cardNumber, String expirationDate) {
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(1)), customerName);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(2)), productName);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(3)), quantity);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(5)), street);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(6)), city);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(7)), state);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(8)), zipcode);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(9)), cardType);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(10)), cardNumber);
        Assert.assertEquals(BrowserUtils.getTextMethod(table.get(11)), expirationDate);
    }
}
