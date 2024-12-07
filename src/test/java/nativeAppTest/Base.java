package nativeAppTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configuration() throws MalformedURLException, URISyntaxException, InterruptedException {
		Map<String, String> env = new HashMap<>();
		env.put("ANDROID_HOME", "/users/satheshkumarmurugan/Library/Android/sdk");
//		AppiumServiceBuilder builder = new AppiumServiceBuilder()
//				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).withTimeout(Duration.ofMinutes(1));
//		service = builder.build();
//		service.start();

		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("Small Phone");
		options.setChromedriverExecutable("//Users//satheshkumarmurugan//Downloads//chromedriver-mac-arm64");
		options.setApp(
				"//Users//satheshkumarmurugan//eclipse-workspace//AppiumPractices//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(10000);

	}
	
	@AfterClass
	public void tearDown() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		driver.quit();
		service.stop();
		
	}

}
