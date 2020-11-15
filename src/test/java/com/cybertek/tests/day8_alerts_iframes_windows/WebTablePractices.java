package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);

    }

    @Test
    public void task4_verify_order(){
        //SmartBearUtilities.verifyOrder(driver,"Mark Smith");
        SmartBearUtilities.verifyOrder(driver,"Mark Smiths");
    }
    @Test
    public void task5_print_city_name(){
        SmartBearUtilities.printNamesAndCities(driver);
    }
}
