package android_test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium extends Base{

    @Test
	public void testcase1()
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		
		 ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		            "elementId", ((RemoteWebElement)element).getId(),"duration", 2000
		    ));
		
	
		
		


	}
	

}
