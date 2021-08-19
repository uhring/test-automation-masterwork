import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Successful registration")
public class TC01_SuccessfulRegistration extends BaseTest {
  protected String email = "nagyilona" + ((int) (Math.random() * 10000)) + "@ilona.hu";

  @Test
  @DisplayName("Successful registration")
  public void successfulRegistration() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.openLoginPage();
    makeScreenshot();
    LOG.info("screenshot taken");
    loginPage.registerNewCustomer();
    makeScreenshot();
    LOG.info("screenshot taken");
    registerAccountPage.registerAccount("Ilona", "Nagy", email, "061111111", "nagyi");
    makeScreenshot();
    LOG.info("screenshot taken");
    assertThat(driver.getTitle()).isEqualTo("Your Account Has Been Created!");
    LOG.info("Account created successfully");
  }
}