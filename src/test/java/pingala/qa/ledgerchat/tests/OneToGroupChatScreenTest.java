package pingala.qa.ledgerchat.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.Assert;

import pingala.qa.ledgerechat.contantutils.Constants;

public class OneToGroupChatScreenTest extends BaseTest {

	@Test(priority=0)
	public void oneToGroupChatSetup() throws InterruptedException {
		
		Thread.sleep(5000);
		oneToGroupChat = loginScreen.oneToGroupLogin(prop.getProperty("groupChatLogin").trim(),
				prop.getProperty("groupChatLoginPwd").trim());
	}
	
	@Test(priority=1)
	public void openMutedGroupChatTest() {
		String silentGrpInfo = oneToGroupChat.openReadOnlyGroupToChat(prop.getProperty("readOnlyGroupName"));
		System.out.println(silentGrpInfo);
		Assert.assertEquals(silentGrpInfo, Constants.SILENT_GROUP_INFO_MESSAGE);
	}
	
	@Test(priority=2)
	public void openDeleteGroupTest() {
		String deletedGroupInfo = oneToGroupChat.openDeletedGroupToChat(prop.getProperty("deletedGroupName"));
		System.out.println(deletedGroupInfo);
		Assert.assertEquals(deletedGroupInfo, Constants.SILENT_GROUP_INFO_MESSAGE);
	}
	
	@Test(priority=3)
	public void openActiveGroupTest() {
		String activeGrp = oneToGroupChat.openActiveGroupToChat(prop.getProperty("activeGroup"));
		System.out.println(activeGrp);
		Assert.assertEquals(activeGrp, Constants.ACTIVE_GROUP_TEXT);
	}
	
	@Test(priority=4)
	public void sendingMessageTest() {
		String msg = oneToGroupChat.sendTextMessage(prop.getProperty("automatedMessage"));
		System.out.println(msg);
		Assert.assertEquals(msg, Constants.SENT_MESSAGE_CHECK);	
	}
	
	@Test(priority=5)
	public void attachImageFromGalleryTest() {
		String imgName = oneToGroupChat.attachImgThroughGallery();
		System.out.println(imgName);
		Assert.assertEquals(imgName, Constants.SENT_IMAGE_FROM_GALLERY);
	}
	
	@Test(priority=6)
	public void attachPDFfromFileOptionTest() throws InterruptedException {
		String fileName = oneToGroupChat.attachPDFThroughFile();
		System.out.println(fileName);
		Assert.assertEquals(fileName, Constants.SENT_PDF_FROM_FILEOPTION);
	}

	@Test(priority=7)
	public void attachCapturedImageTest() throws InterruptedException {
			String capImageName = oneToGroupChat.captureImageFromCamera();
			System.out.println(capImageName);
			Assert.assertEquals(capImageName, Constants.SENT_CAPT_IMAGE_NAME);
	}
	
	@Test(priority=8)
	public void attachCapturedVideoTest() throws InterruptedException {
			String capVideoName = oneToGroupChat.captureVideoFromCamera();
			System.out.println(capVideoName);
			Assert.assertEquals(capVideoName, Constants.SENT_CAPT_VIDEO_NAME);
	}
	
	@Test(priority=10)
	public void attachImgForForward() throws InterruptedException {
		String imgName = oneToGroupChat.attachImgForForward();
		System.out.println(imgName);
		Assert.assertEquals(imgName, Constants.SENT_IMAGE_FOR_FORWARD);
	}
	
	@Test(priority=11)
	public void popUpLaunchTest() throws InterruptedException {
		String popupHeader = oneToGroupChat.forwardOptionPop();
		System.out.println(popupHeader);
		Assert.assertEquals(popupHeader, Constants.FORWARD_POPUP_HEADER);
	}
	
	@Test(priority=12)
	public void defaultForwardOptionTest() {
		String defaultChk = oneToGroupChat.defaultFWDCheck();
		System.out.println(defaultChk);
		Assert.assertEquals(defaultChk, Constants.FORWARD_DEFAULT_CHECKED);
	}
	
	@Test(priority=13)
	public void uncheckForwardButtonTest() throws InterruptedException {
		String uncheckStatus = oneToGroupChat.unCheckForwardOption();
		System.out.println(uncheckStatus);
		Assert.assertEquals(uncheckStatus, Constants.FORWARD_DISABLED_STATUS);
	}
		
	@Test(priority=14)
	public void sendNonForwardableFileTest() throws InterruptedException {
		String fileFwdname = oneToGroupChat.sendNonForwardableFile();
		System.out.println(fileFwdname);
		Assert.assertEquals(fileFwdname, Constants.SENT_NON_FORWARD_FILE);
	}
	
	@Test(priority=15)
	public void forwardBtnHiddenTest() throws InterruptedException {
		boolean val = oneToGroupChat.checkFileNonForwardable();
		Assert.assertFalse(val);
	}
	
}
