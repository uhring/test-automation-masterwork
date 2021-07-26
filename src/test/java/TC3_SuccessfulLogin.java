import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store webapplication")
@Feature("User administration")
@Story("Login")
public class TC3_SuccessfulLogin extends BaseTest{
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Test
    @DisplayName("Successful login")
    public void successfulLogin(){
        loginPage.openHomePage();
        loginPage.openLoginPage();
        loginPage.loginReturningCustomer("nagy@ilona.hu", "nagyi");
        assertThat(driver.getTitle()).isEqualTo("My Account");
        LOG.info("Login successful");
    }
}
