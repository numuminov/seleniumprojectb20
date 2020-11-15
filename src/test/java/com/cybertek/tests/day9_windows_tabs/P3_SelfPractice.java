package com.cybertek.tests.day9_windows_tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P3_SelfPractice {
    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }
    @Test
    public void test1(){

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("jghgh");
        alert.accept();
    }

    @Test
    public void test2(){
        driver.navigate().to("http://practice.cybertekschool.com/iframe");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("gfthyndrr");



    }

    @Test
    public void test3(){

        driver.navigate().to("http://practice.cybertekschool.com/windows");

    }
}
