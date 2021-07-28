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
@Story("Successful login")
public class TC03_SuccessfulLogin extends BaseTest {
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

  @Test
  @DisplayName("Successful login")
  public void successfulLogin() {
    loginPage.openHomePage();
    loginPage.openLoginPage();
    loginPage.loginReturningCustomer(registeredEmail, regiteredPassword);
    assertThat(driver.getTitle()).isEqualTo("My Account");
    LOG.info("Login successful");
  }
}
