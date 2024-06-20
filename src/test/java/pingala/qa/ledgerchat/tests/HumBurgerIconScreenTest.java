package pingala.qa.ledgerchat.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

//import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import pingala.qa.ledgerechat.contantutils.Constants;

public class HumBurgerIconScreenTest extends BaseTest {
	
	@Test(priority=0)
	public void humBurgerScreensetup() {
		//loginScreen.allowPermission();
		humBurgerPanel = loginScreen.init_login(prop.getProperty("humBurgerTestUsr").trim(),
				prop.getProperty("humBurgerUsrPwd").trim());
	}
	
	
	@Test(priority=2)
	public void humBurgerSectionTest() {
		humBurgerPanel.clickBurgerIcon();
		String name = humBurgerPanel.clickBurgerIcon();
		System.out.println(name);
		Assert.assertEquals(name, Constants.HUMBURGER_PROFILE_NAME);
	}
	
	
	@Test(priority=3)
	public void printEmailText() {
		String emailId = humBurgerPanel.printEmail();
		System.out.println("EmailID:" + emailId);
		Assert.assertEquals(emailId, Constants.LOGGED_USER_EMAIL_ID);
	}
	
	@Test(priority=3)
	public void printchatListText() {
		String chatList = humBurgerPanel.printchatList();
		System.out.println("PhatList:" + chatList);
		Assert.assertEquals(chatList, Constants.CHATLIST_LABEL);
	}
	
	@Test(priority=4)
	public void printProfileScrnText() {
		String profile = humBurgerPanel.printProfileScrn();
		System.out.println("Profile:" + profile);
		Assert.assertEquals(profile,Constants.PROFILE_LABEL);
	}
	
	@Test(priority=5)
	public void printDataManagementText() {
		String dataManagement = humBurgerPanel.printDataManagement();
		System.out.println("DataManagement:" + dataManagement);
		Assert.assertEquals(dataManagement,Constants.DATA_MANAGEMENT_LABEL);
	}

	@Test(priority=6)
	public void printLogoutText() {
		String logOut = humBurgerPanel.printLogout();
		System.out.println("LogOut:" + logOut);
		Assert.assertEquals(logOut,Constants.LOGOUT_LABEL);
	}

}
