import org.example.HomePage;
import org.example.MyAccountPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyAccountTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;

    @Test
    @DisplayName("Login failure with bad username")
    void userCanNotLoginInLoginPageWithBadUsername() {

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.typeUserNameIntoUsernameField("tes tas");
        myAccountPage.typePasswordIntoPasswrodField("test58 3.!$% as");
        myAccountPage.clickLoginBtn();

        Assertions.assertTrue(myAccountPage.badCredentialsAlertMessage());
    }

    @Test
    @DisplayName("Login failure with bad email")
    void userCanNotLoginInLoginPageWithBadEmail() {

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.typeUserNameIntoUsernameField("tes tas@mail.com");
        myAccountPage.typePasswordIntoPasswrodField("test58 3.!$% as");
        myAccountPage.clickLoginBtn();

        Assertions.assertTrue(myAccountPage.badCredentialsAlertMessage());
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

        Assertions.assertTrue(myAccountPage.badCredentialsAlertMessage());
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

        Assertions.assertTrue(myAccountPage.badCredentialsAlertMessage());
    }
}