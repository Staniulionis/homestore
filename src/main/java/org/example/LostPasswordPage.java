package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LostPasswordPage extends BasePage {

    @FindBy(css = "#user_login")
    private WebElement inputLostPasswField;
    @FindBy(css = "[value=\"Reset password\"]")
    private WebElement resetButton;
    @FindBy(css = ".woocommerce-error")
    private WebElement invalidUnOrEmailAlert;
    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }
    public void entersInvalidUsernameOrEmailInLostPasswordPage(String lostPasswUserNameOrEmail){
        inputLostPasswField.sendKeys(lostPasswUserNameOrEmail);
    }
    public void clickResetPasswordBtn(){
        resetButton.click();
    }
    public boolean badUsernameOrEMailAlert(){
        return invalidUnOrEmailAlert.isDisplayed();
    }
}
