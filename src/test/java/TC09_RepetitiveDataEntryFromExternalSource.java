import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Address book administration")
@Story("Add multiple new addresses to an existing account from .csv file. File source: File path: src/test/resources/output.txt")
public class TC09_RepetitiveDataEntryFromExternalSource extends BaseTest {

  @ParameterizedTest(name = "Add new address : First name = {0}, Last name = {1}, Address = {2}, City = {3}, Post code = {4}, Country = {5}.")
  @CsvFileSource(resources = "/addresses.csv", numLinesToSkip = 1)
  public void addMultipleAddressesToAnAccount(String firstName, String lastName, String address, String city, String postCode, String country) {
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
    makeScreenshot();
    LOG.info("screenshot taken");
    List<WebElement> initialAddresses = driver.findElements(By.tagName("tr"));
    addressBookPage.navigateToAddAddressPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    addAddressPage.addNewAddress(firstName, lastName, address, city, postCode, country);
    makeScreenshot();
    LOG.info("Screenshot taken");
    List<WebElement> addressesAfterOneAdded = driver.findElements(By.tagName("tr"));
    assertThat(addressesAfterOneAdded.size())
        .as("New number of addresses should be initial number + 1")
        .isEqualTo(initialAddresses.size() + 1);
    LOG.info("Assertion of number of addresses done");
    myAccountPage.logout();
    makeScreenshot();
    LOG.info("Screenshot taken");
  }
}