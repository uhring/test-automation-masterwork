import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Logout")
@Story("Login and logout")
public class TC13_Logout extends BaseTest {

  @Test
  @DisplayName("Login and logout")
  public void logoutTest() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    makeScreenshot();
    LOG.info("screenshot taken");
    myAccountPage.logout();
    makeScreenshot();
    LOG.info("screenshot taken");
    assertThat(driver.getTitle())
        .as("Title should be: Account Logout")
        .isEqualTo("Account Logout");
    LOG.info("Assertion after logout OK");
  }
}