package pages.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CreateGroupOrderPage {
    public CreateGroupOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "InviteNote")
    private WebElement inviteNote;
    @FindBy(id = "InviteList")
    private WebElement inviteList;
    @FindBy(id = "addressPreview")
    private WebElement officeAdress;
    @FindBy(id = "createGroupOrder")
    private WebElement createGroupButton;
    @FindBy(tagName = "h1")
    private WebElement header;
    @FindBy (xpath = "//label[.='Total Participants:']//following-sibling::div")
    private WebElement participants;

    public void sendInviteNote(String invitationNote) {
        this.inviteNote.sendKeys(invitationNote);
    }

    public void sendInviteList(String inviteList) {
        this.inviteList.sendKeys(inviteList);
    }

    public String getOfficeAdress() {
        return BrowserUtils.getTextMethod(officeAdress);
    }

    public void clickCreateGroupButton() {
        createGroupButton.click();
    }
    public String getHeader() throws InterruptedException {
        Thread.sleep(1000);
        return BrowserUtils.getTextMethod(header);
    }
    public int getParticipant(){
        return Integer.parseInt(BrowserUtils.getTextMethod(participants));

    }

}
