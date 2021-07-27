import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.AddressBookPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User data administration")
@Story("Deleting one address from the address book")
public class TC11_DeletingData extends BaseTest {
  AddressBookPage addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);

  @Test
  @DisplayName("Deleting one address from the address book")
  public void deleteOneAddressFromAddresses() {
    addressBookPage.openHomePage();
    addressBookPage.openLoginPage();
    addressBookPage.loginReturningCustomer("nagy@ilona.hu", "nagyi");
    addressBookPage.goToAddressBook();
    List<WebElement> initialAddresses = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr"));
    if (initialAddresses.size() > 1) {
      addressBookPage.deleteTopElementFromTheList();
      assertThat(driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr")).size())
          .as("New number of addresses should be initial number - 1")
          .isEqualTo(initialAddresses.size() - 1);
      LOG.info("Assertion of number if initial number of addresses >1 is done.");
    } else {
      addressBookPage.deleteTopElementFromTheList();
      assertThat(driver.findElement(By.xpath("//*[@id=\"account-address\"]/div[1]")).getText())
          .as("Text should be: Warning: You must have at least one address!")
          .isEqualTo("Warning: You must have at least one address!");
      LOG.info("Assertion of text if initial number of addresses !>1 is done.");
    }
  }
}
