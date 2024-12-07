package nativeAppTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class NativeApp extends Base{

	@Test
	public void testcase1() throws InterruptedException
	{
		
		
		
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		
    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));

    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]")).click();
    	
    	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sathesh");
    	
    	driver.hideKeyboard();
    	
    	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
    	
    	Boolean radio = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).isSelected();
    	
    	System.out.println("====================================>>>>>>"+radio);
    	
    	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    	
    	
    	driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();	
    	
    	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    	
    	driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
    	
    	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
    	
    	Thread.sleep(20000); 
    	
    	String value  =driver.getContext();
    	System.out.println("Current Context ==================================== >>>>>>>>>>>> "+value);
    	
    	Set<String> context = driver.getContextHandles();
    	
    	for (String string : context) {
			System.out.println("Context ==================================== >>>>>>>>>>>> "+string);
		}
    	
    	driver.context(value);
    	
    	driver.context("WEBVIEW_com.androidsample.generalstore");
    	
    	String value1  =driver.getContext();
    	System.out.println("Current Context 111 ==================================== >>>>>>>>>>>> "+value1);
    	
    	driver.findElement(By.name("q")).sendKeys("Thoughtworks");
    	
    	driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
    	
    	
//		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
//
//		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
//		
//		 ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//		            "elementId", ((RemoteWebElement)element).getId(),"duration", 2000
//		    ));

	}
}
