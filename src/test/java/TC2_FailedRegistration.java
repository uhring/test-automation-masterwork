import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.RegisterAccount;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store webapplication user administration")
@Feature("User registration")
@Story("Failed registration with previously registered email")
public class TC2_FailedRegistration extends BaseTest{
    LoginPage loginPage = PageFactory.initElements(driver , LoginPage.class);
    RegisterAccount registerAccountPage = PageFactory.initElements(driver, RegisterAccount.class);
    @Test
    @DisplayName("Failed registration with previously registered email")
    public void unsuccessfulRegistration(){
        loginPage.openHomePage();
        loginPage.openLoginPage();
        loginPage.registerNewCustomer();
        registerAccountPage.registerAccount("Nagy","Ilona", "nagy@ilona.hu","061111111", "nagyi");
        assertThat(registerAccountPage.getWarningEmailAlreadyRegistered().getText())
                .isEqualTo("Warning: E-Mail Address is already registered!");
        LOG.info("Email already registered warning is displayed");
    }
}
