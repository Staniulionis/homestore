package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.stream.Stream;

public class MyAccountPage extends BasePage {

    @FindBy(css = "#username")
    private WebElement un;
    @FindBy(css = "#password")
    private WebElement passw;
    @FindBy(css = "[value=\"Log in\"]")
    private WebElement logInButton;
    @FindBy(css = ".woocommerce-error")
    private WebElement errorMessageAlert;
    @FindBy(css = "a[href$=\"lost-password/\"]")
    private WebElement lostPasswbutton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public void clickLostPasswordBtn(){
        lostPasswbutton.click();
    }
    public boolean badCredentialsAlertMessage(){
        return errorMessageAlert.isDisplayed();
    }
    public String unknownUsernameErrorAlert(){
        return errorMessageAlert.getText();
    }
    public String unknownEmailErrorAlert(){
        return errorMessageAlert.getText();
    }
    public String usernameIsRequiredAlert(){
        return errorMessageAlert.getText();
    }
    public String passwordIsRequiredAlert(){
        return errorMessageAlert.getText();
    }
    public void typeUserNameIntoUsernameField(String userName){
        un.sendKeys(userName);
    }
    public void typePasswordIntoPasswrodField(String password){
        passw.sendKeys(password);
    }
    public void clickLoginBtn(){
        logInButton.click();
    }
}