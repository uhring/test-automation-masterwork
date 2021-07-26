package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddressBookPage extends MyAccountPage{

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/a")
    WebElement newAddressButton;

    @FindBy(id = "content")
    WebElement addressBookContent;

    public void addAddress(){
        newAddressButton.click();
        LOG.info("New address button clicked");
        wait.until(ExpectedConditions.visibilityOf(addressBookContent));
        LOG.info("Wait until Add Address page opens");
    }
}
