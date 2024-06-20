package pingala.qa.ledgerchat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pingala.qa.ledgerchat.screens.ForwardOneToOne.scrollDirection;
import pingala.qa.ledgerechat.contantutils.Constants;

public class ForwardOneToOneTest extends BaseTest {
	
	@Test(priority=0)
	public void oneToOneChatSetup() throws InterruptedException {
		
		Thread.sleep(5000);
		forwardOneToOne = loginScreen.forwardFileOneUserLogin(prop.getProperty("forwardToUserLogin").trim(),
				prop.getProperty("forwardToUserPwd").trim());
		forwardOneToOne.scroll(scrollDirection.UP, 0.75);
	}
	
	
	@Test(priority=1)
	public void openChatWindowTest() {
		String chatUser = forwardOneToOne.openSingleUserToChat(prop.getProperty("openUsrForFileFwd"));
		System.out.println(chatUser);
		Assert.assertEquals(chatUser, Constants.SELECTED_USER_FORWARD);
	}
	
	@Test(priority=2)
	public void longPressTest() {
		boolean fwdIConPresent = forwardOneToOne.checkForwardable();
		Assert.assertTrue(fwdIConPresent);
	}
	
	@Test(priority=3)
	public void forwardScreenLaunchTest() {
		String fwdLabel = forwardOneToOne.clickForwardButton();
		Assert.assertEquals(fwdLabel, Constants.FORWARD_SCREEN_HEADER);
	}
	
	@Test(priority=4)
	public void selectUsrForForwardTest() throws InterruptedException {
		String counttext = forwardOneToOne.forWardFileTo(prop.getProperty("forWardToUser"), prop.getProperty("forwardToGroup"));
		Assert.assertEquals(counttext.trim(), Constants.FORWARD_SELECTED_COUNT);
	}
	
	@Test(priority=5)
	public void forwardFileSuccessTest() {
		String fwdSuccessful = forwardOneToOne.forwardFileToUser().trim();
		Assert.assertEquals(fwdSuccessful, Constants.FORWARD_SUCCESSFUL);
	}
	
	@Test(priority=6)
	public void postForwardScreenFocusTest() {
		String fwdSuccessful = forwardOneToOne.postForwardScreenFocus().trim();
		Assert.assertEquals(fwdSuccessful, Constants.POST_FORWARD_FOCUS);
	}
	
	@Test(priority=7)
	public void backToChatListScreenTest() {
		String fwdSuccessful = forwardOneToOne.backToChatWindow();
		Assert.assertEquals(fwdSuccessful, Constants.LEDGERCHAT_HOMESCRN_LABEL);
	}
	
	@Test(priority=8)
	public void openForwardedUsrTest() {
		String chatUser = forwardOneToOne.openForwardToUserChat(prop.getProperty("forWardToUser"));
		System.out.println(chatUser);
		Assert.assertEquals(chatUser, Constants.FILE_FORWARDED_USER);
	}
	
	@Test(priority=9)
	public void checkingForwardedFileNameTest() {
		String FileName = forwardOneToOne.checkingForwardedFileInUser();
		System.out.println(FileName);
		Assert.assertEquals(FileName, Constants.SENT_IMAGE_FOR_FORWARD);
	}
	
	@Test(priority=10)
	public void forwardedLabelForFileTest() {
		String labelName = forwardOneToOne.forwardedLabelForFileCheck();
		System.out.println(labelName);
		Assert.assertEquals(labelName, Constants.FORWARDED_LABEL);
	}
	
	@Test(priority=11)
	public void openForwardedGroupTest() {
		String chatGroup = forwardOneToOne.openForwardToGroupChat(prop.getProperty("forwardToGroup"));
		System.out.println(chatGroup);
		Assert.assertEquals(chatGroup, Constants.FILE_FORWARDED_GROUP);
	}
	
	@Test(priority=12)
	public void replyToViewTest() {
		boolean aniView = forwardOneToOne.replyToFileAttached();
		Assert.assertTrue(aniView);
	}
	
	@Test(priority=13)
	public void sendingMessageTest() {
		String replyMsg = forwardOneToOne.doReplytoFileAttached(prop.getProperty("repliedMessage"));
		System.out.println(replyMsg);
		Assert.assertEquals(replyMsg, Constants.SENT_REPLY_MESSAGE);	
	}

	
	
}
