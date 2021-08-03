import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

public class BaseTest {
  protected static WebDriver driver;
  protected static WebDriverWait wait;
  protected static Logger LOG = LoggerFactory.getLogger(BaseTest.class);
  protected String registeredEmail = "nagy@ilona.hu";
  protected String registeredPassword = "nagyi";

  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
  RegisterAccountPage registerAccountPage = PageFactory.initElements(driver, RegisterAccountPage.class);
  MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
  AddressBookPage addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
  AddAddressPage addAddressPage = PageFactory.initElements(driver, AddAddressPage.class);
  EditAccountPage editAccountPage = PageFactory.initElements(driver, EditAccountPage.class);

  @BeforeAll
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    wait = new WebDriverWait(driver, 10);
  }

  @AfterAll
  public static void cleanup() {
    driver.quit();
  }

  @Attachment("screenshot")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
