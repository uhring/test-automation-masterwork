import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Open privacy statement and check the checkbox")
public class TC05_UsingPrivacyStatement extends BaseTest {

  @Test
  @DisplayName("Open privacy statement and check the checkbox")
  public void openPrivacyStatement() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.registerNewCustomer();
    makeScreenshot();
    LOG.info("screenshot taken");
    registerAccountPage.openPrivacyPolicy();
    assertThat(registerAccountPage.getPrivacyPolicy().getText())
        .isEqualTo("Privacy Policy");
    LOG.info("Privacy policy text asserted");
    makeScreenshot();
    LOG.info("Screenshot taken");
    registerAccountPage.closePrivacyPolicy();
    registerAccountPage.acceptPrivacyPolicy();
    makeScreenshot();
    LOG.info("Screenshot taken");
    assertThat(registerAccountPage.getPrivacyCheckbox().isSelected())
        .isTrue();
    LOG.info("Privacy checkbox checked successfully");
  }
}