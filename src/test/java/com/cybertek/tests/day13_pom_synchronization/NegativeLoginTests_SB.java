package com.cybertek.tests.day13_pom_synchronization;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests_SB {

    LoginPage loginPage;

    @Test( description = "entering incorrect username")
    public void negative_login_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));

        loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("banana"));

        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("smartbear_password"));

        loginPage.loginButton.click();


        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test( description = "using login method for negative test")
    public void negative_login_test2(){

        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));
        loginPage=new LoginPage();

        String username ="wrongusername";
        String password=ConfigurationReader.getProperty("smartbear_password");

        loginPage.login(username,password);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());




    }
}
