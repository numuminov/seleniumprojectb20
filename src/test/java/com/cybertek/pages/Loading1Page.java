package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loading1Page {


    public Loading1Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//button)[1]")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "pwd")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement errorMessage;


    public void login(String username, String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }




}
