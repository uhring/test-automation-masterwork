package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditAccountPage extends MyAccountPage {
  public EditAccountPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "input-firstname")
  WebElement firstNameField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement continueButton;

  public void modifyFirstName(String firstName) {
    firstNameField.clear();
    LOG.info("Clear first name field");
    firstNameField.sendKeys(firstName);
    LOG.info("Fill new data to first name field");
    wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    continueButton.click();
    LOG.info("Click on Continue");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account-account\"]/div[1]")));
  }
}
