package iOS_Test;

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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configuration() throws MalformedURLException, URISyntaxException, InterruptedException {
	
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofMinutes(1));
		service = builder.build();
		service.start();

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15");
		options.setApp("//Users//satheshkumarmurugan//Library//Developer//Xcode//DerivedData//UIKitCatalog-dofursnizqvkgodlpjvmeemnykby//Build//Products//Debug-iphonesimulator//UIKitCatalog.app");
        options.setPlatformVersion("17.5");
        options.setPlatformName("IOS");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        
		driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(10000);

	}
	
	@AfterClass
	public void tearDown() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		driver.quit();;
		service.stop();
		
	}

}
