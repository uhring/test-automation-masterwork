import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Failed registration with previously registered email")
public class TC02_FailedRegistration extends BaseTest {

  @Test
  @DisplayName("Failed registration with previously registered email")
  public void unsuccessfulRegistration() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.registerNewCustomer();
    makeScreenshot();
    LOG.info("screenshot taken");
    registerAccountPage.registerAccount("Nagy", "Ilona", registeredEmail, "061111111", registeredPassword);
    makeScreenshot();
    LOG.info("screenshot taken");
    assertThat(registerAccountPage.getWarningEmailAlreadyRegistered().getText())
        .isEqualTo("Warning: E-Mail Address is already registered!");
    LOG.info("Email already registered warning is displayed");
  }
}