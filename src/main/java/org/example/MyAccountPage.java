package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(css = "#username")
    private WebElement un;
    @FindBy(css = "#password")
    private WebElement passw;
    @FindBy(css = "[value=\"Log in\"]")
    private WebElement logInButton;
    @FindBy(css = ".woocommerce-error")
    private WebElement badCredentialsAlert;
    @FindBy(css = "a[href$=\"lost-password/\"]")
    private WebElement lostPasswbutton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public void clickLostPasswordBtn(){
        lostPasswbutton.click();
    }
    public boolean badCredentialsAlertMessage(){
        return badCredentialsAlert.isDisplayed();
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