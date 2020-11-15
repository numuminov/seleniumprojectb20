package com.cybertek.tests.day6_dropdown_review_javafaker.Self;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Recap {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);


    }

    @Test
    public void test1()throws Exception{

        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        WebElement SelectProduct= driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct"));
        Select products=new Select(SelectProduct);
        products.selectByValue("FamilyAlbum");
        Thread.sleep(2000);
        Assert.assertTrue(products.getFirstSelectedOption().getText().equals("FamilyAlbum"));
        Faker faker=new Faker();

        Thread.sleep(2000);

        WebElement quant=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quant.sendKeys(Keys.BACK_SPACE);
    quant.sendKeys(faker.number().digits(2));

        Thread.sleep(2000);



        WebElement cal=driver.findElement(By.xpath("//input[@value='Calculate']"));

        cal.click();

        Thread.sleep(2000);

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        WebElement streetInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        WebElement cityInput = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
        WebElement stateInput = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
        WebElement zipInput = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));


        nameInput.sendKeys(faker.name().fullName());

        Thread.sleep(2000);
        streetInput.sendKeys(faker.address().streetAddress());

        Thread.sleep(2000);
        cityInput.sendKeys(faker.address().city());

        Thread.sleep(2000);
        stateInput.sendKeys(faker.address().state());

        Thread.sleep(2000);
        zipInput.sendKeys(faker.address().zipCode().replaceAll("-",""));


        WebElement visa=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visa.click();
        Thread.sleep(2000);

        WebElement card=driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        WebElement exp= driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));

        card.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        exp.sendKeys("12/22");

        Thread.sleep(2000);

        WebElement done = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        done.click();

        Thread.sleep(2000);

        WebElement sucMess= driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(sucMess.isDisplayed());







    }
}
