package com.cybertek.tests.day11_utils_review_actions;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {
    /*
    TC #15: Hover Test
    1. Go to http://practice.cybertekschool.com/hovers
    2. Hover over to first image
    3. Assert:
        a. “name: user1” is displayed
    4. Hover over to second image
    5. Assert:
        a. “name: user2” is displayed
    6. Hover over to third image
    7. Confirm:
        a. “name: user3” is displayed
     */
    @Test
    public void hover_over_test(){
        //driver
        //1. Go to http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));


        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions =new Actions(Driver.getDriver());

        BrowserUtils.wait(2);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed(),"user 1 is not displayed");


        BrowserUtils.wait(2);
        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        BrowserUtils.wait(2);
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());




    }

}
/**
Oct 6th, Tuesday
Today's schedule
    - Review on Properties
    - Review on Driver Utils
    - Singleton Design Pattern example
        - Debugging on singleton example
        - Debuggin on driver
    - Action class
==========================================================================
Properties utilities:
    - What is properties utility, and why are we using it?
        - Properties utility is the class and the method we created so that we can read IMPORTANT TEST DATA from outside of our source code.
        - This utility and logic allows us to AVOID HARDCODING the important test data.
        - So that we can change the test data such as browser type, username, password, URL.
    HARDCODING : is putting the data in our source code.
        - If you have to go into the actual code itself to change the data, it means it is hard coded.
    DATA DRIVEN TESTING:
        - Running the same tests against different test data.
    configuration.properties
    -> it is just another type of file.
    -> configuration ==> the name of the file
    -> .properties ==> is the type of the file.
    => .properties type of file stores information in key=value format
    .properties files are mainly used in Java programs to maintain project configuration data, database config or project
 settings, etc. Each parameter in properties file is stored as a pair of strings, in key-value pair format,
 where each key is on one line. You can easily read properties from some file using an object of type Properties.
 This is a utility provided by Java itself.
    EX: key=value
        browser=chrome
        username=john
        password=12345
        url=qa1.vytrack.com
        ConfigurationReader.getProperty("browser"); --> return chrome
        ConfigurationReader.getProperty("username"); --> return john
        ConfigurationReader.getProperty("url"); --> return qa1.vytrack.com
P.I.Q:  How are we reading from properties file?
    #1-> I create the Properties class object.
    #2-> I create a FileInputStream object to be able to open the file, and pass the path of "configuraion.properties" file into the constructor
    #3-> I load the opened file into the properties object
    #4-> Read from the file using .getProperty method that comes from Properties class object.
    #1- Properties properties = new Properties();
    #2- FileInputStream file = new FileInputStream("configuration.properties");
    #3- properties.load(file);
    #4- properties.getProperty(keyWord);
========================================================================
Driver Utility Class:
    - What is Driver utility class and why are we creating it?
    We have some challenges that we want to overcome:
        #1-> Too many lines just to create and instantiate a WebDriver instance and do setup.
        #2-> Our driver instance is not re-usable.
            - Currently our driver instance lives and dies in the same class.
            - If we want to pass the driver instance in a method from another class, we must pass that specific instance into that method every time.
            Ex: SmartBearUtils.login(driver);
    To be able to overcome these challenges, and make our code more stable and easy to maintain, we create Driver utility class.
    We used Singleton Design Pattern to create the logic in our Driver utility.
    -> What is Singleton Design Pattern and how do we achieve it?
        #1- We make the constructor private to limit access to it so that nobody can create object of this class without our permission. (ENCAPSULATION)
        #2- Therefore we create a GETTER method which allows user to get the version of the object we allow them to get.

 */