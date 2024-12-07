package android_test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe extends Base{

	
	
    @Test
	public void testcase1()
	{
    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
    	driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
    	
    	driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

    	String value = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
    	
    	System.out.println("==========================================>   "+value);
    	
    	WebElement element = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
    	
    	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
    			 "elementId", ((RemoteWebElement)element).getId(),
    	    "direction", "left",
    	    "percent", 0.75
    	));

    	
		
	}
}
