package android_test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends Base{

	  @Test
		public void testcase1()
		{
	    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    	driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	    	WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
	    	
	    	// Java
	    	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) element).getId(),
	    	    "endX", 654,
	    	    "endY", 654
	    	));
	    		
	}

}
