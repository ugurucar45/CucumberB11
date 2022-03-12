package pages.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ConfirmAddressID")
    private WebElement deliveryOptions;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    private WebElement selectGroupOrder;

    @FindBy(id = "getAddressNextButton")
    private WebElement nextButton;


    public void getDeliveryOptions(String option) {
        BrowserUtils.selectBy(deliveryOptions, option, "text");
    }

    public void clickGroupOrder() {
        selectGroupOrder.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }


}
