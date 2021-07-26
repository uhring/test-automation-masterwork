import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Failed registration with previously registered email")
public class TC2_FailedRegistration extends BaseTest {
    RegisterAccountPage registerAccount = PageFactory.initElements(driver, RegisterAccountPage.class);

    @Test
    @DisplayName("Failed registration with previously registered email")
    public void unsuccessfulRegistration() {
        registerAccount.openHomePage();
        registerAccount.openLoginPage();
        registerAccount.registerNewCustomer();
        registerAccount.registerAccount("Nagy", "Ilona", "nagy@ilona.hu", "061111111", "nagyi");
        assertThat(registerAccount.getWarningEmailAlreadyRegistered().getText())
                .isEqualTo("Warning: E-Mail Address is already registered!");
        LOG.info("Email already registered warning is displayed");
    }
}