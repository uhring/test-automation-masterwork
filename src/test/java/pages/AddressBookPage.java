package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddressBookPage extends BasePage {

  public AddressBookPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/a")
  WebElement newAddressButton;

  @FindBy(id = "content")
  WebElement addressBookContent;

  @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a[2]")
  WebElement deleteFirstAddressButton;

  @FindBy(xpath = "//*[@id=\"account-address\"]/div[1]")
  WebElement warningMessage;

  public void addAddress() {
    newAddressButton.click();
    LOG.info("New address button clicked");
    wait.until(ExpectedConditions.visibilityOf(addressBookContent));
    LOG.info("Wait until Add Address page opens");
  }

  public void deleteTopElementFromTheList() {
    deleteFirstAddressButton.click();
    LOG.info("Click on delete button at top element from address list");
  }

  public WebElement getWarningMessage() {
    return warningMessage;
  }
}
