package com.cybertek.tests.day4_findsElements_checkboxes_radio.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P2_Task {
    public static void main(String[] args) throws Exception {
        /*
        Open Chrome browser
        2.Go to https://www.apple.com
        3.Click to all of the headers one by one
        a.Mac, iPad, iPhone, Watch, TV, Music, Support
        4.Printout how many links on each page with the titles of the pages
        5.Loop through all
        6.Print out how many link is missing textTOTAL
        7.Print out how many link has textTOTAL
        8.Print out how many total linkTOTAL
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");

        ArrayList <String> AllLinks =new ArrayList<String>();
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
        List<WebElement> LinkList = driver.findElements(By.xpath("//body//a"));
        for (WebElement each:LinkList
             ) {AllLinks.add(each.getText());

        }
        String titleIphone= driver.getTitle();
        System.out.println("Title: "+titleIphone+", Total of links: "+LinkList.size());
        driver.navigate().back();
        //Thread.sleep(3000);

        driver.findElement(By.xpath("//a[.='Mac']")).click();
        List<WebElement> LinkListMac = driver.findElements(By.xpath("//body//a"));
        for (WebElement each:LinkListMac
        ) {AllLinks.add(each.getText());

        }
        String titleMac= driver.getTitle();
        System.out.println("Title: "+titleMac+", Total of links: "+LinkListMac.size());

        driver.findElement(By.xpath("//a[.='iPad']")).click();
        List<WebElement> LinkListPad = driver.findElements(By.xpath("//body//a"));

        for (WebElement each:LinkListPad
        ) {AllLinks.add(each.getText());

        }
        String titlePad= driver.getTitle();
        System.out.println("Title: "+titlePad+", Total of links: "+LinkListPad.size());

        driver.findElement(By.xpath("//a[@data-analytics-title='watch']")).click();

        List<WebElement> LinkListWatch = driver.findElements(By.xpath("//body//a"));

        for (WebElement each:LinkListWatch
        ) {AllLinks.add(each.getText());

        }
        String titleWatch= driver.getTitle();
        System.out.println("Title: "+titleWatch+", Total of links: "+LinkListWatch.size());

        int withText=0;
        int withoutText=0;
        String text="";

        for (String each:AllLinks
        ) {

            if(each.equals(text)){withoutText++;}else {withText++;}


        }System.out.println("Total of links: "+AllLinks.size());
        System.out.println("Total Links with text: "+withText);
        System.out.println("Total Links without text: "+withoutText);



    }
}
