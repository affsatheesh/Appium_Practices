package iOS_Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import android_test.Appium;
import io.appium.java_client.AppiumBy;

public class IOSAPP extends Base{

	@Test
	public void testcase1() throws InterruptedException
	{
		
		
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther")).sendKeys("sathesh");
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'OK'`]")).click();
		
		driver.findElement(AppiumBy.iOSNsPredicateString("value == 'Confirm / Cancel'")).click();
		
		String value =driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH[c] 'A message' ")).getText();
		
		System.out.println(value);
	
	}
}
