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
@Story("Successful registration")
public class TC01_SuccessfulRegistration extends BaseTest {
  protected String email = "nagy" + ((int) (Math.random() * 10000)) + "@ilona.hu";

  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
  RegisterAccountPage registerAccountPage = PageFactory.initElements(driver, RegisterAccountPage.class);

  @Test
  @DisplayName("Successful registration")
  public void successfulRegistration() {
    homePage.openHomePage();
    homePage.openLoginPage();
    loginPage.registerNewCustomer();
    registerAccountPage.registerAccount("Ilona", "Nagy", email, "061111111", "nagyi");
    assertThat(driver.getTitle()).isEqualTo("Your Account Has Been Created!");
    LOG.info("Account created successfully");
  }
}