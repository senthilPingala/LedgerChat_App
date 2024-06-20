package pingala.qa.ledgerchat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pingala.qa.ledgerechat.contantutils.Constants;

public class SendTexttoUserTest extends BaseTest {

	
	@Test(priority=0)
	public void profileScreensetup() {

		sendTextToUser = loginScreen.sendTestMessageScreenLogin(prop.getProperty("devUserKarthiFour").trim(),
				prop.getProperty("devUserKarthiFourPwd").trim());
	}
	
	
	@Test(priority=1)
	public void searchUserTest() {
		String selectedUser = sendTextToUser.searchActiveUser(prop.getProperty("searchFirstName"));
		System.out.println(selectedUser);
		Assert.assertEquals(selectedUser, Constants.SEARCH_SELECTED_USER);
	}
	
	@Test(priority=2)
	public void backtoHomeScreenTest() {
		String homeSrnLabel = sendTextToUser.backToHomePage();
		System.out.println(homeSrnLabel);
		Assert.assertEquals(homeSrnLabel, Constants.LEDGERCHAT_HOMESCRN_LABEL);
	}

	@Test(priority=3)
	public void searchBlockedUsrTest() {
		String emptyListText = sendTextToUser.searchBlockedUser(prop.getProperty("BlockedUserName"));
		System.out.println(emptyListText);
		Assert.assertEquals(emptyListText, Constants.EMPTY_USER_SEARCHLIST);
	}
	
	
}
