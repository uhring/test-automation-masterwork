import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Open privacy statement and check the checkbox")
public class TC05_UsingPrivacyStatement extends BaseTest {
  RegisterAccountPage registerAccount = PageFactory.initElements(driver, RegisterAccountPage.class);

  @Test
  @DisplayName("Open privacy statement and check the checkbox")
  public void openPrivacyStatement() {
    registerAccount.openHomePage();
    registerAccount.openLoginPage();
    registerAccount.registerNewCustomer();
    registerAccount.openPrivacyPolicy();
    makeScreenshot();
    LOG.info("Screenshot taken");
    registerAccount.closePrivacyPolicy();
    registerAccount.acceptPrivacyPolicy();
    makeScreenshot();
    LOG.info("Screenshot taken");
    assertThat(registerAccount.getPrivacyCheckbox().isSelected())
        .isTrue();
    LOG.info("Privacy checkbox checked successfully");
  }
}