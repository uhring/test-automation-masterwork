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
@Story("Add address to an existing account")
public class TC08_InputOfNewData extends BaseTest {

  @Test
  @DisplayName("Add address to an existing account")
  public void addAddressToAccount() {
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
    List<WebElement> initialAddresses = driver.findElements(By.tagName("tr"));
    makeScreenshot();
    LOG.info("screenshot taken");
    addressBookPage.addAddress();
    makeScreenshot();
    LOG.info("screenshot taken");
    addAddressPage.addNewAddress("Ilona", "Nagy", "Nagy utca 1",
        "Budapest", "1999", "Hungary");
    makeScreenshot();
    LOG.info("screenshot taken");
    List<WebElement> addressesAfterOneAdded = driver.findElements(By.tagName("tr"));
    assertThat(addressesAfterOneAdded.size())
        .as("New number of addresses should be initial number + 1")
        .isEqualTo(initialAddresses.size() + 1);
    LOG.info("Assertion of number of addresses done");
  }
}