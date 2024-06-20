package pingala.qa.ledgerchat.screens;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import pingala.qa.ledgermail.factory.ElementsUtil;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class LoginScreen {
	
		private AppiumDriver driver;
		//private AndroidDriver driver;
		private ElementsUtil_LC elemUtil;
		
		
		//1. Private By locators
		
		private By allowAccess 	= By.id("com.android.permissioncontroller:id/permission_allow_button");
		private By userName 	= By.xpath("(//android.widget.EditText)[1]");
		private By passWord 	= By.xpath("(//android.widget.EditText)[2]");
		private By submitButton = By.xpath("//android.widget.TextView[@text=\"Start Secure Chat\"]");
		private By okButton		= By.id("android:id/button1");
		private By signInText	= By.xpath("//android.widget.TextView[@text=\"Sign in\"]");
		private By allowPerm	= By.id("com.android.permissioncontroller:id/permission_allow_button");
		private By inusrAlert	= By.id("com.ledgerchatenterprise:id/snackbar_text");
		private By burgerIcon 	= By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
		private By dataLoadInfoOkButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
		private By messageInfoAlertMsg = By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]");
		
		
		//	driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"),options);
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//	driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//	driver.findElement(By.xpath("(//android.widget.EditText)[1]")).click();
		//	driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys("senthil_dup_prod");
		//	driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).click();
		//	driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys("Admin@123");
		//	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Start Secure Chat']")).click();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		// driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		
		//2. Page Constructor:
		public LoginScreen(AppiumDriver driver) {
			this.driver=driver;
			elemUtil = new ElementsUtil_LC(driver);		
		}
		
		public void allowPermission() {
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			
		}
			
		//3. Public Page Actions/Methods
		public String getAppHeader() {
			return elemUtil.waitForElementGetText(signInText, Constants.DEFAULT_TIME_OUT);
		}
		
		public boolean doEmptyLogin() {
			 return elemUtil.doIsEnabled(submitButton);
		}
		
		public String doInvalidUsername(String usrName, String pwd) {
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.waitForElementPresentAndClick(submitButton, Constants.DEFAULT_TIME_OUT);
			//elemUtil.doClick(submitButton);
			return elemUtil.waitForElementGetText(inusrAlert, Constants.DEFAULT_TIME_OUT);
			//elemUtil.doGetText(inusrAlert);
			//return invalidUserAlert;
			
		}
		
		public String doInvalidPwd(String usrName, String pwd) {
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			elemUtil.waitForElementPresentAndClick(submitButton, 30);

			return elemUtil.waitForElementGetText(inusrAlert, 30);
			
		}
		
		public String doAppLogin (String usrName, String pwd) {
			
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return messageHeader;
						
		}
		
		public HumBurgerIconScreen init_login(String usrName, String pwd) {
			
			System.out.println(allowPerm);
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new HumBurgerIconScreen(driver);
			
		}
		
		public ProfileScreen profileUpdateLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new ProfileScreen(driver);
			
		}
		
		
		public OneToOneChatWindow oneToOneUserLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_LOGIN_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new OneToOneChatWindow(driver);
			
		}
		
		public OneToGroupChatScreen oneToGroupLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_LOGIN_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new OneToGroupChatScreen(driver);
			
		}
		
		public ForwardOneToOne forwardFileOneUserLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new ForwardOneToOne(driver);
			
		}
		
		
		public SendTexttoUser sendTestMessageScreenLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new SendTexttoUser(driver);
			
		}
		
		public LogoutScreen logOutTestLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new LogoutScreen(driver);
			
		}
		
		public DataManagementScreen dataManagementLogin(String usrName, String pwd) {
			
			elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
			elemUtil.doSendKeys(userName,usrName);
			elemUtil.doSendKeys(passWord, pwd);
			elemUtil.doClick(submitButton);
			String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
			System.out.println(messageHeader);
			elemUtil.doClick(dataLoadInfoOkButton);
			return new DataManagementScreen(driver);
			
		}

		
		
		
		
		

		



}
