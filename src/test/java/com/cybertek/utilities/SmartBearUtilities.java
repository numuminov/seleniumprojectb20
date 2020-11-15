package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void loginToSmartBear(WebDriver driver){

        //Mini-Task:
        //#1- Create a new class called : SmartBearUtilities
        //#2- Create a static method called loginToSmartBear
        //#3- This method simply logs in to SmartBear when you call it.
        //#4- Accepts WebDriver type as parameter
        //driver.manage().window().maximize();
        //implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        //driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement userN= driver.findElement(By.id("ctl00_MainContent_username"));
        userN.sendKeys("Tester");


        WebElement passN= driver.findElement(By.id("ctl00_MainContent_password"));
        passN.sendKeys("test");

        WebElement loginB= driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginB.click();

    }

    public static void verifyOrder(WebDriver driver, String name){

        //Created a locator that only returns the names of the costumer from all of the rows
        //Created a list and stored the cells that has costumer name information into it.
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //If there is only one table on the page, you dont have to locate the table. --> //tr/td[2]
        //List<WebElement> namesList = driver.findElements(By.xpath("//tr/td[2]"));

        for (WebElement each : namesList) {

            if (each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail("Name " +name+" does not exist in the list!");

    }

    public static void printNamesAndCities(WebDriver driver){

        //locating all the names from all the rows and storing in a list of web element
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //we need to locate all the cities from all the rows
        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for (int i = 0; i < namesList.size() ; i++) {

            System.out.println("Name"+ (i+1) +": " + namesList.get(i).getText() + ", City"+ (i+1) +": " + citiesList.get(i).getText());

        }

    }
}
