package com.cybertek.tests.day5_testNG_intro_dropdowns.Self;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppleRepeat {
    public static void main(String[] args)throws Exception {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        int withText=0;
        int withoutText=0;
        Thread.sleep(1000);

        List<WebElement> listHeaders= driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        for(int i=1; i<=7; i++){
            listHeaders.get(i).click();
            Thread.sleep(1000);


            List<WebElement> listModules=driver.findElements(By.xpath("//body//a"));
            System.out.println("Title: "+driver.getTitle()+listModules.size());

            for (WebElement each:listModules
                 ){
            String link=each.getText();
            String link2="";

            if(link.equals(link2)){withoutText++;}else {withText++;}}

            driver.navigate().back();
            listHeaders=driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));














        }

        System.out.println("with text "+withText);
        System.out.println("without text "+withoutText);

    }
}
