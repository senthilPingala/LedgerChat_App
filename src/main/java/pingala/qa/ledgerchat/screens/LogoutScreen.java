package pingala.qa.ledgerchat.screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class LogoutScreen {
	
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;
	
	
	//1. Private By locators
	
	private By burgerIcon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By userId = By.xpath("//android.widget.TextView[@text=\"Karthik kumaranFour\"]");
	private By logout = By.xpath("//android.widget.TextView[@text=\"Logout\"]");
	private By alertTitle = AppiumBy.id("android:id/alertTitle");
	private By alertText = AppiumBy.id("android:id/message");
	private By cancel = AppiumBy.id("android:id/button2");
	private By accept = AppiumBy.id("android:id/button1");
	private By signInText	= By.xpath("//android.widget.TextView[@text=\"Sign in\"]");

	
	//2. Page Constructor:
	public LogoutScreen(AppiumDriver driver) {
		this.driver=driver;
		elemUtil = new ElementsUtil_LC(driver);		
	}
	
	//3. Public Page Actions/Methods
	public String clickBurgerIcon() {
		elemUtil.doClick(burgerIcon);
		return elemUtil.waitForElementGetText(logout, Constants.DEFAULT_TIME_OUT);
	}
	
	public String clicklogout() {
		elemUtil.doClick(logout);
		return elemUtil.waitForElementGetText(alertText, Constants.DEFAULT_TIME_OUT);
	}
	
	public String logoutOk() {
		elemUtil.doClick(accept);
		return elemUtil.waitForElementGetText(signInText, Constants.DEFAULT_TIME_OUT);
	}

}
