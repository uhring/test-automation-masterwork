import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.YourStoreHome;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application marketplace")
@Feature("Listing data")
@Story("Listing all sales items")
public class TC06_ListingData extends BaseTest {
  YourStoreHome home = PageFactory.initElements(driver, YourStoreHome.class);

  @Test
  @DisplayName("Listing all sales items")
  public void listingData() {
    home.openHomePage();
    home.listAllItems();
    makeScreenshot();
    LOG.info("Screenshot taken");
    assertThat(driver.findElements(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']")).size())
        .as("There should be 15 items listed on one page")
        .isEqualTo(15);
    LOG.info("Assertion done - 15 items on the page");
  }

}
