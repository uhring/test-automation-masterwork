package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DesktopsPage extends BasePage{

  public DesktopsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[1]/ul/li[3]/a")
  WebElement showMoreItems;

  @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[2]")
  WebElement listedProductsNumber;

  public void paginateOnePage() {
    showMoreItems.click();
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"content\"]/div[4]/div"), 0));
    LOG.info("Paginate to the next page");
  }

  public WebElement getListedProductsNumber() {
    return listedProductsNumber;
  }
}
