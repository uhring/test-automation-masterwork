package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddAddressPage extends AddressBookPage{

    public AddAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    WebElement inputLastName;

    @FindBy(id = "input-address-1")
    WebElement inputAddress;

    @FindBy(id = "input-city")
    WebElement inputCity;

    @FindBy(id = "input-postcode")
    WebElement inputPostCode;

    @FindBy(id = "input-country")
    WebElement countryDropdown;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    WebElement continueButton;

    public void addNewAddress (String firstName, String lastName, String address, String city, String postcode, String country){
        inputFirstName.sendKeys(firstName);
        LOG.info("First name input : " + firstName);
        inputLastName.sendKeys(lastName);
        LOG.info("Last name input: " + lastName);
        inputAddress.sendKeys(address);
        LOG.info("Address input: " + address);
        inputCity.sendKeys(city);
        LOG.info("City input: " + city);
        inputPostCode.sendKeys(postcode);
        LOG.info("Post code input: " + postcode);
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        LOG.info("Country selected: " + country);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        LOG.info("Continue button clicked");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));
        LOG.info("Wait until next page loaded");
    }
}
