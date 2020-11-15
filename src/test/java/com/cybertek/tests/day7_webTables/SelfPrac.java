package com.cybertek.tests.day7_webTables;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelfPrac {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);

    }
    /*
    Create a method named verifyOrderin SmartBearUtils class.
    •Methodtakes WebDriver object and String(name).
    •Method should verify if given name exists in orders.
    •This method should simply accepts a name(String),
    and assert whether given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.
     */


    /*
    Create a method named printNamesAndCities in SmartBearUtils class.
    •Method takes WebDriver object.
    •This method should simply print all the names in the List of All Orders.
    •Create a new TestNG test to test if the method is working as expected.
    •Output should be like:
    •Name1: name , City1: city
    •Name2: name , City2: city
     */

        @Test
        public void test1(){
            //WebElement table=driver.findElement(By.xpath("//table[@class='SampleTable']"));
            verifyOrder(driver,"Paul Brown");


        }

        @Test
        public void test2(){

            printNamesAndCities(driver);
        }

        public  void verifyOrder(WebDriver driver, String name){

            String expectedname=name;
            List<WebElement> listNames=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody//td[2]"));

            ArrayList<String> names=new ArrayList<String>();
            for (WebElement each:listNames
                 ) {names.add(each.getText());

            }


            Assert.assertTrue(names.contains(expectedname),"no matches name");


        }

    public  void printNamesAndCities(WebDriver driver){

        List<WebElement> listNames=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody//td[2]"));
        List<WebElement> listCities=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody//td[7]"));


        for (int i=0; i<=7;i++){

            System.out.println("name "+(i+1)+": "+listNames.get(i).getText()+", City"+(i+1)+": "+listCities.get(i).getText());
        }


    }




//iter




    }

