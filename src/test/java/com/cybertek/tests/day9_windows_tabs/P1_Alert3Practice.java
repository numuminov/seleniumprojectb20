package com.cybertek.tests.day9_windows_tabs;

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

public class P1_Alert3Practice {
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
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    @Test
    public void p3_prompt_alert_practice(){
        WebElement promptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptButton.click();

        //Using alert class to handle it
        Alert alert =driver.switchTo().alert();
        BrowserUtils.wait(2);

        String input="\"something\"";

        alert.sendKeys(input);
        BrowserUtils.wait(2);
        alert.accept();

        WebElement resultText= driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed());
        //verify text input is displayed
        Assert.assertTrue(resultText.getText().contains(input));
    }

}
