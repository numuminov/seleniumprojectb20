package com.cybertek.tests.day4_findsElements_checkboxes_radio.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T3_Task {
    public static void main(String[] args) {
        /*
        TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        1.Open	Chrome	browser
        2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
        4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed
         */
        WebDriver driver= WebDriverFactory.getDriver("firefox");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        boolean displayed = driver.findElement(By.xpath("//div[.='Success - Check box is checked']")).isDisplayed();
        if(!displayed){
            System.out.println("Not displayed Passsed");}else{System.out.println("displayed False");}

        driver.findElement(By.cssSelector("input#isAgeSelected")).click();
        boolean displayed2 = driver.findElement(By.xpath("//div[.='Success - Check box is checked']")).isDisplayed();
        if(displayed2){
            System.out.println(" displayed Passed");}else{System.out.println("not displayed False");}

    }
}
