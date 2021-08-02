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
@Story("Failed registration with previously registered email")
public class TC02_FailedRegistration extends BaseTest {

  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
  RegisterAccountPage registerAccountPage = PageFactory.initElements(driver, RegisterAccountPage.class);

  @Test
  @DisplayName("Failed registration with previously registered email")
  public void unsuccessfulRegistration() {
    homePage.openHomePage();
    homePage.openLoginPage();
    loginPage.registerNewCustomer();
    registerAccountPage.registerAccount("Nagy", "Ilona", registeredEmail, "061111111", registeredPassword);
    assertThat(registerAccountPage.getWarningEmailAlreadyRegistered().getText())
        .isEqualTo("Warning: E-Mail Address is already registered!");
    LOG.info("Email already registered warning is displayed");
  }
}