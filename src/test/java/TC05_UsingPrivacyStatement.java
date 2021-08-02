import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Open privacy statement and check the checkbox")
public class TC05_UsingPrivacyStatement extends BaseTest {

  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
  RegisterAccountPage registerAccountPage = PageFactory.initElements(driver, RegisterAccountPage.class);

  @Test
  @DisplayName("Open privacy statement and check the checkbox")
  public void openPrivacyStatement() {
    homePage.openHomePage();
    homePage.openLoginPage();
    loginPage.registerNewCustomer();
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