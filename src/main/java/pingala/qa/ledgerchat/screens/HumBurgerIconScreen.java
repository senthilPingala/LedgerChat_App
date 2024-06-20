package pingala.qa.ledgerchat.screens;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class HumBurgerIconScreen {
	
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;
	
	
	//1. Private By locators
	private By burgerIcon = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[1]");	
	//private By burgerIcon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");

	private By userId = By.xpath("//android.widget.TextView[@text=\"KarthikSeven Automation\"]");
	private By emailId = By.xpath("//android.widget.TextView[@text=\"karthil7@gmail.com\"]");
	private By profileImg = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__Image__placeholder\"])[5]");
	private By chatList = By.xpath("//android.widget.TextView[@text=\"ChatList\"]");
	private By profileScrn = By.xpath("//android.widget.TextView[@text=\"Profile\"]");
	private By dataManagement = By.xpath("//android.widget.TextView[@text=\"Data Management\"]");
	private By logout = By.xpath("//android.widget.TextView[@text=\"Logout\"]");
	private By dataLoadInfoOkButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
	private By messageInfoAlertMsg = By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]");
	private By allowPerm	= By.id("com.android.permissioncontroller:id/permission_allow_button");
	private By humBergerSections = By.xpath("android.widget.TextView");
	
	//2. Page Constructor:
	public HumBurgerIconScreen(AppiumDriver driver) {
		this.driver=driver;
		elemUtil = new ElementsUtil_LC(driver);		
	}
	
	public void allowPermission() {
		elemUtil.waitForElementPresentAndClick(allowPerm,Constants.DEFAULT_TIME_OUT);
	}
	
	//3. Public Page Actions/Methods
	
//	
		
	public String clickBurgerIcon() {
		elemUtil.waitForElementPresentAndClick(burgerIcon, Constants.DEFAULT_TIME_OUT);
		String name = elemUtil.waitForElementGetText(userId, 20);
		System.out.println(name);
		return name;
	}
	
//	public List<String> humBurgerSections() {
//		List <WebElement> humBurgerSec = elemUtil.waitForWebElementsPresence(humBergerSections, Constants.DEFAULT_TIME_OUT);
//		List<String> secValue = new ArrayList<String> ();
//		for (WebElement e : humBurgerSec)
//		{
//			String val = e.getText();
//			secValue.add(val);
//		}
//		System.out.println(secValue);
//		return secValue;
//	}
	
	
	public String printEmail() {
		return elemUtil.doGetText(emailId);
	}
	
    public String printchatList() {   
        return elemUtil.doGetText(chatList);
    }
    
    public String printProfileScrn() {
    	 return elemUtil.doGetText(profileScrn);
    }
    
    public String printDataManagement() {
    	return elemUtil.doGetText(dataManagement);
    }
    
    public String printLogout() {
    	return elemUtil.doGetText(logout);
    }
    
}
