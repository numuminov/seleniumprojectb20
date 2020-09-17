package com.cybertek.tests.day5_testNG_intro_dropdowns.Self;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P1  {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }



    @Test
    public void test1(){
        WebElement stateSelect=driver.findElement(By.xpath("//select[@id='state']"));

        Select select=new Select(stateSelect);
        String firstText =select.getFirstSelectedOption().getText();
        System.out.println("firstText = " + firstText);
        String actText="Select a state";
        Assert.assertTrue(actText.equalsIgnoreCase(firstText));
    }
    @Test
    public void test2()  throws Exception{
        WebElement stateSelect=driver.findElement(By.xpath("//select[@id='state']"));

        Select select=new Select(stateSelect);
        WebElement first=select.getFirstSelectedOption();
        first.click();
        Thread.sleep(3000);
        System.out.println("first.getText() = " + first.getText());
        System.out.println(select.getOptions());



    }

}
