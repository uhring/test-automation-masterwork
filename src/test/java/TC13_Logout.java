import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("Logout")
@Story("Login and logout")
public class TC13_Logout extends BaseTest {
  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
  MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

  @Test
  @DisplayName("Login and logout")
  public void logoutTest() {
    homePage.openHomePage();
    homePage.openLoginPage();
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    myAccountPage.logout();
    assertThat(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText())
        .as("Text should be: Account Logout")
        .isEqualTo("Account Logout");
    LOG.info("Assertion after logout OK");
  }
}