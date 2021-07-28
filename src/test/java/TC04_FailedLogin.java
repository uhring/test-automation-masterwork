import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Login")
@Story("Failed login - invalid password")
public class TC04_FailedLogin extends BaseTest {
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

  @Test
  @DisplayName("Failed login - invalid password")
  public void failedLogin() {
    loginPage.openHomePage();
    loginPage.openLoginPage();
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    assertThat(loginPage.getWarningNoMatch().getText())
        .isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    LOG.info("Assert OK. Login failed.");
  }
}