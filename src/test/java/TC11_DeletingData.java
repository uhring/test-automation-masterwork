import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Address book administration")
@Story("Deleting addresses from the address book")
public class TC11_DeletingData extends BaseTest {

  @Test
  @DisplayName("Deleting addresses from the address book")
  public void deleteAddressesFromAddressBook() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    makeScreenshot();
    LOG.info("screenshot taken");
    myAccountPage.goToAddressBook();
    List<WebElement> addresses = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr"));
    LOG.info("List of address book entries created");
    for (int i = 0; i < addresses.size(); i++) {
      List<WebElement> loopAddresses = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr"));
      if (loopAddresses.size() > 1) {
        addressBookPage.deleteTopElementFromTheList();
        makeScreenshot();
        LOG.info("screenshot taken");
        List<WebElement> newAddresses = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr"));
        assertThat(newAddresses.size())
            .as("New number of addresses should be initial number - 1")
            .isEqualTo(loopAddresses.size() - 1);
        LOG.info("Assertion of number if initial number of addresses >1 is done.");
      } else {
        addressBookPage.deleteTopElementFromTheList();
        makeScreenshot();
        LOG.info("screenshot taken");
        assertThat(addressBookPage.getWarningMessage().getText())
            .as("Text should be: Warning: You must have at least one address!")
            .isEqualTo("Warning: You must have at least one address!");
        LOG.info("Assertion of text if initial number of addresses <= 1 is done.");
      }
    }
  }
}