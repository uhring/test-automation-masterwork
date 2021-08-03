import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Login")
@Story("Successful login")
public class TC03_SuccessfulLogin extends BaseTest {

  @Test
  @DisplayName("Successful login")
  public void successfulLogin() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    makeScreenshot();
    LOG.info("screenshot taken");
    assertThat(driver.getTitle()).isEqualTo("My Account");
    LOG.info("Login successful");
  }
}