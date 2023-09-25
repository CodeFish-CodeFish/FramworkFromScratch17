package com.test.automationexercise.stepdefinitions;

import com.test.automationexercise.pages.LoginPage;
import com.test.automationexercise.pages.MainPage;
import com.test.automationexercise.pages.SignUpPage;
import com.test.utils.ConfigReader;
import com.test.utils.DriverHelper;
import io.cucumber.core.cli.Main;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Registration_Removing_Account {
    WebDriver driver= DriverHelper.getDriver();
    MainPage mainPage=new MainPage(driver);
    LoginPage loginPage=new LoginPage(driver);
    SignUpPage signUpPage=new SignUpPage(driver);
    @Given("User navigates to the AutomationExercise and validates the {string}")
    public void user_navigates_to_the_automation_exercise_and_validates_the(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @When("User clicks signUp Login button and validates the {string} visible")
    public void user_clicks_sign_up_login_button_and_validates_the_visible(String expectedHeader) {
        mainPage.clickSignUpButton();
        Assert.assertEquals(expectedHeader,loginPage.signUpHeader());
    }
    @When("User provides username,email address and click sign up button")
    public void user_provides_username_email_address_and_click_sign_up_button() {
        loginPage.newUserSignUp(
                ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_email"));
    }
    @When("User verify {string} message is visible")
    public void user_verify_message_is_visible(String expectedHeader) {
        Assert.assertEquals(expectedHeader,signUpPage.signUpHeaderAccount());
    }
    @When("User provides {string},password,and {string} to enter account page")
    public void user_provides_password_and_to_enter_account_page(String gender, String dateOfBirth) {
        signUpPage.provideAccountInformation(gender,ConfigReader.readProperty("QA_password"),dateOfBirth);
    }
    @When("User selects sign up for our newsletter and Receive special offers from our partners boxes")
    public void user_selects_sign_up_for_our_newsletter_and_receive_special_offers_from_our_partners_boxes() {
        signUpPage.selectNewsLetterAndOffers();
    }
    @When("User provides {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string} to the boxes")
    public void user_provides_and_to_the_boxes(String firstName,String lastName,String company,String address1,String address2, String country,String state,String city,String zipCode,String mobileNumber) throws InterruptedException {
        signUpPage.provideCustomerData(firstName,lastName,company,address1,address2,country,state,city,zipCode,mobileNumber);
    }
    @When("User clicks Create account button and validates {string} from the page")
    public void user_clicks_create_account_button_and_validates_from_the_page(String expectedHeader) {
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(expectedHeader,signUpPage.createdDeletedAccountHeader());
    }
    @When("User clicks Continue button and validates {string} is visible")
    public void user_clicks_continue_button_and_validates_is_visible(String expectedMessage) {
    signUpPage.clickContinueButton();
    mainPage.loggedInAsUser(expectedMessage);
    }
    @Then("User clicks Delete Account button and validates {string} is visible")
    public void user_clicks_delete_account_button_and_validates_is_visible(String expectedHeader) {
    mainPage.clickDeleteAccountButton();
    Assert.assertEquals(expectedHeader,signUpPage.createdDeletedAccountHeader());
    }
    @Then("User clicks Continue button")
    public void user_clicks_continue_button() {
    signUpPage.clickContinueButton();
    }
}
