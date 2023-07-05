import org.example.HomePage;
import org.example.LostPasswordPage;
import org.example.MyAccountPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LostPasswordTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    LostPasswordPage lostPasswordPage;

    @Test
    @DisplayName("User enters invalid username or email into lost-password page")
    void userEntersInvalidUsernameOrEmailInLostPasswordPage(){

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.clickLostPasswordBtn();

        lostPasswordPage.entersInvalidUsernameOrEmailInLostPasswordPage("testas");
        lostPasswordPage.clickResetPasswordBtn();

        Assertions.assertEquals("Invalid username or email.", lostPasswordPage.getInvalidUsernameOrEmailErrorAlertText());
    }

    @Test
    @DisplayName("User leaves username or email field empty in Lost-password page")
    void userLeavesUsernameOrEmailFieldEmpty(){

        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        homePage.clickMyAccountBtn();

        myAccountPage.clickLostPasswordBtn();

        lostPasswordPage.entersInvalidUsernameOrEmailInLostPasswordPage("");
        lostPasswordPage.clickResetPasswordBtn();

        Assertions.assertEquals("Enter a username or email address.", lostPasswordPage.getEmptyFieldErrorAlertText());
    }
}