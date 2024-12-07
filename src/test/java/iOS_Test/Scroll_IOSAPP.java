package iOS_Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import android_test.Appium;
import io.appium.java_client.AppiumBy;

public class Scroll_IOSAPP extends Base{

	@Test
	public void testcase1() throws InterruptedException
	{
		
		
		
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Steppers"));
		element.click();
		
		WebElement steppersIncrement = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		
		
		Map<String, Object> value = new HashMap<String, Object>();
		value.put("element", ((RemoteWebElement)steppersIncrement).getId());
		value.put("duration", 5);
		driver.executeScript("mobile:touchAndHold", value);
		
		
		WebElement back = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'UIKitCatalog'`]"));
		back.click();
		
		
		
		WebElement scrollToWebView = driver.findElement(AppiumBy.accessibilityId("Web View"));
		
		Map<String, Object> value1 = new HashMap<String, Object>();
		value1.put("direction", "down");
		value1.put("element", ((RemoteWebElement)scrollToWebView).getId());
		value1.put("duration", 5);
		driver.executeScript("mobile:scroll", value1);
		
		
		
		WebElement scrollToPickerView = driver.findElement(AppiumBy.accessibilityId("Picker View"));
		
		Map<String, Object> value2 = new HashMap<String, Object>();
		value2.put("direction", "up");
		value2.put("element", ((RemoteWebElement)scrollToPickerView).getId());
		value2.put("duration", 5);
		driver.executeScript("mobile:scroll", value2);
		
		
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		
		
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("75");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("215");
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("110");
		
		
		
		
//		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther")).sendKeys("sathesh");
//		
//		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'OK'`]")).click();
//		
//		driver.findElement(AppiumBy.iOSNsPredicateString("value == 'Confirm / Cancel'")).click();
//		
//		String value =driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH[c] 'A message' ")).getText();
//		
//		System.out.println(value);
	
	}
}
