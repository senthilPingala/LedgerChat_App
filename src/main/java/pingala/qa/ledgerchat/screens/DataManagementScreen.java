package pingala.qa.ledgerchat.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class DataManagementScreen {
	
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;
	
	private By loadLimitMessageBtn = By.id("android:id/button1");
	private By burgerIcon = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[1]");	
	private By userId = By.xpath("//android.widget.TextView[@text=\"Karthik kumaranFour\"]");
			
 	private By dataManagement = By.xpath("//android.widget.TextView[@text=\"Data Management\"]");
	private By dataManagementTitle = By.xpath("//android.widget.TextView[@text=\"Data Management\"]");
	private By backArrow = By.xpath("//android.widget.Button[@content-desc=\"back-nav\"]");
	
	//****************** PURGE SECTION ********************************************************
	private By purgeInfo = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]");
	private By purgeInfoText = By.xpath("//android.widget.TextView[@text=\"Purging will remove all LedgerChat messages older than the selected date from your device. To view these messages again, use the retrieve function.\"]");
	public By monthLocator = AppiumBy.id("com.ledgerchatenterprise:id/month");
	public By dateLocator = AppiumBy.id("com.ledgerchatenterprise:id/date");
	public By yearLocator = AppiumBy.id("com.ledgerchatenterprise:id/year");
	private By submit = By.xpath("//android.widget.TextView[@text=\"Submit\"]");
	private By msgContainFromText = By.xpath("//android.widget.TextView[@text=\"Device contain messages from 30-09-2023 05:50 PM onwards.\"]");
	
	//**************************RETRIVE SECTION **************************************************
	private By retrieve = By.xpath("android.widget.TextView[@text=\"Retrieve\"]");
	private By retrieveText = By.xpath("//android.widget.TextView[@text=\"Retrieve data from a specific date or from the beginning .\"]");
	private By timeText = By.xpath("//android.widget.TextView[@text=\"From Beginning\"]");
	private By fromBeginingRadioBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"testId-view1-data-management4\"]");
	private By selectTime = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup");
	
	private By alertTitle = AppiumBy.id("android:id/alertTitle");
	private By alertText = AppiumBy.id("android:id/message");
	private By cancel = AppiumBy.id("android:id/button2");
	private By accept = AppiumBy.id("android:id/button1");
	
	
	public DataManagementScreen(AppiumDriver driver) {
		this.driver=driver;
		elemUtil = new ElementsUtil_LC(driver);
		
	}
	
	//3. Public Page Actions/Methods
	public String clickHumBurgerIcon() {
		elemUtil.waitForElementPresentAndClick(burgerIcon, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(userId, Constants.DEFAULT_TIME_OUT);
	}
	
	public String doClickOnDataManagement () {
		
		//elemUtil.waitForElementPresentAndClick(loadLimitMessageBtn, Constants.DEFAULT_TIME_OUT);
		//elemUtil.waitForElementPresentAndClick(burgerIcon, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(dataManagement, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(dataManagementTitle, Constants.DEFAULT_TIME_OUT);
		
	}
	
	public String doGetPurgeInfo() {
       return elemUtil.doGetText(purgeInfoText);
    }	
	
	
	
	public void purgeDateSelection(String month, String date, String year) {
	    // Set month
	    scrollElementTo(monthLocator, month);
	    
	    // Set date
	    scrollElementTo(dateLocator, date);
	    
	    // Set year
	    scrollElementTo(yearLocator, year);
	    
	    // Click on submit
	    WebElement submitElement = driver.findElement(submit);
	    submitElement.click();
	}

	@SuppressWarnings("deprecation")
	private void scrollElementTo(By locator, String value) {
	    WebElement element = driver.findElement(locator);
	    element.clear();
	    element.sendKeys(value);
	    
	    // Scroll to the element
	    int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
	    int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
	    int endX = startX;
	    int endY = startY - 100; // You can adjust this value as needed
	    

	}
	

}
