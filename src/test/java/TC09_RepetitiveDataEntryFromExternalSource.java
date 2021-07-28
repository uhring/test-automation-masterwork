import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.AddAddressPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Address book administration")
@Story("Add multiple new addresses to an existing account from .csv file")
public class TC09_RepetitiveDataEntryFromExternalSource extends BaseTest {
  AddAddressPage addAddressPage = PageFactory.initElements(driver, AddAddressPage.class);

  @ParameterizedTest
  @CsvFileSource(resources = "/addresses.csv", numLinesToSkip = 1)
  @DisplayName("Add multiple new addresses to an existing account from .csv file." +
      " File source: File path: src/test/resources/output.txt")
  public void addMultipleAddressesToAnAccount(String firstName, String lastName, String address, String city, String postCode, String country) {
    addAddressPage.openHomePage();
    addAddressPage.openLoginPage();
    addAddressPage.loginReturningCustomer(registeredEmail, registeredPassword);
    addAddressPage.goToAddressBook();
    List<WebElement> initialAddresses = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr"));
    addAddressPage.addAddress();
    addAddressPage.addNewAddress(firstName, lastName, address, city, postCode, country);
    makeScreenshot();
    LOG.info("Screenshot taken");
    assertThat(driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr")).size())
        .as("New number of addresses should be initial number + 1")
        .isEqualTo(initialAddresses.size() + 1);
    LOG.info("Assertion of number of addresses done");
    addAddressPage.logout();
  }
}
