package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    /**
    PIQ.
ALERTS & HOW TO HANDLE THEM?
There are 2 types of alerts.
    1- HTML Alert/Pop Up
    2- JavaScript Alerts
1- HTML Alert:
    - Created using regular HTML tags, such as divs.
    - How to handle HTML ALERTS?
        - We locate just as any other web element.
        - And click to close/accept/dismiss.
2- JavaScript Alerts:
    - JS Alerts are created implementing JS in HTML.
    - When JS Alert is on the page, user cannot do any other action until handling the alert.
    To handle alerts, we need to create instance of "Alert" class, then switch driver's focus to the currently present alert.
    There are 3 types of JavaScript alerts
    1- Warning/Information Alert:
        - User has only one option: ACCEPT.
        - You can only accept this alert.
        syntax:
        Alert alert = driver.switchTo().alert();
        alert.accept();
    2- Confirmation Alert:
        - User has two options. ACCEPT or DECLINE.
        - You can accept or dismiss this alert.
        syntax:
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
    3- Prompt Alert:
        - User can accept, dismiss, and also sendKeys to this alert.
        syntax:
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("Anything you want to send inside of the alert");

     */

    @Test
    public void p1_information_alert_practice(){

        //Locating the warning/information alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //click to the button
        warningAlertButton.click();

        // Create Alert instance and switch to alert

        Alert alert =driver.switchTo().alert();
        BrowserUtils.wait(2);

        //use alert instance to accept the javascript alert(popup)
        alert.accept();
        WebElement resultText= driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed());



    }
    @Test
    public void p2_information_alert_practice(){

        //Locating the warning/information alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        //click to the button
        warningAlertButton.click();


        // Create Alert instance and switch to alert
        Alert alert =driver.switchTo().alert();
        alert.accept();
        WebElement resultText= driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed());



    }



}