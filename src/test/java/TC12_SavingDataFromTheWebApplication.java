import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Epic("Your Store web application marketplace")
@Feature("Listing and saving data from the web application")
@Story("Save the name, description and price of all laptops from the list into a text file")
public class TC12_SavingDataFromTheWebApplication extends BaseTest {
  HomePage homePage = PageFactory.initElements(driver, HomePage.class);

  @Test
  @DisplayName("Save the name, description and price of all laptops from the list into a text file. " +
      "File path: src/test/output.txt")
  public void savingDataToFile() {
    homePage.openHomePage();
    homePage.listAllLaptops();
    writeToFile();
    LOG.info("File written to /test");
  }

  public void writeToFile() {
    Path fileToWrite = Paths.get("src/test/output.txt");

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
