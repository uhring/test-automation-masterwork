package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class YourStoreMain {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static Logger LOG = LoggerFactory.getLogger(YourStoreMain.class);

    @FindBy(xpath = "//div[4]/ul/li/a[contains(.,'My Account')]")
    WebElement myAccount;

    public YourStoreMain(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
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

//    protected WebElement find(By locator) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
}
