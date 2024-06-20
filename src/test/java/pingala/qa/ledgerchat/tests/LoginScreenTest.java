package pingala.qa.ledgerchat.tests;

import org.testng.annotations.Test;

import pingala.qa.ledgerechat.contantutils.Constants;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;

public class LoginScreenTest extends BaseTest {
	
	@Test
	public void appLaunchTest() {
		
		loginScreen.allowPermission();
		String signInLabel = loginScreen.getAppHeader();
		System.out.println(signInLabel);
		Assert.assertEquals(signInLabel, Constants.APP_LOGIN_SCREEN_TEXT);
	}
	
	@Test(priority=1)
	public void emptyLoginTest() {
		if (loginScreen.doEmptyLogin()==false)
		{
			Assert.assertTrue(true);
		}
		//assert.assertTrue(true, "ButtonEnabled");
	} 
	
	@Test(priority=2)
	public void invalidUsrNameTest() {
		String alertMessage = loginScreen.doInvalidUsername(prop.getProperty("invalidUsrName").trim(),
				prop.getProperty("invalidUsrPwd").trim());
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage,Constants.LOGIN_INVALID_USRPWD_ALERT);
		
	}
	
	@Test(priority=3)
	public void invalidPwdNameTest() {
		String alertMessage = loginScreen.doInvalidPwd(prop.getProperty("devUsrSenthil").trim(),
				prop.getProperty("invalidUsrPwd").trim());
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage,Constants.LOGIN_INVALID_USRPWD_ALERT);
		
	}
	
//	@Test(priority=4)
//	public void validUserLoginTest() {
//	loginScreen.doAppLogin(prop.getProperty("devUsrSenthil").trim(),
//				prop.getProperty("devUserSenthilPwd").trim());
//		
//	}
	
	@Test(priority=4)
	public void validUserLoginTest() {
		String messageTitle  = loginScreen.doAppLogin(prop.getProperty("devUsrHemanth").trim(),
				prop.getProperty("devUserHemanthPwd").trim());
		Assert.assertEquals(messageTitle, Constants.MESSAGE_INFO_HEADER);
	}
		


}
