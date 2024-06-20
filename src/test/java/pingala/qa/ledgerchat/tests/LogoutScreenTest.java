package pingala.qa.ledgerchat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pingala.qa.ledgerechat.contantutils.Constants;

public class LogoutScreenTest extends BaseTest {
	
	@Test(priority=0)
	public void logoutScreensetup() {

		logout = loginScreen.logOutTestLogin(prop.getProperty("LogOutTestUser").trim(),
				prop.getProperty("LogOutTestUserPwd").trim());
	}
	
	
	@Test
	public void clickBurgerIconTest() {
		String usrName = logout.clickBurgerIcon();
		System.out.println("userName:" + usrName);
		Assert.assertEquals(usrName, Constants.SEARCH_SELECTED_USER);
	}
	
	@Test
	public void clickLogoutTest() {
		String alertText = logout.clicklogout();
		System.out.println("AlertText:" + alertText);
	}

	@Test
	public void logoutTest() {
		logoutScreen.clickBurgerIcon();
		String signInLabel = logout.logoutOk();
		System.out.println(signInLabel);
		Assert.assertEquals(signInLabel, "Sign in");
	}
}
