package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
IFRAME
    - Iframe stands for Inline Frame.
    - Basically <html> code inside of another <html> code.
    - Iframes are created using <iframe></iframe> tag
    - If there is an iframe in the page, and we are trying to locate a webelement that is inside of an iframe, YOU MUST SWITCH YOUR DRIVER'S FOCUS TO THAT IFRAME.
    - Otherwise you will get NoSuchElementException
<html>
    <head>
    </head>
    <body>
        <iframe id="value-id" name="value-name">
            <html>
            </html>
        </iframe>
    </body>
</html>
How to handle iframes / How do we switch to iframes?
    - There are 3 ways of switching to an iframe.
    - ALL OF THEM REQUIRES US TO USE THE SAME METHOD.
        driver.switchTo().frame();
    - This .frame() method can be overloaded with 3 different args.
        - int -> as index number of the iframe
        - String -> as id or name attribute value
        - WebElement -> as you locate the <iframe> then switch to it.
    1- Locate it as a web element and switch to it
        - Literally locate  <iframe> tag as any other web element using one of the 8 locators of Selenium.
        syntax:
            WebElement iframe = driver.findElement(By.LOCATOR);
            driver.switchTo().frame(iframe);
    2- Switch by index
        - Indexes start from 0.
        - We can pass the index number of the iframe we want to switch to.
        syntax:
            driver.switchTo().frame(0); --> switches to the first iframe
            driver.switchTo().frame(1); --> switches to the second iframe
            driver.switchTo().frame(2); --> switches to the third iframe
    3- Switch by id or name attribute value
        - If you have id or name attribute inside of <iframe> tag, you can PASS those values as a String into .frame() method.
        - driver will switch focus to the matching value
        syntax:
            driver.switchTo().frame("idValue");
            driver.switchTo().frame("nameValue");
- After switching to an iframe, if we want to continue back in the main <html> we have to switch back.
- If we do not switch, the selenium browser driver will keep looking inside of inner <html> code, and will not be able to locate any web element outside of it.
- There are 2 ways of switching back from the iframe.

    1- driver.switchTo().defaultContent();
        - Default content means, the main <html> code on the page.
        - No matter how many iframes inside of iframes, if we use this method, it will switch to the DEFAULT CONTENT.
        syntax: driver.switchTo().defaultContent();
    2- driver.switchTo().parentFrame();
        - This is similar to using /.. from xpath.
        - It just goes back to the direct parent of the currently focused iframe.
        html            --> 1
            html        --> 2
                html    --> 3
                html
            html
        html
Practice:   When my driver is focused on iframe 3,
--> If I say driver.switchTo().defaultContent();
    Now where is it focused at:
     -> The focus will turn back to default content, which is: #1
--> If I say driver.switchTo().parentFrame();
    Now where is it focused at:
    -> The focus will turn back to default content, which is: #2

 */

public class IframePractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");

    }

    /*
     1. Create a new class called: IframePractice
     2. Create new test and make set ups
     3. Go to: http://practice.cybertekschool.com/iframe
     4. Assert: “Your content goes here.” Text is displayed.
     5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
      */
    @Test
    public void p4_iframe_practice(){

        //3 ways of locating and switching an IFRAME.
        //1- ByIndex
        //driver.switchTo().frame(0);

        //2- By Id or Name: passing id attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //3- Locate as a web element, then switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        //Locating paragraph tag as a web element
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //Assert that the text is displayed on the page
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "Text is not displayed. Verification FAILED!!!");

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();

        WebElement headerText= driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed(), "Header text is not displayed. Verification FAILED!!!");


    }

}