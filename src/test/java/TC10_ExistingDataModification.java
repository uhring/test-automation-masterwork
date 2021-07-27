import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.EditAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application user administration")
@Feature("User data administration")
@Story("Modification of the customer's first name")
public class TC10_ExistingDataModification extends BaseTest{
    EditAccountPage editAccountPage = PageFactory.initElements(driver, EditAccountPage.class);

    @Test
    @DisplayName("Modification of the customer's first name")
    public void modificationOfFirstName(){
        editAccountPage.openHomePage();
        editAccountPage.openLoginPage();
        editAccountPage.loginReturningCustomer("nagy@ilona.hu", "nagyi");
        editAccountPage.goToEditAccountPage();
        editAccountPage.modifyFirstName("Ilonka");
        assertThat(driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText())
                .as("Text should be: Success: Your account has been successfully updated.")
                .isEqualTo("Success: Your account has been successfully updated.");
        LOG.info("Assertion on actual and expected text is done");
    }
}