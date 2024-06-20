package pingala.qa.ledgerchat.screens;

import java.time.Duration;

import javax.sound.midi.Sequence;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;

import org.openqa.selenium.interactions.PointerInput.Origin;

import com.google.common.collect.ImmutableList;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import io.appium.java_client.AppiumDriver;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerechat.contantutils.Constants;

public class ForwardOneToOne {
	
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;
	
	
	//1. Private By locators
	private By forwarableImage = By.xpath("//android.widget.TextView[@text=\"LC_Forwardable.png\"]");
	private By selectedUser = By.xpath("//android.widget.TextView[@text=\"Raju Automation\"]");
	private By textField = By.xpath("//android.widget.EditText[@text=\"Type a message..\"]");
	private By chatListName = By.xpath("//android.widget.TextView[@resource-id=\"listItemTitle\"]");
	private By frontCamereAccessPerm = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

	private By forwardIcon = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[2]");
	 
	private By forwardingTo = By.xpath("//android.widget.TextView[@resource-id=\"listItemTitle\"]");
	private By forwardToHeader = By.xpath("//android.widget.TextView[@text=\" Forward to...\"]");
	private By forwardSelectedCount = By.xpath("//android.widget.TextView[@text=\" 2 selected\"]");
	//private By forwardBtn = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[3]");
	
	private By forwardBtn = By.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"\"]");
	private By FwdAlertMessage = By.xpath("//android.widget.TextView[@resource-id=\"com.ledgerchatenterprise:id/snackbar_text\"]");
	 
	private By postForwardFocus = By.xpath("//android.widget.TextView[@text=\"Raju Automation\"]");
	private By chatWindowBackButton = By.xpath("//android.widget.Button[@content-desc=\"back-icon\"]");
	private By chatListWindowHeader = By.xpath("//android.widget.TextView[@text=\"LedgerChat\"]");
	private By forwardedFileName = By.xpath("//android.widget.TextView[@text=\"LC_Forwardable.png\"]");
	private By fileForwardedLabel = By.xpath("//android.widget.TextView[@text=\"Forwarded\"]");
	private By forwardSearchIcon = By.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[2]");
	private By forwardedToUser = By.xpath("//android.widget.TextView[@text=\"Hemanth Automation\"]"); 
	private By forwardedToGroup = By.xpath("//android.widget.TextView[@text=\"HR Team\"]");
	
	/*
 	 * ******************** Text Messages *******************************************
 	 */
	private By sendButton = By.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"\"]");
	private By sentReplyMessage = By.xpath("//android.widget.TextView[@text=\"File Received 12., # Thanks\"]");

	private By replyToView = By.xpath("//android.view.ViewGroup[@content-desc=\"annimatedView\"]");
	
	
	//2. Page Constructor:
	public ForwardOneToOne(AppiumDriver driver) {
		this.driver=driver;
		elemUtil = new ElementsUtil_LC(driver);		
	}
	
	public String openSingleUserToChat(String chatUsrName) {
		
		elemUtil.doClickFromList(chatListName, chatUsrName);
		elemUtil.waitForElementPresentAndClick(frontCamereAccessPerm, Constants.DEFAULT_LOGIN_TIME_OUT);
		String selectUsr =  elemUtil.waitForElementGetText(selectedUser, Constants.DEFAULT_TIME_OUT);
		return selectUsr;
		
		}
	
	
	public boolean checkForwardable() {
		
		WebElement sentImg = elemUtil.getFindElement(forwarableImage);
		longPress(sentImg);
		WebElement e = elemUtil.waitForElementPresence(forwardIcon, Constants.DEFAULT_TIME_OUT);
		return e.isDisplayed();
	}
	
	public String clickForwardButton() {
		elemUtil.doClick(forwardIcon);
		String fwdLabelHeader = elemUtil.waitForElementGetText(forwardToHeader, Constants.DEFAULT_TIME_OUT).trim();
		return fwdLabelHeader;
		
	}
	
	public String forWardFileTo(String userName, String groupName) throws InterruptedException {
	
		Thread.sleep(2000);
		
		elemUtil.doWaitAndClickFromList(forwardingTo, userName, Constants.DEFAULT_TIME_OUT);
		elemUtil.doWaitAndClickFromList(forwardingTo, groupName, Constants.DEFAULT_TIME_OUT);
		String selectCount = elemUtil.waitForElementGetText(forwardSelectedCount, Constants.DEFAULT_TIME_OUT);
		return selectCount;
		
	}
	
	public String forwardFileToUser() {
		elemUtil.doClick(forwardBtn);
		return elemUtil.waitForElementGetText(FwdAlertMessage, Constants.DEFAULT_TIME_OUT);
				
	}
	public String postForwardScreenFocus() {
		String chatUsrName = elemUtil.waitForElementGetText(postForwardFocus, Constants.DEFAULT_TIME_OUT);
		return chatUsrName;
	}
	
	public String backToChatWindow() {
		elemUtil.waitForElementPresentAndClick(chatWindowBackButton, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(chatListWindowHeader, Constants.DEFAULT_TIME_OUT);
	}
	
	public String openForwardToUserChat(String chatUsrName) {
		
		elemUtil.doClickFromList(chatListName, chatUsrName);
		return elemUtil.waitForElementGetText(forwardedToUser, Constants.DEFAULT_TIME_OUT);

		}
	
	public String checkingForwardedFileInUser() {
		String fwdedFileName = elemUtil.doGetText(forwardedFileName);
		return fwdedFileName;
	}
	
	public String forwardedLabelForFileCheck() {
		String forwardedLabel = elemUtil.doGetText(fileForwardedLabel);
		return forwardedLabel;
	}
	
	public String openForwardToGroupChat(String chatGroupName) {
		
		elemUtil.waitForElementPresentAndClick(chatWindowBackButton, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClickFromList(chatListName, chatGroupName);
		return elemUtil.waitForElementGetText(forwardedToGroup, Constants.DEFAULT_TIME_OUT);

		}
	
	public String checkingForwardedFileInGroup() {
		String fwdedFileName = elemUtil.doGetText(forwardedFileName);
		return fwdedFileName;
	}
	
	public String forwardedLabelInGroupCheck() {
				
		String forwardedLabel = elemUtil.doGetText(fileForwardedLabel);
		return forwardedLabel;
	}
	
	public boolean replyToFileAttached() {
		
		WebElement FwdImg = elemUtil.getFindElement(forwardedFileName);
		swipeRightOnElement(FwdImg);
		WebElement e = elemUtil.waitForElementPresence(replyToView, Constants.DEFAULT_TIME_OUT);
		return e.isDisplayed();
	}
	
	public String doReplytoFileAttached(String replyMessage) {
		
		elemUtil.waitForElementPresentAndClick(textField, Constants.DEFAULT_TIME_OUT);
		elemUtil.doSendKeys(textField, replyMessage);
		elemUtil.waitForElementPresentAndClick(sendButton, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(sentReplyMessage, Constants.DEFAULT_TIME_OUT);
		String repliedMsg = elemUtil.waitForElementGetText(sentReplyMessage, Constants.DEFAULT_TIME_OUT);
		return repliedMsg;
	}
	
	
	
	public enum scrollDirection {
		UP, DOWN, LEFT, RIGHT
	}
	
	public  void scroll(scrollDirection dir, double scrollRatio ) {
	    Duration scroll_Dur = Duration.ofMillis(300);
		if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }	
		      
		Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
		        
   //********** SWIPE BOTTOM to TOP [Vertical Swipe]******************************//
        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
//        Point Start = new Point(midPoint.x, bottom );
//        Point End = new Point(midPoint.x, top );
        
   //********** SWIPE LEFT to RIGHT [Horizontal Swipe] ***************************//
        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
        int right = midPoint.x + (int) (midPoint.x * scrollRatio);
//        Point swipeLtRStart = new Point(right, midPoint.y );
//        Point swipeLtREnd = new Point(left, midPoint.y );
        
        //swipe(Start, End, Duration.ofMillis(300));
		        
	
        if (dir == scrollDirection.UP) {
            swipe (new Point(midPoint.x, top), new Point(midPoint.x, bottom), scroll_Dur);
        } else if (dir == scrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), scroll_Dur);
        } else if (dir == scrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), scroll_Dur);
        } else if (dir == scrollDirection.RIGHT){
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), scroll_Dur);
        }
        else {
        	throw new Error ("Pass the Valid Direction of SWIPE Like UP, DOWN, RIGHT, LEFT");
        }
	}
	
//	protected void swipe(Point start, Point end, Duration duration) {
//	    try {
//	        Robot robot = new Robot();
//	        robot.mouseMove(start.x, start.y);
//	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//
//	        int distanceX = end.x - start.x;
//	        int distanceY = end.y - start.y;
//	        int steps = 100;
//	        int stepX = distanceX / steps;
//	        int stepY = distanceY / steps;
//
//	        for (int i = 0; i < steps; i++) {
//	            int x = start.x + stepX * i;
//	            int y = start.y + stepY * i;
//	            robot.mouseMove(x, y);
//	            Thread.sleep(duration.toMillis() / steps);
//	        }
//
//	        robot.mouseMove(end.x, end.y);
//	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//	    } catch (AWTException | InterruptedException e) {
//	        e.printStackTrace();
//	    }
//	}
	
	protected  void swipe(Point start, Point end, Duration duration) {
	
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
	    swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
	    swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

	    swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
	    swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    driver.perform(ImmutableList.of(swipe));
	}
	
//	public void longPress(WebElement e) {
//		Point location = e.getLocation();
//		System.out.println(location);
//	    PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//	    Sequence swipe = new Sequence(input, 0);
//	    swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
//	    swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//	    
//	    swipe.addAction(input.createPointerMove(Duration.ofSeconds(3), PointerInput.Origin.viewport(), location.x, location.y));
//	    swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//	    ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
//	}

    public void longPress(WebElement e) {
        Point location = e.getLocation();
        Dimension size = e.getSize();
        try {
            Robot robot = new Robot();
            robot.mouseMove(location.x + size.width / 2, location.y + size.height / 2);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(1000); // Adjust this value as per your requirement
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
	
//	public void swipeRightOnElement(WebElement elem) {
//		Point location = elem.getLocation();
//		System.out.println(location);
//	    PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//	    Sequence swipe = new Sequence(input, 0);
//	    swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
//	    swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//		
//	    swipe.addAction(input.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int)(location.x * 2) , location.y));
//	    swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//	    ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
//	}
    
    public void swipeRightOnElement(WebElement elem) {
        Point location = elem.getLocation();
        Dimension size = elem.getSize();
        try {
            Robot robot = new Robot();
            robot.mouseMove(location.x + size.width / 2, location.y + size.height / 2);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(location.x + size.width * 2, location.y + size.height / 2);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }

}
