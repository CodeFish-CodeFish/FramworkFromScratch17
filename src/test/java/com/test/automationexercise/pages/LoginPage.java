package com.test.automationexercise.pages;

import com.test.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    private WebElement signUpHeader;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    public void newUserSignUp(String username,String email){
        this.name.sendKeys(username);
        this.email.sendKeys(email);
        signUpButton.click();
    }

    public String signUpHeader(){
        return BrowserUtils.getText(signUpHeader);
    }
}
