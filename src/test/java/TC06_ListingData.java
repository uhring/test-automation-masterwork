import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application marketplace")
@Feature("Listing data")
@Story("Listing all sales items")
public class TC06_ListingData extends BaseTest {

  @Test
  @DisplayName("Listing all sales items")
  public void listingData() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.listAllItems();
    makeScreenshot();
    LOG.info("Screenshot taken");
    List<WebElement> productList = driver.findElements(By.className("product-layout"));
    assertThat(productList.size())
        .as("There should be 15 items listed on one page")
        .isEqualTo(15);
    LOG.info("Assertion done - 15 items on the page");
  }
}