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
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LongPress extends Base{

    @Test
	public void testcase1()
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']")).click();

		String value = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		assertEquals(value, "WiFi settings");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Home");
		
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		


	}
	

}
