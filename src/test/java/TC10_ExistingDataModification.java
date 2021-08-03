import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User data administration")
@Story("Modification of the customer's first name")
public class TC10_ExistingDataModification extends BaseTest {

  @Test
  @DisplayName("Modification of the customer's first name")
  public void modificationOfFirstName() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    makeScreenshot();
    LOG.info("screenshot taken");
    myAccountPage.goToEditAccountPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    editAccountPage.modifyFirstName("Ilona" + (int) (Math.random() * 100));
    makeScreenshot();
    LOG.info("Success screenshot taken");
    assertThat(driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText())
        .as("Text should be: Success: Your account has been successfully updated.")
        .isEqualTo("Success: Your account has been successfully updated.");
    LOG.info("Assertion on actual and expected text is done");
  }
}