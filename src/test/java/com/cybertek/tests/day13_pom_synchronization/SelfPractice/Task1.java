package com.cybertek.tests.day13_pom_synchronization.SelfPractice;

import com.cybertek.pages.Loading1Page;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
    /*
    TC#41: Dynamically Loaded Page Elements 1
    1.Go to http://practice.cybertekschool.com/dynamic_loading/1
    2.Click to start
    3.Wait until loading bar disappears
    4.Assert username inputbox is displayed
    5.Enter username: tomsmith
    6.Enter password: incorrectpassword
    7.Click to Submit button
    8.Assert “Your username is invalid!” text is displayed.
    Note: Follow POM
     */

    @Test
    public void test1(){

        Driver.getDriver().get(ConfigurationReader.getProperty("urlFor1Page"));

        Loading1Page loading1Page =new Loading1Page();
        loading1Page.startButton.click();

        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),15);



       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button)[2]")));

       Assert.assertTrue(loading1Page.username.isDisplayed());

       loading1Page.username.sendKeys("tomsmith");

       loading1Page.password.sendKeys("incorrectpassword");

       loading1Page.loginButton.click();

       Assert.assertTrue(loading1Page.errorMessage.isDisplayed());



    }


}
