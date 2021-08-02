import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User data administration")
@Story("Modification of the customer's first name")
public class TC10_ExistingDataModification extends BaseTest {
  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
  MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
  EditAccountPage editAccountPage = PageFactory.initElements(driver, EditAccountPage.class);

  @Test
  @DisplayName("Modification of the customer's first name")
  public void modificationOfFirstName() {
    homePage.openHomePage();
    homePage.openLoginPage();
    loginPage.loginReturningCustomer(registeredEmail, registeredPassword);
    myAccountPage.goToEditAccountPage();
    editAccountPage.modifyFirstName("Ilona" + (int) (Math.random() * 100));
    assertThat(driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText())
        .as("Text should be: Success: Your account has been successfully updated.")
        .isEqualTo("Success: Your account has been successfully updated.");
    LOG.info("Assertion on actual and expected text is done");
    makeScreenshot();
    LOG.info("Success screenshot taken");
  }
}