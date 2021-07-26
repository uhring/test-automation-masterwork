package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterAccount extends YourStoreMain{
    public RegisterAccount(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    WebElement privacyCheckbox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    WebElement warningEmailAlreadyRegistered;

    public void registerAccount(String firstName, String lastName, String email, String telephone, String password){
        firstNameField.sendKeys(firstName);
        LOG.info("First name field done");
        lastNameField.sendKeys(lastName);
        LOG.info("Last name field done");
        emailField.sendKeys(email);
        LOG.info("Email field done");
        telephoneField.sendKeys(telephone);
        LOG.info("Telephone field done");
        passwordField.sendKeys(password);
        LOG.info("Password field done");
        passwordConfirmField.sendKeys(password);
        LOG.info("Password confirmation field done");
        privacyCheckbox.click();
        LOG.info("Clicked on privacy checkbox");
        continueButton.click();
        LOG.info("Click on continue button");
    }

    public WebElement getWarningEmailAlreadyRegistered(){
        return warningEmailAlreadyRegistered;
    }
}