package pingala.qa.ledgerchat.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	//Create object for Android driver
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@Test
	public void configureAppium() throws MalformedURLException {
		
		
		
		//Appium Service
//		service =new AppiumServiceBuilder().withAppiumJS(new File ("C:\\Users\\SIDDHARTH\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(40)).build();
//		
//		service.start();
		
		
		
		// Create Capablities
		UiAutomator2Options options = new UiAutomator2Options();
		//options.setDeviceName("Pixel 7 API 30");
		options.setDeviceName("LedgerChatDev");
		options.setPlatformName("android");
		options.setCapability("platformVersion", "11.0");
		//options.setApp(System.getProperty("user.dir")+ "\\Learnings\\JavaPractice\\Workspace\\LedgerChatAppium\\src\\test\\java\\resources\\automation-test.apk");
		options.setApp(System.getProperty("user.dir")+ "\\src\\test\\java\\resources\\app-debugDev21.apk");
		//options.setApp("C:\\Users\\SIDDHARTH\\Downloads\\automation-test.apk");
		
		
		
		
		//Android driver Obj
		driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys("senthil_ledgerfi1");
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys("Admin@1");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Start Secure Chat\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		List<WebElement> usrname = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='listItemTitle']"));
		for (WebElement e :usrname)
		{
			String attrVal = e.getText();	
			if (attrVal.contains("Renji"))
			{
				e.click();
			
				break;
			}
			
		}
		
		
		//
		
		//System.out.println(attrVal);
			
		
		
		
		driver.quit();
		//service.stop();
		
		 
	}

	
}
