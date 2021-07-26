import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;
import pages.AddAddressPage;

@Epic("Your Store web application user administration")
@Feature("Address book administration")
@Story("Add multiple new addresses to an existing account from .csv file")
public class TC9_RepetitiveDataEntryFromExternalSource extends BaseTest{
    AddAddressPage addAddressPage = PageFactory.initElements(driver, AddAddressPage.class);

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv", numLinesToSkip = 1)
    @DisplayName("Add multiple new addresses to an existing account from .csv file")
    public void addMultipleAddressesToAnAccount(String firstName, String lastName, String address, String city, String postCode, String country){
        addAddressPage.openHomePage();
        addAddressPage.openLoginPage();
        addAddressPage.loginReturningCustomer("nagy@ilona.hu", "nagyi");
        addAddressPage.goToAddressBook();
        addAddressPage.addAddress();
        addAddressPage.addNewAddress(firstName, lastName, address, city, postCode, country);
        addAddressPage.logout();
    }
}
