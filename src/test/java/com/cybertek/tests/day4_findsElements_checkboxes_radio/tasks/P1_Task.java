package com.cybertek.tests.day4_findsElements_checkboxes_radio.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P1_Task {
    public static void main(String[] args) {
        /*
        TC #02: FINDELEMENTS_APPLE
        1.Open Chrome browser
        2.Go to https://www.apple.com
        3.Click to iPhone
        4.Print out the texts of all links
        5.Print out how many link is missing text
        6.Print out how many link has text
        7.Print out how many total link
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
        List<WebElement> LinkList = driver.findElements(By.xpath("//body//a"));
        int withText=0;
        int withoutText=0;
        String text="";
        for (WebElement eachLink:LinkList
             ) {
            System.out.println("Link = " + eachLink.getText());
            if(eachLink.getText().equals(text)){withoutText++;}else {withText++;}


        }System.out.println("Total of links: "+LinkList.size());
        System.out.println("Total Links with text: "+withText);
        System.out.println("Total Links without text: "+withoutText);
    }
}
