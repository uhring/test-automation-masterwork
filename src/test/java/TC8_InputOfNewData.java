import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AddAddressPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Address book administration")
@Story("Add address to an existing account")
public class TC8_InputOfNewData extends BaseTest {
  AddAddressPage addAddressPage = PageFactory.initElements(driver, AddAddressPage.class);

  @Test
  @DisplayName("Add address to an existing account")
  public void addAddressToAccount() {
    addAddressPage.openHomePage();
    addAddressPage.openLoginPage();
    addAddressPage.loginReturningCustomer("nagy@ilona.hu", "nagyi");
    addAddressPage.goToAddressBook();
    addAddressPage.addAddress();
    addAddressPage.addNewAddress("Ilona", "Nagy", "Nagy utca 1",
        "Budapest", "1999", "Hungary");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/h2")));
    assertThat(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText())
        .isEqualTo("Address Book Entries");
    LOG.info("Assertion done, text as expected.");
  }
}
