package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsPractices {
     /*
    TC	#16:	Double	ClickTest
    1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”	attribute	value	contains "red"
     */
    @Test
    public void p2_double_click_test(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement textToDoubleClick=Driver.getDriver().findElement(By.id("demo"));

        Actions actions=new Actions(Driver.getDriver());

        actions.doubleClick(textToDoubleClick).perform();
        
        String expected="red";
        String actual=textToDoubleClick.getAttribute("style");
        System.out.println("actual = " + actual);

        Assert.assertTrue(actual.contains(expected));




    }

    /*
        1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        2.Drag	and	drop	the	small	circle	to	bigger	circle.
        3.Assert:	-Text	in	big	circle	changed to:	"You	did	great!"
         */

    @Test
    public void p2_drag_end_drop_test(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Driver.getDriver().manage().window().fullscreen();


        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions.dragAndDrop(smallCircle,bigCircle).perform();

        String expected="You did great!";
        String actual=bigCircle.getText();

        System.out.println("actual = " + actual);

        Assert.assertTrue(expected.equalsIgnoreCase(actual));






    }

    @Test
    public void p2_context_click_test(){
        /*
        TC	#17:	Context	Click	–HOMEWORK
        1.Go	to	https://the-internet.herokuapp.com/context_menu
        2.Right	click	to	the	box.
        3.Alert	will	open.
        4.Accept	alertNo	assertion	needed	for	this	practice
         */
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement box =Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        Driver.getDriver().manage().window().fullscreen();

        BrowserUtils.wait(2);

        Actions actions=new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();


    }







}
