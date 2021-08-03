import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Login")
@Story("Failed login - invalid password")
public class TC04_FailedLogin extends BaseTest {

  @Test
  @DisplayName("Failed login - invalid password")
  public void failedLogin() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.loginReturningCustomer(registeredEmail, "nag");
    makeScreenshot();
    LOG.info("screenshot taken");
    assertThat(loginPage.getWarningNoMatch().getText())
        .isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    LOG.info("Assert OK. Login failed.");
  }
}