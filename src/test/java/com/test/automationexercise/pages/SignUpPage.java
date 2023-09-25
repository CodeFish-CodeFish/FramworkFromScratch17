package com.test.automationexercise.pages;

import com.test.utils.BrowserUtils;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Enter')]")
    private WebElement signUpHeader;

    @FindBy(xpath = "//input[@name='title']")
    private List<WebElement> genders;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#days")
    private WebElement days;

    @FindBy(css = "#months")
    private WebElement months;

    @FindBy(css = "#years")
    private WebElement years;

    @FindBy(css = "#newsletter")
    private WebElement newsLetterBox;

    @FindBy(css = "#optin")
    private WebElement specialOfferBox;

    @FindBy(css = "#first_name")
    private WebElement firstName;

    @FindBy(css = "#last_name")
    private WebElement lastName;

    @FindBy(css = "#company")
    private WebElement company;

    @FindBy(css = "#address1")
    private WebElement address;

    @FindBy(css = "#address2")
    private WebElement address2;

    @FindBy(css = "#country")
    private WebElement country;

    @FindBy(css = "#state")
    private WebElement state;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#zipcode")
    private WebElement zipCode;

    @FindBy(css = "#mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b")
    private WebElement accountCreatedAndDeletedHeader;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public String signUpHeaderAccount() {
        return BrowserUtils.getText(signUpHeader);
    }

    public void provideAccountInformation(String gender, String password, String dateOfBirth) {
        chooseGender(gender);
        this.password.sendKeys(password); //    8/13/1991  -->8,13,1991
        String[] dateOfBirthData = dateOfBirth.split("/");
        BrowserUtils.selectBy(this.months, dateOfBirthData[0], "value");
        BrowserUtils.selectBy(this.days, dateOfBirthData[1], "value");
        BrowserUtils.selectBy(this.years, dateOfBirthData[2], "text");
    }

    public void selectNewsLetterAndOffers(){
        if(!newsLetterBox.isSelected()&& newsLetterBox.isEnabled()&& newsLetterBox.isDisplayed()){
            newsLetterBox.click();
        }
        Assert.assertTrue(newsLetterBox.isSelected());
        if(!specialOfferBox.isSelected() && specialOfferBox.isEnabled()&& specialOfferBox.isDisplayed()){
            specialOfferBox.click();
        }
        Assert.assertTrue(specialOfferBox.isSelected());
    }

    public void provideCustomerData(String firstName,String lastName,String company,String address1,String address2,
                                    String country,String state,String city,String zipCode,String mobileNumber) throws InterruptedException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.address.sendKeys(address1);
        this.address2.sendKeys(address2);
        BrowserUtils.selectBy(this.country,country,"value");
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipCode.sendKeys(zipCode);
        this.mobileNumber.sendKeys(mobileNumber);
        Thread.sleep(3000);
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

    public String createdDeletedAccountHeader(){
        return BrowserUtils.getText(accountCreatedAndDeletedHeader);
    }

    public void clickContinueButton(){
        continueButton.click();
    }







    public void chooseGender(String expectedGender) {
        for (WebElement gender : genders) {
            if (gender.getAttribute("value").equals(expectedGender)) {
                gender.click();
                return;
            }
        }
        Assert.fail("The gender is not matching with Database");
    }

}
