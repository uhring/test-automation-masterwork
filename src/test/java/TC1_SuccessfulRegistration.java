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
@Story("Successful registration")
public class TC1_SuccessfulRegistration extends BaseTest{
    protected String email = "nagy" + ((int) (Math.random() * 10000)) + "@ilona.hu";

    LoginPage loginPage = PageFactory.initElements(driver , LoginPage.class);
    RegisterAccount registerAccountPage = PageFactory.initElements(driver, RegisterAccount.class);
    @Test
    @DisplayName("Successful registration")
    public void successfulRegistration(){
        loginPage.openHomePage();
        loginPage.openLoginPage();
        loginPage.registerNewCustomer();
        registerAccountPage.registerAccount("Nagy","Ilona", email,"061111111", "nagyi");
        assertThat(driver.getTitle()).isEqualTo("Your Account Has Been Created!");
        LOG.info("Account created successfully");
    }
}