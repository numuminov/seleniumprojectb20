package com.cybertek.tests.day4_findsElements_checkboxes_radio.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P5_Task {
    public static void main(String[] args) {
        /*
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/add_remove_elements
        3. Click to “Add Element” button 50 times
        4. Verify 50 “Delete” button is displayed after clicking.
        5. Click to ALL “Delete” buttons to delete them.
        6. Verify “Delete” button is NOT displayed after clicking.
         USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         Hint: Need to use findElements method
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for(int i=1; i<=50;i++) {
            button.click();}

            List<WebElement> DeleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println(DeleteButtons.size());



            if(DeleteButtons.size()==50){
                System.out.println("Buttons 50. passed!");
            }else{System.out.println("Buttons not 50. failed!");}

        for (WebElement each:DeleteButtons
             ) {each.click();

        }


try{
    for (WebElement each: DeleteButtons
         ) {



        if(!each.isDisplayed()){
            System.out.println("No any delete button. Passed");
        }else {System.out.println("delete button displayed. failed");}}}catch (StaleElementReferenceException e){
    System.out.println("No any delete button. Passssssed");}



    }
}
