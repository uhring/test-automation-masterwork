import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application marketplace")
@Feature("Listing data")
@Story("Navigate to the next page with more results after listing all sales items")
public class TC07_Pagination extends BaseTest {
  HomePage home = PageFactory.initElements(driver, HomePage.class);

  @Test
  @DisplayName("Navigate to the next page with more results after listing all sales items")
  public void pagination() {
    home.openHomePage();
    home.listAllItems();
    home.paginateOnePage();
    assertThat(driver.findElement(By.xpath("//*[@id=\"content\"]/div[5]/div[2]")).getText())
        .as("Text should be : Showing 16 to 16 of 16 (2 Pages)")
        .isEqualTo("Showing 16 to 16 of 16 (2 Pages)");
    LOG.info("Assertion done Text below the item as expected.");

  }
}
