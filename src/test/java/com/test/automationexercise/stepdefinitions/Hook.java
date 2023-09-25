package com.test.automationexercise.stepdefinitions;

import com.test.utils.BrowserUtils;
import com.test.utils.ConfigReader;
import com.test.utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hook {

    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setup() {
        driver.get(ConfigReader.readProperty("QA_url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.getScreenShotWithCucumber(driver, scenario);
        driver.quit();
    }

}
