package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class YourStoreHome {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Actions action;
  protected static Logger LOG = LoggerFactory.getLogger(YourStoreHome.class);

  @FindBy(xpath = "//div[4]/ul/li/a[contains(.,'My Account')]")
  WebElement myAccount;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
  WebElement desktopsList;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
  WebElement showAllDesktops;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
  WebElement laptopList;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
  WebElement showAllLaptops;

  @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[1]/ul/li[3]/a")
  WebElement showMoreItems;

  public YourStoreHome(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
    this.action = new Actions(driver);
  }

  public void openHomePage() {
    driver.get("http://test-automation-shop2.greenfox.academy/");
    LOG.info("Opening YourStore homepage...");

    assertThat(driver.getTitle()).isEqualTo("Your Store");
    LOG.info("YourStore Page loaded successfully");
  }

  public void openLoginPage() {
    myAccount.click();
    LOG.info("Opening login page");

    assertThat(driver.getTitle()).isEqualTo("Account Login");
    LOG.info("Account Login page loaded successfully");
  }

  public void listAllItems() {
    action.moveToElement(desktopsList).perform();
    LOG.info("Move pointer to \"Desktops\" tab");
    showAllDesktops.click();
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']"), 0));
    LOG.info("Click \"Show All Desktops\" from the dropdown list");
  }

  public void paginateOnePage() {
    showMoreItems.click();
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"content\"]/div[4]/div"), 0));
    LOG.info("Paginate to the next page");
  }

  public void listLaptops() {
    action.moveToElement(laptopList).perform();
    LOG.info("Move pointer to \"Laptops & Notebooks\" tab");
    showAllLaptops.click();
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']"), 0));
    LOG.info("Click \"Show All Laptops & Notebooks\" from the dropdown list");
  }

  public void writeToFile() {
    Path fileToWrite = Paths.get("src/test/resources/output.txt");

    List<WebElement> name = driver.findElements(By.xpath("//div[@class='caption']/h4"));
    List<WebElement> description = driver.findElements(By.xpath("//div[@class='caption']/p[1]"));
    List<WebElement> price = driver.findElements(By.xpath("//div[@class='caption']/p[2]"));

    List<String> linesToFile = new ArrayList<>();

    for (int i = 0; i < name.size(); i++) {
      linesToFile.add(name.get(i).getText());
      linesToFile.add(description.get(i).getText());
      linesToFile.add(price.get(i).getText());
      linesToFile.add("\n");
    }
    try {
      Files.write(fileToWrite, linesToFile);
      LOG.info("Write output.txt file");
    } catch (IOException e) {
      System.out.println(" Output.txt file cannot write");
    }
  }
}
