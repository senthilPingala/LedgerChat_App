package pingala.qa.ledgerchat.screens;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import lombok.var;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;
import pingala.ledgerchat.qa.LedgerChatAppium.ElementsUtil_LC;
import pingala.qa.ledgerchat.screens.ForwardOneToOne.scrollDirection;
import pingala.qa.ledgerechat.contantutils.Constants;

public class OneToOneChatWindow  {
	
	//private AndroidDriver driver;
	private AppiumDriver driver;
	private ElementsUtil_LC elemUtil;

	
	//1. Private By locators
	private By padview = By.xpath("//android.widget.TextView[@resource-id='android:id/title']");
	//private By chatList = By.xpath("//android.widget.ScrollView/android.view.ViewGroup");
	//private By chatList = By.id("listItemTitle");
	private By chatList = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__LISTITEM__padView\"])[1]");
	private By selectedUser = By.xpath("//android.widget.TextView[@text=\"Pkarthik Automation\"]");
 	private By usrname = By.xpath("//android.widget.TextView[@text=\"vinayaka hk\"]");

 	/*
 	 * ******************** Text Messages *******************************************
 	 */
	private By textField = By.xpath("//android.widget.EditText[@text=\"Type a message..\"]");
	private By sendButton = By.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"\"]");
	private By sentMessage = By.xpath("//android.widget.TextView[@text=\"Hi all, this is automated message\"]");
	private By forwarableImage = By.xpath("//android.widget.TextView[@text=\"Secure-chat-1.jpg\"]");
	/*
 	 * LedgerChat Attachment Icons  [File, Image, Video]
 	 */
 	private By attachmentBtn 	= By.xpath("//android.widget.Button[@content-desc=\"attach\"]");

	//********************** Attach Image From Gallery*********************************
	private By imageGalleryBtn	= By.xpath("//android.view.ViewGroup[@content-desc=\"testId-view1-view6\"]");
	private By imageSelected = By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"LedgerFi.jpg\"]");
	private By sentImageInChat = By.xpath("(//android.widget.TextView[@text=\"LedgerFi.jpg\"])[1]");

	//********************** Attach PDF From Files *************************************
	private By fileUpload	= By.xpath("//android.widget.ImageView[@content-desc=\"camera-take-photo\"]");
	private By pdfSelected 	= By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"LedgerFI_.pdf\"]");
	private By sendBtnInFile = By.xpath("//android.widget.Button[@content-desc=\"send\"]");
	private By sentFileCheck = By.xpath("//android.widget.TextView[@text=\"LedgerFI_.pdf\"]");
	private By sentNonFwdFileCheck = By.xpath("(//android.widget.TextView[@text=\"NonForwardable.pdf\"])[1]");
	private By filePreviewReceiverName = By.xpath("//android.widget.TextView[@content-desc=\"display-name\"]");
	private By filePreviewCloseBtn = By.xpath("//android.widget.Button[@content-desc=\"close\"]");
	

	//********************** Attach VIDEO File From Videos ******************************
	private By videoUpload 	= By.xpath("//android.widget.Button[@content-desc=\"video-cam\"]");
	private By videoFile = By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"file_example_MP4_640_3MG.mp4\"]");
	private By sentVideoCheck = By.xpath("//android.widget.TextView[@text=\"file_example_MP4_640_3MG.mp4\"]");
	
	
	/*
	 * Eclipse Button 3 dots
	 */
 	
	 private By eclipseBtn = By.xpath("//android.widget.Button[@content-desc=\"ellipsis\"]");
	 private By defaultFwdOption = By.xpath("//android.widget.CheckBox[@content-desc=\"check-icon-fwd-selected\"]");
	 private By fwdOptionDeselected = By.xpath("//android.widget.CheckBox[@content-desc=\"check-icon-fwd-not-selected\"]");
	 //private By unCheckfwdCheckBox = By.xpath("(//android.widget.TextView[@resource-id=\"RNE__Checkbox__Icon\" and @text=\"\"]");
	
	 private By imageForForward = By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"LC_Forwardable.png\"]");
	 private By sentImageForForward = By.xpath("//android.widget.TextView[@text=\"LC_Forwardable.png\"]");
	 private By nonForwardableFile = By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"NonForwardable.pdf\"]");
	 
	 private By unCheckfwdCheckBox = By.xpath("//android.widget.CheckBox[@content-desc=\"check-icon-fwd-selected\"]");
	 private By fwdCheckBoxCheck = By.xpath("//android.widget.TextView[@resource-id=\"RNE__Checkbox__Icon\" and @text=\"\"]");
	 private By forwardIcon = By.xpath("(//android.view.ViewGroup[@resource-id=\"RNE__ICON\"])[2]");
	 
	 private By fwdOptionCloseBtn = By.xpath("//android.widget.TextView[@text=\"Close\"]");
	 private By attachSharingPopUp = By.xpath("//android.widget.TextView[@text=\"Attachments Sharing Option\"]");
	 private By elem = AppiumBy.xpath("//android.widget.TextView[@text=\\\"LedgerFI_.pdf\\\"]");
	 
	 
 	/*
 	 * 	**********************Camera - Capture Images & Videos **************************************
 	 */

	// ******************************* CAPTURE IMAGES *****************************************
	private By cameraIcon = By.xpath("//android.widget.Button[@content-desc=\"camera-photo\"]");	
	private By allowPermission = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]");
	private By videopermission = By.id("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]");
	private By captureClick = By.xpath("//android.widget.Button[@content-desc=\"take-picture\"]");
	private By captImageSentName = By.xpath("//android.widget.TextView[@text=\"captured-image.jpg\"]");
	private By capturedImgDelete = By.xpath("//android.widget.Button[@content-desc=\"delete-image\"]");
	private By capturedImgSendBtn = By.xpath("//android.widget.Button[@content-desc=\"send-image\"]");
	
	// ******************************* CAPTURE VIDEOS *****************************************
	private By videoButton = By.xpath("//android.widget.Button[@content-desc=\"video-camera\"]");
	private By startVideoRecord = By.xpath("//android.widget.Button[@content-desc=\"record-start\"]");
	private By stopVideoRecord	= By.xpath("//android.widget.Button[@content-desc=\"record-stop\"]");
	private By msgForSendCapVideo = By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]");
	private By approveCapVideo = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
	private By cancelCapVideo = By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]");
	private By sentCapVideVeri = By.xpath("//android.widget.TextView[@text=\"captured-video.mp4\"]");
	private By replytoVideo = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By frontCamereAccessPerm = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	private By chatListName = By.xpath("//android.widget.TextView[@resource-id=\"listItemTitle\"]");
	
	
	
	//2. Page Constructor:
	public OneToOneChatWindow(AppiumDriver driver) {
		this.driver=driver;
		elemUtil = new ElementsUtil_LC(driver);		
	}
	
	
	// 3. Public Page Actions/Methods

	public String openSingleUserToChat(String chatUsrName) {
		
		elemUtil.doClickFromList(chatListName, chatUsrName);
		elemUtil.waitForElementPresentAndClick(frontCamereAccessPerm, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(selectedUser, Constants.DEFAULT_TIME_OUT);
		
		}
		
		
	public String attachImgThroughGallery() {
		elemUtil.waitForElementPresentAndClick(attachmentBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(imageGalleryBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(imageSelected, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(imageSelected);
		elemUtil.waitForElementPresence(sentImageInChat, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(sentImageInChat, Constants.DEFAULT_TIME_OUT);
	}
	
	public String attachImgForForward() {
		elemUtil.waitForElementPresentAndClick(attachmentBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(imageGalleryBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(imageForForward, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(imageForForward);
		elemUtil.waitForElementPresence(sentImageForForward, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(sentImageForForward, Constants.DEFAULT_TIME_OUT);
	}
	
	public String attachPDFThroughFile() throws InterruptedException {
		Thread.sleep(5000);
		elemUtil.waitForElementPresentAndClick(attachmentBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(fileUpload, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(pdfSelected, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(pdfSelected);
		Thread.sleep(5000);
		elemUtil.waitForElementPresentAndClick(sendBtnInFile, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(sentFileCheck, Constants.DEFAULT_TIME_OUT);
	}
	
	
	public String attachVideoFromVideosOption() throws InterruptedException {
		elemUtil.waitForElementPresentAndClick(attachmentBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(videoUpload, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(videoFile, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(sentVideoCheck, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(sentVideoCheck);
		Thread.sleep(3000);
		String videoFileName = elemUtil.doGetText(sentVideoCheck);
		return videoFileName;
		
	}
	
	public String captureImageFromCamera() throws InterruptedException {
		elemUtil.waitForElementPresentAndClick(cameraIcon, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(allowPermission, Constants.DEFAULT_TIME_OUT);
//		elemUtil.waitForElementPresence(allowPermission, Constants.DEFAULT_TIME_OUT);
//		elemUtil.waitForElementPresentAndClick(allowPermission, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(captureClick,Constants.DEFAULT_TIME_OUT);
		Thread.sleep(2000);
		elemUtil.waitForElementPresence(capturedImgSendBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(capturedImgSendBtn, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(captImageSentName, Constants.DEFAULT_TIME_OUT);
	}
	
	
	public String captureVideoFromCamera() throws InterruptedException {
		Thread.sleep(5000);
		elemUtil.waitForElementPresentAndClick(cameraIcon, Constants.DEFAULT_TIME_OUT);
		//elemUtil.waitForElementPresentAndClick(allowPermission, Constants.DEFAULT_TIME_OUT);
//		elemUtil.waitForElementPresence(allowPermission, Constants.DEFAULT_TIME_OUT);
//		elemUtil.waitForElementPresentAndClick(allowPermission, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(videoButton,Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(startVideoRecord , Constants.DEFAULT_TIME_OUT);
		Thread.sleep(5000);
		elemUtil.waitForElementPresentAndClick(stopVideoRecord, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(approveCapVideo, Constants.DEFAULT_TIME_OUT);
		return elemUtil.waitForElementGetText(sentCapVideVeri, Constants.DEFAULT_TIME_OUT);
	}
	
	public String forwardOptionPop() {
		elemUtil.waitForElementPresence(eclipseBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(eclipseBtn, Constants.DEFAULT_TIME_OUT);
		String popupHeaderText = elemUtil.waitForElementGetText(attachSharingPopUp , Constants.DEFAULT_TIME_OUT);
		return popupHeaderText;
	}
	
	public String defaultFWDCheck() {
		String defaultChk = elemUtil.waitForElementGetText(defaultFwdOption, Constants.DEFAULT_LOGIN_TIME_OUT);
		elemUtil.waitForElementPresence(fwdOptionCloseBtn, Constants.DEFAULT_TIME_OUT);
		return defaultChk;
	}
	

	
	public String unCheckForwardOption() throws InterruptedException {
		Thread.sleep(2000);
		elemUtil.waitForElementPresence(eclipseBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(eclipseBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementGetText(attachSharingPopUp , Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(unCheckfwdCheckBox);
		String uncheckedCheckbox = elemUtil.waitForElementPresence(fwdOptionDeselected, Constants.DEFAULT_TIME_OUT).getAttribute("content-desc");

		elemUtil.waitForElementPresence(fwdOptionCloseBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(fwdOptionCloseBtn );
		return uncheckedCheckbox;
	}
	
		
	public String sendNonForwardableFile() throws InterruptedException {
		
		elemUtil.waitForElementPresentAndClick(attachmentBtn, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresentAndClick(fileUpload, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(nonForwardableFile, Constants.DEFAULT_TIME_OUT);
		elemUtil.doClick(nonForwardableFile);
		Thread.sleep(5000);
		elemUtil.waitForElementPresentAndClick(sendBtnInFile, Constants.DEFAULT_TIME_OUT);
		String nonFwdFileName =  elemUtil.waitForElementGetText(sentNonFwdFileCheck, Constants.DEFAULT_TIME_OUT);
		return nonFwdFileName;
	}
	

	
	public boolean checkFileNonForwardable() throws InterruptedException {
		Thread.sleep(5000);
		WebElement sentImg = elemUtil.getFindElement(sentNonFwdFileCheck);
		Thread.sleep(5000);
		longPress(sentImg);
		WebElement e = elemUtil.waitForElementPresence(forwardIcon, Constants.DEFAULT_TIME_OUT);
		if(e.isDisplayed()) {
			return false;
		}
		else {
			return true;
		}
			
	}
	
	public String sendTextMessage(String textMessage) {
		
		elemUtil.doClick(textField);
		elemUtil.doSendKeys(textField, textMessage);
		elemUtil.waitForElementPresentAndClick(sendButton, Constants.DEFAULT_TIME_OUT);
		elemUtil.waitForElementPresence(sentMessage, Constants.DEFAULT_TIME_OUT);
		String sentMsg = elemUtil.waitForElementGetText(sentMessage, Constants.DEFAULT_TIME_OUT);
		return sentMsg;
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
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), scroll_Dur);
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
	
	protected  void swipe(Point start, Point end, Duration duration) {
	
	    PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence swipe = new Sequence(input, 0);
	    swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
	    swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

	    swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
	    swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
	}
	
	public void longPress(WebElement e) {
		Point location = e.getLocation();
		System.out.println(location);
	    PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence swipe = new Sequence(input, 0);
	    swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
	    swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    
	    swipe.addAction(input.createPointerMove(Duration.ofSeconds(3), PointerInput.Origin.viewport(), location.x, location.y));
	    swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
	}
	
}
