package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends YourStoreMain{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/a")
    WebElement continueButton;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input[1]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    WebElement warningNoMatch;


    public void registerNewCustomer(){
        continueButton.click();
        LOG.info("Click on continue button");

        assertThat(driver.getTitle()).isEqualTo("Register Account");
        LOG.info("Register Account page loaded successfully");
    }
    public void loginReturningCustomer(String email, String password){
        emailField.sendKeys(email);
        LOG.info("Email written in the email field");
        passwordField.sendKeys(password);
        LOG.info("Password written in the password field");
        loginButton.click();
        LOG.info("Click on login button");
    }

    public WebElement getWarningNoMatch() {
        return warningNoMatch;
    }
}
