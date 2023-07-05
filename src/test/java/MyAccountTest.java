import org.example.HomePage;
import org.example.MyAccountPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MyAccountTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;

    @DisplayName("Login failure with bad username")
    @ParameterizedTest
    @CsvSource({"testas", "tes tas"})
    void userCanNotLoginInLoginPageWithBadUsername(String userName) {

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.typeUserNameIntoUsernameField(userName);
        myAccountPage.typePasswordIntoPasswrodField("test58 3.!$% as");
        myAccountPage.clickLoginBtn();

        Assertions.assertEquals("Error: The username " + userName + " is not registered on this site. If you are " +
                "unsure of your username, try your email address instead.", myAccountPage.unknownUsernameErrorAlert());
    }

    @DisplayName("Login failure with bad email")
    @ParameterizedTest
    @CsvSource({"testas@mail.com", "t3sta5@mail.com", "!!.te+-stas@mail.com"})

    void userCanNotLoginInLoginPageWithBadEmail(String email) {

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.typeUserNameIntoUsernameField(email);
        myAccountPage.typePasswordIntoPasswrodField("test58 3.!$% as");
        myAccountPage.clickLoginBtn();

        Assertions.assertEquals("Unknown email address. Check again or try your username.",
                myAccountPage.unknownEmailErrorAlert());
    }

    @Test
    @DisplayName("User leaves Username or email address field empty in login page")
    void userLeavesUsernameOrEmailFieldEmptyInLoginPage() {

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.typeUserNameIntoUsernameField("");
        myAccountPage.typePasswordIntoPasswrodField("test58 3.!$% as");
        myAccountPage.clickLoginBtn();

        Assertions.assertEquals("Error: Username is required.", myAccountPage.usernameIsRequiredAlert());
    }

    @Test
    @DisplayName("User leaves Password field empty in Login page")
    void userLeavesPasswordFieldEmptyInLoginPage() {

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.typeUserNameIntoUsernameField("tes tas@mail.com");
        myAccountPage.typePasswordIntoPasswrodField("");
        myAccountPage.clickLoginBtn();

        Assertions.assertEquals("Error: The password field is empty.", myAccountPage.passwordIsRequiredAlert());
    }
}