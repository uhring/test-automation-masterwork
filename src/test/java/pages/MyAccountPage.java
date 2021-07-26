package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends LoginPage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[4]")
    WebElement addressBookLink;

    public void goToAddressBook(){
        addressBookLink.click();
        LOG.info("Click on address book link");
        wait.until(ExpectedConditions.titleIs("Address Book"));
        LOG.info("Wait until address book page opens");
    }
}
