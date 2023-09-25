package com.test.automationexercise.pages;

import com.test.utils.BrowserUtils;
import com.test.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Signup')]")
    private WebElement signUpButton;
    @FindBy(xpath = "//a[contains(text(),'Logged')]")
    private WebElement loggedInAsUser;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    private WebElement deleteAccountButton;

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public void loggedInAsUser(String expectedMessage){
        expectedMessage=expectedMessage.concat(ConfigReader.readProperty("QA_username"));
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(loggedInAsUser));
    }
}
