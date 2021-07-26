import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.RegisterAccount;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User registration")
@Story("Open privacy statement and check the checkbox")
public class TC5_UsingPrivacyStatement extends BaseTest{
    LoginPage loginPage = PageFactory.initElements(driver , LoginPage.class);
    RegisterAccount registerAccountPage = PageFactory.initElements(driver, RegisterAccount.class);
    @Test
    @DisplayName("Open privacy statement and check the checkbox")
    public void openPrivacyStatement(){
        loginPage.openHomePage();
        loginPage.openLoginPage();
        loginPage.registerNewCustomer();
        registerAccountPage.openPrivacyPolicy();
        makeScreenshot();
        registerAccountPage.closePrivacyPolicy();
        registerAccountPage.acceptPrivacyPolicy();
        makeScreenshot();
        assertThat(registerAccountPage.getPrivacyCheckbox().isSelected())
                .isTrue();
        LOG.info("Privacy checkbox checked successfully");
    }
}
