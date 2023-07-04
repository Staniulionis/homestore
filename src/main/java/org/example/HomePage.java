package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "#menu-item-228")
    private WebElement myAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickMyAccountBtn(){
        myAccountButton.click();
    }
}
