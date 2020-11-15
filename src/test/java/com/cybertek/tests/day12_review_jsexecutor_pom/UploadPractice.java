package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void uploading_file_test(){
        //Getting the page
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        //get the path of the file you want to upload
        //MAC: right click on the file you want to upload
        //  Click and hold "OPTION" button and select "copy as path name"

        //Windows: Right click -> properties -> copy from location
        //OR SHIFT + RIGHT CLICK --> Copy as path
        String path = "C:\\Users\\numum\\Desktop\\HTML Class\\arsenal.png";

        BrowserUtils.wait(2);

        //Locate the upload web element
        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.wait(2);
        //send the path of the file to uploadInput webElement
        uploadInput.sendKeys(path);
        BrowserUtils.wait(2);

        WebElement submit =Driver.getDriver().findElement(By.id("file-submit"));
        BrowserUtils.wait(2);
        submit.click();;
    }
}