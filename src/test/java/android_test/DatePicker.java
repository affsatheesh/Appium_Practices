package android_test;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DatePicker extends Base {

	@Test
	public void testcase1() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Picker\"));"));

		driver.findElement(AppiumBy.accessibilityId("Picker")).click();

		// driver.findElement(
		// AppiumBy.androidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"kupima\"));"));

		driver.findElement(AppiumBy.id("android:id/numberpicker_input")).click();
		driver.findElement(AppiumBy.id("android:id/numberpicker_input")).clear();
		// driver.findElement(AppiumBy.id("android:id/numberpicker_input")).sendKeys("kupima");
		driver.findElement(AppiumBy.id("android:id/numberpicker_input")).sendKeys("kupima");
		Thread.sleep(6000);

	}
}
