package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    //TC #2: Selecting state from State dropdown and verifying result
    @Test
    public void test2_verify_state_dropdown() throws InterruptedException{
        // we need to locate the dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois --> selecting by visible text
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia --> selecting by value
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California --> select by index
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)

        String expResult="California";
        String actualRes=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualRes,expResult);
    }

    @Test
    public void test3_date_dropdown_verification(){
        //TC #3: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        //st
        Select yearDropdown=new Select(driver.findElement(By.id("year")));
        yearDropdown.selectByValue("1921");
        Select monthDropdown=new Select(driver.findElement(By.cssSelector("select#month")));
        monthDropdown.selectByIndex(11);

        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByValue("1");
        //3. Select “December 1 , 1921” and verify it is selected.
        String expYear="1921";
        String expMonth="December";
        String expDay="1";
        //   Select year using Select month using Select day using
        //: visible text
        //: value attribute : index number
        String actYear=yearDropdown.getFirstSelectedOption().getText();
        String actMonth=monthDropdown.getFirstSelectedOption().getText();
        String actDay=dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expYear,actYear,"year is not equal");
        Assert.assertEquals(expMonth,actMonth,"year is not equal");
        Assert.assertEquals(expDay,actDay,"year is not equal");

    }

    @Test
    public void test4_multiple_value_select_dropdown(){

        /*
        TC #4: Selecting value from multiple select dropdown
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/dropdown
        3.Select all the options from multiple select dropdown.
        4.Print out all selected values.
        5.Deselect all values.
         */
        Select progLang=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement>lang= progLang.getOptions();
        for (WebElement each:lang
             ) {each.click();// it will click each opt-ns

            System.out.println("Selected "+each.getText());
            Assert.assertTrue(each.isSelected(),"The option"+each.getText()+"is not selected");


        }
        progLang.deselectAll();
        for (WebElement each: lang
             ) {Assert.assertTrue(!each.isSelected(),"Selected!");

        }

    }


    @Test
    public void test5_html_dropdown_handling(){
        //TC #5: Selecting value from non-select dropdown


        //Locate the HTML dropdown as a regular web element
        WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));

        //3. Click to non-select dropdown
        websiteDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        facebookLink.click();

        //5. Verify title is “Facebook - Log In or Sign Up”

        String actTit=driver.getTitle();
        String expTit="Facebook - Log In or Sign Up";

        Assert.assertEquals(actTit,expTit);




    }




}