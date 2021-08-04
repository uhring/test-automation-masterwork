import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Your Store web application marketplace")
@Feature("Listing data")
@Story("Navigate to the next page with more results after listing all sales items")
public class TC07_Pagination extends BaseTest {

  @Test
  @DisplayName("Navigate to the next page with more results after listing all sales items")
  public void pagination() {
    homePage.openHomePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.listAllItems();
    makeScreenshot();
    LOG.info("screenshot taken");
    homePage.paginateOnePage();
    makeScreenshot();
    LOG.info("screenshot taken");
    assertThat(homePage.getListedProductsNumber().getText())
        .as("Text should be : Showing 16 to 16 of 16 (2 Pages)")
        .isEqualTo("Showing 16 to 16 of 16 (2 Pages)");
    LOG.info("Assertion done Text below the item as expected.");
  }
}