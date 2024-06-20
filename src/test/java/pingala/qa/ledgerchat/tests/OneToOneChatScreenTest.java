package pingala.qa.ledgerchat.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.Assert;

import pingala.qa.ledgerechat.contantutils.Constants;

public class OneToOneChatScreenTest extends BaseTest {

	@Test(priority=0)
	public void oneToOneChatSetup() throws InterruptedException {
		
		Thread.sleep(5000);
		oneToOneChat = loginScreen.oneToOneUserLogin(prop.getProperty("oneToOneUserLogin").trim(),
				prop.getProperty("oneToOneUserLoginPwd").trim());
		
	}
	
	@Test(priority=1)
	public void openChatWindowTest() {
		String chatUser = oneToOneChat.openSingleUserToChat(prop.getProperty("selectSingleUser"));
		System.out.println(chatUser);
		Assert.assertEquals(chatUser, Constants.SELECTED_SINGLE_USER);
	}
	
	@Test(priority=2)
	public void sendingMessageTest() {
		String msg = oneToOneChat.sendTextMessage(prop.getProperty("automatedMessage"));
		System.out.println(msg);
		Assert.assertEquals(msg, Constants.SENT_MESSAGE_CHECK);	
	}
	
	@Test(priority=3)
	public void attachImageFromGalleryTest() {
		String imgName = oneToOneChat.attachImgThroughGallery();
		System.out.println(imgName);
		Assert.assertEquals(imgName, Constants.SENT_IMAGE_FROM_GALLERY);
	}
	
	@Test(priority=4)
	public void attachPDFfromFileOptionTest() throws InterruptedException {
		String fileName = oneToOneChat.attachPDFThroughFile();
		System.out.println(fileName);
		Assert.assertEquals(fileName, Constants.SENT_PDF_FROM_FILEOPTION);
	}

	@Test(priority=5)
	public void attachVideoTest() throws InterruptedException {
		String mp4contains = oneToOneChat.attachVideoFromVideosOption();
		Assert.assertEquals(mp4contains, Constants.SENT_VIDEO_FILE_NAME);
	}
	
	@Test(priority=6)
	public void attachCapturedImageTest() throws InterruptedException {
			String capImageName = oneToOneChat.captureImageFromCamera();
			System.out.println(capImageName);
			Assert.assertEquals(capImageName, Constants.SENT_CAPT_IMAGE_NAME);
	}
	
	@Test(priority=7)
	public void attachCapturedVideoTest() throws InterruptedException {
			String capVideoName = oneToOneChat.captureVideoFromCamera();
			System.out.println(capVideoName);
			Assert.assertEquals(capVideoName, Constants.SENT_CAPT_VIDEO_NAME);
	}
	
	@Test(priority=8)
	public void attachImgForForward() {
		String imgName = oneToOneChat.attachImgForForward();
		System.out.println(imgName);
		Assert.assertEquals(imgName, Constants.SENT_IMAGE_FOR_FORWARD);
	}
	
	@Test(priority=9)
	public void popUpLaunchTest() {
		String popupHeader = oneToOneChat.forwardOptionPop();
		System.out.println(popupHeader);
		Assert.assertEquals(popupHeader, Constants.FORWARD_POPUP_HEADER);
	}
	
	@Test(priority=10)
	public void defaultForwardOptionTest() {
		String defaultChk = oneToOneChat.defaultFWDCheck();
		System.out.println(defaultChk);
		Assert.assertEquals(defaultChk, Constants.FORWARD_DEFAULT_CHECKED);
	}
	
	@Test(priority=11)
	public void uncheckForwardButtonTest() throws InterruptedException {
		String uncheckStatus = oneToOneChat.unCheckForwardOption();
		System.out.println(uncheckStatus);
		Assert.assertEquals(uncheckStatus, Constants.FORWARD_DISABLED_STATUS);
	}
		
	@Test(priority=12)
	public void sendNonForwardableFileTest() throws InterruptedException {
		String fileFwdname = oneToOneChat.sendNonForwardableFile();
		System.out.println(fileFwdname);
		Assert.assertEquals(fileFwdname, Constants.SENT_NON_FORWARD_FILE);
	}
	
	@Test(priority=13)
	public void forwardBtnHiddenTest() throws InterruptedException {
		boolean val = oneToOneChat.checkFileNonForwardable();
		Assert.assertFalse(val);
	}
	
}
