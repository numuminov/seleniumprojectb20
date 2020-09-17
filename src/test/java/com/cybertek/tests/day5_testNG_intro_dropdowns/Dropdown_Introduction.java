package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_Introduction {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        driver.get("http://practice.cybertekschool.com/dropdown");

    }



    @Test
    public void dropdown_test_1(){
        /*
        TC#1: Verifying “Simple dropdown” and
         “State selection” dropdown default values
         1.Open Chrome browser
         2.Go to http://practice.cybertekschool.com/dropdown
         3.Verify “Simple dropdown” default selected value
         is correct Expected: “Please select an option”
         4.Verify“State selection” default selected value
          is correct Expected: “Select a State”
         */
        WebElement dropdown1=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropdown1);
        String actualOption=select.getFirstSelectedOption().getText();
        String expextedOption="Please select an option";

        Assert.assertEquals(actualOption,expextedOption);

        select.selectByVisibleText("Option 2");





    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
