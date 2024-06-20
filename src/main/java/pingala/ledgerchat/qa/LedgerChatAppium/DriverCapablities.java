package pingala.ledgerchat.qa.LedgerChatAppium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverCapablities<WebElement> {
	
	//public AndroidDriver driver;
	public AppiumDriver driver;
	public AppiumDriverLocalService service;
	private ElementsUtil_LC elemUtil;
	public Properties prop;
	
	//***************************** ANDROID STUDIO *******************************************
	public AppiumDriver init_ServiceCapablities(Properties prop) throws MalformedURLException  {
		
		String deviceName = prop.getProperty("DeviceName").trim();
		String platformName = prop.getProperty("PlatformName").trim();
		String versionName = prop.getProperty("VersionName").trim();
		String versionNumber = prop.getProperty("VersionNumber").trim();
		String appPath = prop.getProperty("AppPath");
		String driverurlPath = prop.getProperty("AndroidDriverURL");
		
	//*******************************REAL DEVICE*******************************************	
//		
//		public AppiumDriver init_ServiceCapablities(Properties prop) throws MalformedURLException  {
//			
//			String deviceName = prop.getProperty("RealDeviceName").trim();
//			String platformName = prop.getProperty("PlatformName").trim();
//			String versionName = prop.getProperty("VersionName").trim();
//			String versionNumber = prop.getProperty("RDVErsionNumber").trim();
//			String appPath = prop.getProperty("AppPath");
//			String driverurlPath = prop.getProperty("AndroidDriverURL");
//		
//		
		//Appium Service
//		service =new AppiumServiceBuilder().withAppiumJS(new File ("C:\\Users\\SIDDHARTH\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(40)).build();
//		
//		service.start();
		
		
		
		// Create Capablities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setPlatformName(platformName);
		options.setCapability(versionName, versionNumber);
		options.setApp(System.getProperty("user.dir")+ appPath);
		
		
		
		//Android driver Obj
		driver = new AppiumDriver(new URL (driverurlPath),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	/**
	 * this method is used to initialize the config properties
	 * retun Prop class ref
	 */
	
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * take screenshot
	 */
//	public static String getScreenshot() {
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
//		File destination = new File(path);
//		try {
//			FileUtils.copyFile(srcFile, destination);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return path;
//	}
//	

	
}

