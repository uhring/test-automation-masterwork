import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.YourStoreHome;

@Epic("Your Store web application marketplace")
@Feature("Listing and saving data from the web application")
@Story("Save the name, description and price of all laptops from the list into a text file")
public class TC12_SavingDataFromTheWebApplication extends BaseTest{
  YourStoreHome home = PageFactory.initElements(driver, YourStoreHome.class);

  @Test
  @DisplayName("Save the name, description and price of all laptops from the list into a text file")
  public void savingDataToFile(){
    home.openHomePage();
    home.listLaptops();
    home.writeToFile();
  }
}
