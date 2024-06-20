package pingala.qa.ledgerchat.tests;

import static org.testng.Assert.assertEquals;

import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pingala.qa.ledgerechat.contantutils.Constants;

public class ProfileScreenTest extends BaseTest {
	
	@Test(priority=0)
	public void profileScreensetup() {

		profileScreen = loginScreen.profileUpdateLogin(prop.getProperty("devUserKarthiFour").trim(),
				prop.getProperty("devUserKarthiFourPwd").trim());
	}
	
	@Test(priority=1)
	public void humBurgerSectionTest() {
		String userprofileName = profileScreen.clickHumBurgerIcon();
		System.out.println(userprofileName);
		Assert.assertEquals(userprofileName, Constants.PROFILE_HUMBUR_SECTION);
	}
	

//	@Test(priority=2)
//	public void burgerIconListTest() {
//		List<String> humBurgerSec = profileScreen.burgerIconList();
//		System.out.println(humBurgerSec);
//		Assert.assertEquals(humBurgerSec, Constants.PROFILE_HUMBUR_SECTION);
//	}
	
	
	
	@Test(priority=2)
	public void clickclickOnProfileTest() {
		String title = profileScreen.clickOnProfile();
		System.out.println("title:" + title);
		Assert.assertEquals(title, Constants.PROFILE_PANEL_HEADER);
	}
	
	@Test(priority=3)
	public void getUserNameTest() {
		String usrName = profileScreen.getUserName();
		System.out.println("UserName:" + usrName);
		Assert.assertEquals(usrName, Constants.LOGGED_USER_KUMAR_NAME);
	}
		
	@Test(priority=4)
	public void getUserEmailTest() {
		String emailId = profileScreen.getUserEmailID();
		System.out.println("EmailID:" + emailId);
		Assert.assertEquals(emailId, Constants.LOGGED_USER_KUMAR_EMAIL_ID);
	}
	
	@Test(priority=5)
	public void privacyPolicyTest() {
		String webDocText = profileScreen.getPrivacyPolicyDoc();
		System.out.println("PrivacyPolicyText:" + webDocText);
		Assert.assertEquals(webDocText, Constants.WEB_PRIVACY_POLICY);
	}
	
	@Test(priority=6)
	public void updatePasswordscreenLaunchTest() {
		String updatePWDHeader = profileScreen.clickUpdatePassword();
		System.out.println("UpdatePasswordText:" + updatePWDHeader);
		Assert.assertEquals(updatePWDHeader, Constants.UPDATE_PWD_HEADER);
	}
	
	@Test(priority=7)
	public void invalidOldPWDTest() {
		String alertmsg = profileScreen.checkInvalidOldPWD(prop.getProperty("updateWrongOldPassword"),
				prop.getProperty("updateNewPwd"),prop.getProperty("updateConfNewPwd"));
		System.out.println("Wrong Old Password Alert:" + alertmsg);
		Assert.assertEquals(alertmsg, Constants.INVALID_OLD_PWD);
	}
	
	@Test(priority=8)
	public void newAndConfPasswordMismatchTest() {
		String pwdMismatch = profileScreen.checkNonMatchingPWD(prop.getProperty("updateOldPWd"),
				prop.getProperty("updateNewPwd"),prop.getProperty("updateWrongConfPwd"));
		System.out.println(pwdMismatch);
		Assert.assertEquals(pwdMismatch, Constants.PWD_MISMATCH_ALERT);
	}
	
	@Test(priority=9)
	public void updatePasswordTest() {
		String updateSuccssful = profileScreen.validPWDUpdate(prop.getProperty("updateOldPWd"),
				prop.getProperty("updateNewPwd"),prop.getProperty("updateConfNewPwd"));
		System.out.println(updateSuccssful);
		Assert.assertEquals(updateSuccssful, Constants.SUCCESSFUL_UPDATE_PWD);
	}
	
	@Test(priority=10)
	public void updatePasswordAutoLogoutTest() {
		String signInText = profileScreen.newPasswordLogincheck();
		System.out.println(signInText);
		Assert.assertEquals(signInText, Constants.APP_LOGIN_SCREEN_TEXT);
	}
	
	@Test(priority=11)
	public void updatePasswordReloginTest() {
		String loggedinCheck = profileScreen.loginUpdatedPWD(prop.getProperty("devUserKarthiFour"),
				prop.getProperty("updateNewPwd"));
		System.out.println(loggedinCheck);
		Assert.assertEquals(loggedinCheck, Constants.MESSAGE_INFO_HEADER);
	}
	
	
//	@Test
//	public void printappVersionText() {
//		String version = profileScreen.printappVersion();
//		System.out.println("Version:" + version);
//	}
//
//	@Test
//	public void clickBack() {
//		String title = profileScreen.back();
//		System.out.println(title);
//		Assert.assertEquals(title, "LedgerChat");
//	}

}
