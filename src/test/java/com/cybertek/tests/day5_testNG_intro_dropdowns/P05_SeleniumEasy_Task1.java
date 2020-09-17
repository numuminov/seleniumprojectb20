package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Task1 {
    public static void main(String[] args) {
        /*
        TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        1.Open	Chrome	browser
        2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
        4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement successch=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        WebElement text= driver.findElement(By.xpath("//div[.='Success - Check box is checked']"));
        //System.out.println("text = " + text);
        if(!successch.isSelected()&&!text.isDisplayed()){
            System.out.println("not displayed passed!");
        }else {
            System.out.println("displayed fail!!");}

        successch.click();
        if(successch.isSelected()&&text.isDisplayed()){
            System.out.println(" displayed passed!");
        }else {
            System.out.println("not displayed fail!!");}

        driver.close();


    }
}
