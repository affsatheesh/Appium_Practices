package android_test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollIntoView extends Base{

	
    @Test
	public void testcase1()
	{
    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
	}
}
