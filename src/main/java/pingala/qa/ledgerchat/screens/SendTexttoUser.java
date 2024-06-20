package pingala.qa.ledgerchat.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class SendTexttoUser {
	
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;	
	
	//1. Private By locators
	private By searchBtn 	= By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[4]");
	private By searchBar 	= By.xpath("//android.widget.EditText[@resource-id=\"RNE__Input__text-input\"]");
	private By searchOk 	= By.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"󰍉\"]");
	private By usrTitle 	= By.xpath("//android.widget.TextView[@text=\"Karthik kumaranFour\"]");
	private By usrBack 		= By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup");
	private By textBox 		= By.xpath("//android.widget.EditText[@text=\"Type a message..\"]");
	private By sendBtn 		= By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
	private By lastMsg 		= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By notPad 		= By.xpath("//android.widget.FrameLayout[@resource-id='android:id/status_bar_lateest_event_conntent'])[1])");
	private By searchLens 	= By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__Image__children__container\"])[1]");
	private By usrProfileName 	= By.xpath("//android.widget.TextView[@text=\"Karthik kannan\"]");
	private By backToChatWindowBtn = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[1]");
	private By homePageUsrList 	= By.xpath("//android.widget.TextView[@text=\"LedgerChat\"]");
	private By emptyListLabel 	= By.xpath("//android.widget.TextView[@text=\"No User Found\"]");
	private By searchUsr		=By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__LISTITEM__padView\"])[1]");
	private By userNameSelect = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__LISTITEM__padView\"])[1]");
	
	
	//2. Page Constructor:
		public SendTexttoUser(AppiumDriver driver) {
			this.driver=driver;
			elemUtil = new ElementsUtil_LC(driver);		
		}
		
		
	
	//3. Public Page Actions/Methods
		
//	public void getWebelement ()
//	{
//		elemUtil.waitForElementPresentAndClick(searchLens, Constants.DEFAULT_TIME_OUT);
//		elemUtil.waitForElementPresence(searchBar, Constants.DEFAULT_TIME_OUT);
//		elemUtil.doClick(searchBar);
//		elemUtil.doSendKeys(searchBar, "Karthik");
//		
//		for (int i=1; i<=20; i++)
//		{
//			searchUsr = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__LISTITEM__padView\"])["+i+"]");
//			String val = elemUtil.doGetText(searchUsr);
//			System.out.println(val);
//		}
//		
//		List<WebElement> usrname = elemUtil.getElementsList(searchUsr);
//		for (WebElement e :usrname)
//		{
//			String attrVal = e.getText();	
//			if (attrVal.contains("Karthik Kannan"))
//			{
//				System.out.println(attrVal);
//			
//				break;
//			}
//			
//		}
//	}

	public String searchActiveUser (String searchUserName)
	{
		elemUtil.waitForElementPresentAndClick(searchLens, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(searchBar, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(searchBar);
		elemUtil.doSendKeys(searchBar, searchUserName);
			
		        try {
					elemUtil.waitForElementPresentAndClick(userNameSelect, Constants.DEFAULT_TIME_OUT);
		            
		        } catch(StaleElementReferenceException e) 
		        {
		        }
				    
		    return elemUtil.waitForElementGetText(usrProfileName, Constants.DEFAULT_TIME_OUT);
		    
		    
	}
		
	public String backToHomePage() {
			elemUtil.waitForElementPresentAndClick(backToChatWindowBtn, Constants.DEFAULT_TIME_OUT);
			String homeSrnVal = elemUtil.waitForElementGetText(homePageUsrList, Constants.DEFAULT_TIME_OUT);
			return homeSrnVal;
	}
	
	public String searchBlockedUser(String searchBlockedUsrName)
	{
		elemUtil.waitForElementPresentAndClick(searchLens, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(searchBar, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(searchBar);
		elemUtil.doSendKeys(searchBar, searchBlockedUsrName);
		return elemUtil.waitForElementGetText(emptyListLabel, Constants.DEFAULT_TIME_OUT);	
	}

	public void clickFirstName(String searchName) {
		elemUtil.waitForElementPresentAndClick(searchBar, Constants.DEFAULT_TIME_OUT);
		elemUtil.doSendKeys(searchBar, searchName);
			
		try {
			
			elemUtil.doClickFromList(searchUsr, "Karthik Kannan");
			 try{
				 String userTitle = elemUtil.doGetText(usrTitle);
				 System.out.println(userTitle);
				 try {
					 elemUtil.doSendKeys(textBox, "hello");
					 elemUtil.doClick(sendBtn);
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
			 }catch (Exception err) {
				 err.printStackTrace();
			 }
		}catch (Exception er) {
			er.printStackTrace();
		}
	}
	
	
	
//	public String openNotification() {
//		try {
//			//minimze the app (press home button)
//			driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
//		
//			//open notification
//			driver.openNotifications();
//		
//			elemUtil.doClick(notPad);
//			return elemUtil.doGetText(lastMsg);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	
	public void searchSceondName() {
		elemUtil.doClick(usrBack);

		elemUtil.doClick(searchBtn);
		elemUtil.doSendKeys(searchBar, "KumaranFour");
		try {
			elemUtil.doClickFromList(searchUsr, "Karthik kumaranFour");
			 try{
				 String userTitle = elemUtil.doGetText(usrTitle);
				 System.out.println(userTitle);
				 try {
					 elemUtil.doSendKeys(textBox, "hello");
					 elemUtil.doClick(sendBtn);
					 elemUtil.doClick(usrBack);
					 }catch (Exception e) {
					 e.printStackTrace();
				 }
			 }catch (Exception err) {
				 err.printStackTrace();
			 }
		}catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void searchFullName() {
		elemUtil.doClick(searchBtn);
		elemUtil.doSendKeys(searchBar, "Karthik KumaranFour");
		try {
			elemUtil.doClickFromList(searchUsr, "Karthik kumaranFour");
			 try{
				 String userTitle = elemUtil.doGetText(usrTitle);
				 System.out.println(userTitle);
				 try {
					 elemUtil.doSendKeys(textBox, "hello");
					 elemUtil.doClick(sendBtn);
					 elemUtil.doClick(usrBack);
					 }catch (Exception e) {
					 e.printStackTrace();
				 }
			 }catch (Exception err) {
				 err.printStackTrace();
			 }
		}catch (Exception er) {
			er.printStackTrace();
		}
	}
}
