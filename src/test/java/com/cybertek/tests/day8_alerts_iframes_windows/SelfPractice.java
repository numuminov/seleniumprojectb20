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

public class SelfPractice {
    /*
    Open browser
    2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    3.Click to “Click for JS Prompt” button
    4.Send “hello”text to alert
    5.Click to OK button from the alert
    6.Verify “You entered:  hello” text is displayed
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
       driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");


    }

    @Test
    public void test1(){
        WebElement promtBut= driver.findElement(By.xpath("//button[3]"));
        promtBut.click();
        BrowserUtils.wait(2);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        BrowserUtils.wait(2);
        alert.accept();
        WebElement confirmation=driver.findElement(By.xpath("//p[@id]"));
        String actualRes=confirmation.getText();
        String expResult="hello";

        Assert.assertTrue(actualRes.contains(expResult),"No hello message");



    }

    /*
    Open browser
    2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    3.Click to “Click for JS Alert”button
    4.Click to OK button from the alert
    5.Verify “You successfulyclicked an alert”text is displayed.
     */
    @Test
    public void test2(){
        WebElement firstBut= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        firstBut.click();
        BrowserUtils.wait(2);
        Alert alert=driver.switchTo().alert();

        alert.dismiss();





    }
    @Test
    public void test3(){
        WebElement firstBut= driver.findElement(By.xpath("//button[2]"));
        firstBut.click();
        BrowserUtils.wait(2);
        Alert alert=driver.switchTo().alert();

        alert.dismiss();

    }
    @Test
    public void test4(){
driver.get("http://practice.cybertekschool.com/iframe");
WebElement frame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
    driver.switchTo().frame(frame);
        System.out.println(driver.findElement(By.xpath("//p")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText());


    }



}
