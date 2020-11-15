package com.cybertek.Vytruck;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NextBaseSprint1 {

    @Test
    public void test1_attachLink(){
        Driver.getDriver().get("http://login2.nextbasecrm.com");
        WebElement login=Driver.getDriver().findElement(By.name("USER_LOGIN"));
        login.sendKeys("hr19@cybertekschool.com");

        WebElement password=Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser"+ Keys.ENTER);
        BrowserUtils.wait(2);

        WebElement messageButton=Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageButton.click();

        //Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("(//iframe)[1]")));
        BrowserUtils.wait(2);

        WebElement linkButton=Driver.getDriver().findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']"));
        linkButton.click();
        BrowserUtils.wait(1);
        WebElement text=Driver.getDriver().findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        text.sendKeys("Practice with Cybertek");

        BrowserUtils.wait(1);
        WebElement url =Driver.getDriver().findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']"));
        url.sendKeys("http://practice.cybertekschool.com/javascript_alerts");

        BrowserUtils.wait(1);
        WebElement saveButton =Driver.getDriver().findElement(By.xpath("//input[@id='undefined']"));
        saveButton.click();

        BrowserUtils.wait(1);
        WebElement sendButton =Driver.getDriver().findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();


        BrowserUtils.wait(1);
        WebElement message =Driver.getDriver().findElement(By.xpath("//a[.='Practice with Cybertek']"));
        BrowserUtils.wait(3);
        Assert.assertTrue(message.isDisplayed());
        Driver.getDriver().close();

    }

    @Test
    public void test1_attachVideo(){
        Driver.getDriver().get("http://login2.nextbasecrm.com");
        WebElement login=Driver.getDriver().findElement(By.name("USER_LOGIN"));
        login.sendKeys("hr19@cybertekschool.com");

        WebElement password=Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser"+ Keys.ENTER);
        BrowserUtils.wait(2);

        WebElement messageButton=Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageButton.click();

        //Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("(//iframe)[1]")));
        BrowserUtils.wait(2);

        WebElement videoButton=Driver.getDriver().findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']"));
        videoButton.click();
        BrowserUtils.wait(1);

        WebElement videoLink=Driver.getDriver().findElement(By.xpath("//input[@id='video_idPostFormLHE_blogPostForm-source']"));
        videoLink.sendKeys("https://www.youtube.com/watch?v=A3xHJzNNM2A&t=2s");



        BrowserUtils.wait(20);
        WebElement saveButton =Driver.getDriver().findElement(By.xpath("//input[@class='adm-btn-save']"));
        saveButton.click();


        BrowserUtils.wait(1);
        WebElement sendButton =Driver.getDriver().findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();


        BrowserUtils.wait(1);
        WebElement video =Driver.getDriver().findElement(By.xpath("//*[@id=\"blog_post_body_1320\"]/iframe"));
        Assert.assertTrue(video.isDisplayed());


        Driver.getDriver().close();

    }

    @Test
    public void test1_attachQuote(){
        Driver.getDriver().get("http://login2.nextbasecrm.com");
        WebElement login=Driver.getDriver().findElement(By.name("USER_LOGIN"));
        login.sendKeys("hr19@cybertekschool.com");

        WebElement password=Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser"+ Keys.ENTER);
        BrowserUtils.wait(2);

        WebElement messageButton=Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageButton.click();

        //Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("(//iframe)[1]")));
        BrowserUtils.wait(2);


        WebElement quoteButton=Driver.getDriver().findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-quote']"));
        quoteButton.click();
        BrowserUtils.wait(1);
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("(//iframe)[1]")));
        WebElement text=Driver.getDriver().findElement(By.xpath("/html/body/blockquote"));
        text.sendKeys("Practice with Cybertek");
        BrowserUtils.wait(2);
        Driver.getDriver().switchTo().defaultContent();



        BrowserUtils.wait(1);
        WebElement sendButton =Driver.getDriver().findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();


        BrowserUtils.wait(1);
        WebElement message =Driver.getDriver().findElement(By.xpath("//td[.='Practice with Cybertek']"));
        BrowserUtils.wait(2);
        Assert.assertTrue(message.isDisplayed());
        Driver.getDriver().close();



    }
    @Test
    public void test1_recordVideo(){


        Driver.getDriver().get("http://login2.nextbasecrm.com");
        WebElement login=Driver.getDriver().findElement(By.name("USER_LOGIN"));
        login.sendKeys("hr19@cybertekschool.com");

        WebElement password=Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser"+ Keys.ENTER);
        BrowserUtils.wait(2);

        WebElement messageButton=Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageButton.click();

        //Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("(//iframe)[1]")));
        BrowserUtils.wait(2);


        WebElement recordVideo=Driver.getDriver().findElement(By.xpath("//span[.='Record Video']"));
        recordVideo.click();
        BrowserUtils.wait(2);

        WebElement allowButton=Driver.getDriver().findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));
        allowButton.click();
        BrowserUtils.wait(2);



        //Alert alert =Driver.getDriver().switchTo().alert();
        //alert.accept();

        BrowserUtils.wait(1);
        WebElement saveButton =Driver.getDriver().findElement(By.xpath("//span[.='Close']"));
        saveButton.click();





    }
}
