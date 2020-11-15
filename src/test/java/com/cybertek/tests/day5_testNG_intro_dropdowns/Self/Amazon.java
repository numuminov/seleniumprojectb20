package com.cybertek.tests.day5_testNG_intro_dropdowns.Self;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Amazon {
    public static void main(String[] args)throws Exception {
    /*

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        int text=0;
        int notext=0;

        Thread.sleep(1000);

        List<WebElement> headers= driver.findElements(By.xpath("//*[@id=\"nav-xshop\"]//a"));

        for(int i =1; i<=2;i++){
            headers.get(i).click();
            Thread.sleep(1000);


            List<WebElement>urls=driver.findElements(By.xpath("//body//a"));
            Thread.sleep(2000);
            System.out.println("Title: "+driver.getTitle()+urls.size());


Thread.sleep(1000);

String textlink="";

            for (WebElement each:urls
                 ) {if(each.getText().equals(textlink)){
                     notext++;
            }else {text++;}

            }
            driver.navigate().back();
            headers= driver.findElements(By.xpath("//*[@id=\"nav-xshop\"]//a"));

            Thread.sleep(1000);



        }
        System.out.println("text = " + text);
        System.out.println("notext = " + notext);

     */
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://amazon.com");

        int witht=0;
        int without=0;

        List<WebElement> moduls=driver.findElements(By.xpath("//*[@id=\"nav-xshop\"]//a"));
        for (int i = 0; i < 3; i++) {
            moduls.get(i).click();
            List<WebElement> listurls= driver.findElements(By.xpath("//body//a"));
            System.out.println("title: "+driver.getTitle()+listurls.size());

            for (WebElement each:listurls
                 ) {

                String textl="";
                if(each.getText().equals(textl)){without++;}else {witht++;}

            }

            driver.navigate().back();
            moduls=driver.findElements(By.xpath("//*[@id=\"nav-xshop\"]//a"));



        }
        System.out.println("witht = " + witht);
        System.out.println("without = " + without);


    }
}
