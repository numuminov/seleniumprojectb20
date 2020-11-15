package com.cybertek.tests.day11_utils_review_actions.SelfPractice;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P1 {
    /*
    TC	#16:	Double	ClickTest
    1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”	attribute	value	contains "red"
     */

    @Test
    public void test1(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@name='iframeResult']")));
        BrowserUtils.wait(2);
        WebElement text=Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
        BrowserUtils.wait(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(text).doubleClick().perform();
        BrowserUtils.wait(2);
        String actualColor=text.getAttribute("style");
        String expectedColor="red";

        Assert.assertTrue(actualColor.contains(expectedColor));
        Driver.getDriver().close();

    }

    @Test
    public void test2(){
        /*
        TC	#17:	Context	Click	–HOMEWORK
        1.Go	to	https://the-internet.herokuapp.com/context_menu
        2.Right	click	to	the	box.
        3.Alert	will	open.
        4.Accept	alertNo	assertion	needed	for	this	practice
         */
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement box =Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        BrowserUtils.wait(2);

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(box).contextClick().perform();
        BrowserUtils.wait(2);

        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();


    }

    @Test
    public void test3(){
        /*
        1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        2.Drag	and	drop	the	small	circle	to	bigger	circle.
        3.Assert:	-Text	in	big	circle	changed to:	"You	did	great!"
         */
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");


        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //actions.moveToElement(smallCircle).perform();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions.dragAndDrop(smallCircle,bigCircle).perform();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String expRez="You did great!";
        String acrrez=bigCircle.getText();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Assert.assertTrue(expRez.equals(acrrez));

 



    }




}
