package android_test;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Calendar extends Base {

	@Test
	public void testcase1() throws InterruptedException {

		int year = 1996;
		int MonthDetails = 4;
		int day = 12;

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Date Widgets")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Dialog")).click();
		// driver.findElement(AppiumBy.id("io.appium.android.apis:id/pickDate")).click();

		Thread.sleep(3000);
		// calendarHandle(year, MonthDetails, day);

		// Time picker

//		driver.findElement(AppiumBy.accessibilityId("change the time")).click();
//		driver.findElement(AppiumBy.accessibilityId("3")).click();
//		Thread.sleep(3000);
//		driver.findElement(AppiumBy.accessibilityId("10")).click();
//		Thread.sleep(3000);
//		driver.findElement(AppiumBy.id("android:id/pm_label")).click();

		// Change time in the spinner

		driver.findElement(AppiumBy.accessibilityId("change the time (spinner)")).click();

		WebElement element = driver.findElement(
				AppiumBy.xpath("(//android.widget.EditText[@resource-id='android:id/numberpicker_input'])[1]"));
		element.clear();
		element.sendKeys("5");

		Thread.sleep(3000);

		WebElement element1 = driver.findElement(
				AppiumBy.xpath("(//android.widget.EditText[@resource-id='android:id/numberpicker_input'])[2]"));
		element1.clear();
		element1.sendKeys("22");

		driver.findElement(AppiumBy.id("android:id/button1")).click();

		Thread.sleep(8000);

	}

	public static void calendarHandle(int year, int MonthDetails, int day) throws InterruptedException {
		driver.findElement(AppiumBy.id("android:id/date_picker_header_year")).click();
		scrollIntoView(year);
		Thread.sleep(5000);
		WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1996\")"));
		element.click();
		String monthName = driver.findElement(AppiumBy.xpath("//android.view.View[starts-with(@content-desc,\"01\")]"))
				.getAttribute("content-desc");

		String Details = fetchMonthDetails(monthName.replaceAll("\\d", "").trim());
		int calendarMonthDetails = Integer.parseInt(Details);

		if (MonthDetails <= calendarMonthDetails) {
			int next = calendarMonthDetails - MonthDetails;
			for (int i = 1; i <= next; i++) {
				driver.findElement(AppiumBy.accessibilityId("Previous month")).click();
			}
		} else {

			int next = MonthDetails - calendarMonthDetails;
			for (int i = 1; i <= next; i++) {
				driver.findElement(AppiumBy.accessibilityId("Next month")).click();
			}
		}

		String currentSelectedMonth = driver
				.findElement(AppiumBy.xpath("//android.view.View[starts-with(@content-desc,\"01\")]"))
				.getAttribute("content-desc").replaceAll("\\d", "").trim();

		if (currentSelectedMonth.equalsIgnoreCase(fetchMonthDetails(String.valueOf(MonthDetails)))) {
			driver.findElement(AppiumBy.xpath("//android.view.View[starts-with(@content-desc,\"" + day + "\")]"))
					.click();
			driver.findElement(AppiumBy.id("android:id/button1")).click();
		}
	}

	public static void scrollIntoView(int year) {

		Year currentYear = Year.now();
		System.out.println("Current Year: " + currentYear.getValue());
		int currentYearIs = currentYear.getValue();
		if (currentYearIs > year) {
			System.out.println("its greater");
			for (int i = currentYearIs; i >= year; i--) {
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
								+ i + "\"))"));
				System.out.println(i);
			}
		} else {
			for (int i = currentYearIs; i <= year; i++) {
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
								+ i + "\"))"));
			}
			System.out.println("its lesser");

		}

	}

	public static String fetchMonthDetails(String keyOrValue) {
		Map<Integer, String> monthMap = new HashMap<>();

		monthMap.put(1, "January");
		monthMap.put(2, "February");
		monthMap.put(3, "March");
		monthMap.put(4, "April");
		monthMap.put(5, "May");
		monthMap.put(6, "June");
		monthMap.put(7, "July");
		monthMap.put(8, "August");
		monthMap.put(9, "September");
		monthMap.put(10, "October");
		monthMap.put(11, "November");
		monthMap.put(12, "December");

		try {
			int key = Integer.parseInt(keyOrValue);
			return monthMap.get(key);
		} catch (NumberFormatException e) {
			for (Map.Entry<Integer, String> entry : monthMap.entrySet()) {
				if (entry.getValue().equalsIgnoreCase(keyOrValue)) {
					// Return the corresponding month number as a string
					return String.valueOf(entry.getKey());
				}
			}
		}

		return "No matching month found!";
	}

}
