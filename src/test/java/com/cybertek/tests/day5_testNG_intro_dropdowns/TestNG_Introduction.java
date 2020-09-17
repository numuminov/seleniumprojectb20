package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Introduction {
    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class is running. . .");

    }
    @AfterClass

    public void tearDownClass(){
        System.out.println("After class is running. . .");

    }


    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running. . .");

    }
    @AfterMethod
    public void teatDownMethod(){
        System.out.println("After method is running. . .");

    }






    @Test
    public void test1(){
        System.out.println("test1 is running. . . ");
    }
    @Test
    public void test2(){
        System.out.println("test2 is running. . . ");
    }

    @Test
    public void test3(){
        String str1="TestNG";
        String str2="TestNG";
        String str3="TestNGhdgd";
        Assert.assertTrue(str1.equals(str2));
        Assert.assertTrue(str1.equals(str3),"str1 not equal to str2");

        Assert.assertEquals(str1,str2,"str1 not equal str2");
    }


}
