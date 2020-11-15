package com.cybertek.tests.day7_webTables;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfPrac2 {

    /*
    TC#6: Cybertek registration form confirmationNote:
    Use JavaFaker when possible.
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/registration_form
    3.Enter first name
    4.Enter last name
    5.Enter username
    6.Enter email address
    7.Enter password
    8.Enter phone number
    9.Select a gender from radio buttons
    10.Enter date of birth
    11.Select Department/Office
    12.Select Job Title
    13.Select programming language from checkboxes
    14.Click to sign up button
    15.Verify success message
    “You’ve successfully completed registration.” is displayed
     */

    WebDriver driver;
    @BeforeMethod
    public void signup(){
        driver= WebDriverFactory.getDriver("chrome");

    }


    @Test
    public void test1(){


        driver.get("http://practice.cybertekschool.com/registration_form");
        Faker faker =new Faker();

        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());

        BrowserUtils.wait(10);

        WebElement lastName= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName= driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        userName.sendKeys(faker.name().fullName().replace(" ","").replace(".",""));

        WebElement eMail= driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        eMail.sendKeys(faker.internet().emailAddress());

        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys(faker.name().fullName().replace(" ",""));

        WebElement telNum= driver.findElement(By.xpath("//input[@type='tel']"));
        telNum.sendKeys("412-304-1167");

        WebElement selectMale= driver.findElement(By.xpath("//input[@value='male']"));
        selectMale.click();

        WebElement dob= driver.findElement(By.name("birthday"));
        dob.sendKeys("12/12/2000");

        WebElement departament= driver.findElement(By.xpath("//select[@name='department']"));

        Select select1=new Select(departament);
        select1.selectByVisibleText("Accounting Office");

        Select select2=new Select(driver.findElement(By.name("job_title")));
        select2.selectByIndex(3);

        WebElement selectLang = driver.findElement(By.xpath("//input[@value='java']"));
        selectLang.click();

        WebElement signUpButton= driver.findElement(By.cssSelector("button[type='submit']"));
        signUpButton.click();

        WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success']/p/../p"));
        Assert.assertTrue(success.isDisplayed());
    }

    @Test
    public void test2(){
        /*
        1.Open browser
        2.Go to website: http://practice.cybertekschool.com/dropdowns
        3.Verify default value is always showing the current month
        o Expected: If currently in June, should show June selected

         */

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select select=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actResult =select.getFirstSelectedOption().getText();
        System.out.println("actResult = " + actResult);

        LocalDate currentdate = LocalDate.now();
        System.out.println("Current date: "+currentdate);

        Month currentMonth = currentdate.getMonth();
        System.out.println("Current month: "+currentMonth);

        Assert.assertTrue(actResult.equalsIgnoreCase("September"));





    }
    @Test
    public void checkMonth(){

        /*

        TC#8: Cybertek “month”dropdown list of default values verification
        1.Do both verifications in the same test
        2.Verify list of months are correct as expected.
        oExpected: Options should contain all 12 months of the year
         */
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select select=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        List<WebElement>months = select.getOptions();
        ArrayList<String> extectedResult=new ArrayList<String>();
        extectedResult.addAll(Arrays.asList("January","February","March","April","May","June",
                "July","August","September","October","November","December"));

        for (int i=0; i<=11;i++){

           Assert.assertTrue(months.get(i).getText().equalsIgnoreCase(extectedResult.get(i)));

        }






    }



}
