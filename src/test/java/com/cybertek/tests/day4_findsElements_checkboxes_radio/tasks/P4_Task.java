package com.cybertek.tests.day4_findsElements_checkboxes_radio.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P4_Task {
    public static void main(String[] args) {
        /*
        1.Open	Chrome	browser
        2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify	“Check	All”	button	text	is	“Check	All”
        4.Click	to	“Check	All”	button
        5.Verify	all	check	boxes	are	checked
        6.Verify	button	text	changed	to	"Uncheck all"
         */
        WebDriver driver= WebDriverFactory.getDriver("firefox");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.findElement(By.cssSelector("input#check1")).click();
        List<WebElement> listButtons = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        for (WebElement each:listButtons
             ) {if(each.isSelected()){
            System.out.println("Button Selected. Passed");
        }else {
            System.out.println("Button not Selected. Fail");
        }

        }

    }
}
