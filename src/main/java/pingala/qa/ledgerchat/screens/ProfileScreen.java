package pingala.qa.ledgerchat.screens;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class ProfileScreen {
	
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;
	
	
	//1. Private By locators
	private By appName = By.xpath("//android.widget.TextView[@text=\"LedgerChat\"]");
	private By burgerIcon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By userId = By.xpath("//android.widget.TextView[@text=\"Karthik kumaranFour\"]");
	private By sectionID = By.xpath("//android.widget.TextView");
	
	private By privacyPolicyWebDoc = By.xpath("//android.widget.TextView[@text=\"Information Collection and Use\"]");
	
	
	private By hamBurgerIcon = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[1]");
	private By profileScrn = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button");
	private By profileTitle = By.xpath("//android.widget.TextView[@text=\"Profile\"]");
	private By backArrow = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By userName = By.xpath("//android.widget.TextView[@text=\"Karthik kumaranFour\"]");
	private By emailId = By.xpath("//android.widget.TextView[@text=\" karthil4@gmail.com\"]");
	private By profileImg = By.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"\"]");
	private By privacyPolicy = By.xpath("//android.widget.TextView[@text=\"Privacy Policy\"]");
	private By updatePassword = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
	private By appVersion = By.xpath("//android.widget.TextView[@text=\"App version 0.0.20\"]");
	private By updatePasswordLink = By.xpath("//android.widget.TextView[@text=\"Update Password\"]");
	
//	update password
	private By backArrow1 	= By.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"\"]");
	private By udpassTitle 	= By.xpath("//android.widget.TextView[@text=\"Update password\"]");
	private By oldPassword 	= By.xpath("//android.widget.EditText[@text=\"Old Password\"]");
	
	
	private By opEye 		= By.xpath("(//android.widget.TextView[@resource-id=\"RNE__ICON__Component\"])[2]");
	private By opGuidlines 	= By.xpath("//android.widget.TextView[@text=\"Please enter oldPassword\"]");
	private By newPassword 	= By.xpath("//android.widget.EditText[@text=\"New Password\"]");
	private By npEye 		= By.xpath("(//android.widget.TextView[@resource-id=\"RNE__ICON__Component\"])[3]");
	private By npGuildlines = By.xpath("//android.widget.TextView[@text=\"Password needs a mix of 1 uppercase, 1 lowercase, 1 digit, 1 special character (!@#$%^&*), and must be at least 6 characters long\"]");
	private By confirmPassword = By.xpath("//android.widget.EditText[@text=\"Confirm password\"]");
	private By cpEye 		= By.xpath("(//android.widget.TextView[@resource-id=\"RNE__ICON__Component\"])[4]");
	private By cpGuildlines = By.xpath("//android.widget.TextView[@text=\"Confirm password is required\"]");
	private By alertMessage = By.id("com.ledgerchatenterprise:id/snackbar_text");
	private By pwdMismatch 	= By.xpath("//android.widget.TextView[@text=\"The passwords do not match\"]");
	private By submit = By.xpath("//android.widget.TextView[@text=\"Submit\"]");
	
	private By updatePasswordText = AppiumBy.id("android:id/alertTitle");
	private By updatePasswordMessage = AppiumBy.id("android:id/message");
	private By updatePasswordButton = AppiumBy.id("android:id/button1");
	private By signInText	= By.xpath("//android.widget.TextView[@text=\"Sign in\"]");
	
	private By userLoginName 	= By.xpath("(//android.widget.EditText)[1]");
	private By passWord 	= By.xpath("(//android.widget.EditText)[2]");
	private By submitButton = By.xpath("//android.widget.TextView[@text=\"Start Secure Chat\"]");
	private By dataLoadInfoOkButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
	private By messageInfoAlertMsg = By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]");
	
	
	
	//2. Page Constructor:
	public ProfileScreen(AppiumDriver driver) {
		this.driver=driver;
		elemUtil = new ElementsUtil_LC(driver);		
	}
	
	//3. Public Page Actions/Methods
	public String clickHumBurgerIcon() {
		elemUtil.doClick(hamBurgerIcon);
		return elemUtil.waitForElementGetText(userId,  Constants.DEFAULT_TIME_OUT);
	}
	
	public String clickOnProfile () {
        elemUtil.doClick(profileScrn);
  		return elemUtil.doGetText(profileTitle);
	}
	
	public String getUserName() {
		return elemUtil.doGetText(userName);
	}
	
	public String getUserEmailID() {
		return elemUtil.doGetText(emailId);
	}
	
    public String getPrivacyPolicyDoc() { 
    	elemUtil.doClick(privacyPolicy);
    	elemUtil.waitForElementGetText(privacyPolicyWebDoc, Constants.DEFAULT_TIME_OUT);
    	String policyDoc = elemUtil.waitForElementGetText(privacyPolicyWebDoc, Constants.DEFAULT_TIME_OUT);
    	elemUtil.doActionsEscape();
    	driver.navigate().back();
    	//elemUtil.doClick(backArrow);
    	return policyDoc;
    }
    
   
    public String clickUpdatePassword() {
    	elemUtil.waitForElementPresentAndClick(updatePasswordLink, Constants.DEFAULT_TIME_OUT);
    	elemUtil.waitForElementPresence(udpassTitle, Constants.DEFAULT_TIME_OUT);
    	return elemUtil.doGetText(udpassTitle);
    }
    
 
    public String checkInvalidOldPWD(String oldPWD, String newPWD, String confPWD) {
    	elemUtil.doClick(oldPassword);
    	elemUtil.doSendKeys(oldPassword, oldPWD);
    	elemUtil.doClick(newPassword);
    	elemUtil.doSendKeys(newPassword, newPWD);
    	elemUtil.doClick(confirmPassword);
    	elemUtil.doSendKeys(confirmPassword, confPWD);
    	elemUtil.waitForElementPresentAndClick(submit, Constants.DEFAULT_TIME_OUT);
    	elemUtil.doClick(submit);
    	return elemUtil.doGetText(alertMessage);
     }
    
    public String checkNonMatchingPWD(String oldPWD, String newPWD,String confPWD) {
    	driver.navigate().back();
    	elemUtil.waitForElementPresentAndClick(updatePasswordLink, Constants.DEFAULT_TIME_OUT);
    	elemUtil.doSendKeys(oldPassword, oldPWD);
    	elemUtil.doClick(newPassword);
    	elemUtil.doSendKeys(newPassword, newPWD);
    	elemUtil.doClick(confirmPassword);
    	elemUtil.doClick(confirmPassword);
    	elemUtil.doSendKeys(confirmPassword, confPWD);
    	String pwdMisval = elemUtil.doGetText(pwdMismatch);
    	driver.navigate().back();
    	return pwdMisval;
     }
    
    
    public String validPWDUpdate(String oldPWD, String newPWD, String confPWD) {
    	driver.navigate().back();
    	elemUtil.waitForElementPresentAndClick(updatePasswordLink, Constants.DEFAULT_TIME_OUT);
    	elemUtil.doClick(oldPassword);
    	elemUtil.doActionsClearField();
    	elemUtil.doSendKeys(oldPassword, oldPWD);
    	elemUtil.doClick(newPassword);
    	elemUtil.doActionsClearField();
    	elemUtil.doSendKeys(newPassword, newPWD);
    	elemUtil.doClick(confirmPassword);
    	elemUtil.doActionsClearField();
    	elemUtil.doSendKeys(confirmPassword, confPWD);
    	elemUtil.waitForElementPresentAndClick(submit, Constants.DEFAULT_TIME_OUT);
    	elemUtil.doClick(submit);
    	String updatemsg = elemUtil.waitForElementGetText(updatePasswordMessage, Constants.DEFAULT_TIME_OUT);
    	elemUtil.doClick(updatePasswordButton);
    	return updatemsg;
     }
    
	public String newPasswordLogincheck() {
		return elemUtil.waitForElementGetText(signInText, Constants.DEFAULT_TIME_OUT);
	}
	
	public String loginUpdatedPWD (String usrName, String newPwd) {
		
		elemUtil.doSendKeys(userLoginName,usrName);
		elemUtil.doSendKeys(passWord, newPwd);
		elemUtil.doClick(submitButton);
		String messageHeader = elemUtil.waitForElementGetText(messageInfoAlertMsg, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(dataLoadInfoOkButton);
		return messageHeader;
					
	}
	
    public String printappVersion() {
    	return elemUtil.doGetText(appVersion);
    }
    
    public String back() {
    	elemUtil.doClick(backArrow);
  		return elemUtil.doGetText(appName);
    }
	
}
