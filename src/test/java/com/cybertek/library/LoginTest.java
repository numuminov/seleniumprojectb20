package com.cybertek.library;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Library_POM{

    Library_POM search;

    @Test
    public void SearchForBookTest() {
        search = new Library_POM();
        search.searchBox.sendKeys("The Hobbit");
        String actualResult = search.ISBNtext.getText();
        String expectedResult = "TLKN-1937";
        Assert.assertEquals(actualResult, expectedResult);
    }



}
