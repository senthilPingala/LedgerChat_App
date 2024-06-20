package pingala.qa.ledgerchat.tests;

import java.net.MalformedURLException;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import pingala.ledgerchat.qa.LedgerChatAppium.DriverCapablities;
import pingala.qa.ledgerchat.screens.OneToOneChatWindow;
import pingala.qa.ledgerchat.screens.DataManagementScreen;
import pingala.qa.ledgerchat.screens.ForwardOneToOne;
import pingala.qa.ledgerchat.screens.HumBurgerIconScreen;
import pingala.qa.ledgerchat.screens.LoginScreen;
import pingala.qa.ledgerchat.screens.LogoutScreen;
import pingala.qa.ledgerchat.screens.OneToGroupChatScreen;
import pingala.qa.ledgerchat.screens.ProfileScreen;
import pingala.qa.ledgerchat.screens.SendTexttoUser;

public class BaseTest {

	@SuppressWarnings("rawtypes")
	DriverCapablities dc;
	//AndroidDriver driver;
	AppiumDriver driver;
	Properties prop;
	
	//Page Reference
	LoginScreen loginScreen;
	HumBurgerIconScreen humBurgerPanel;
	LogoutScreen logoutScreen;
	ProfileScreen profileScreen;
	OneToOneChatWindow oneToOneChat;
	OneToGroupChatScreen oneToGroupChat;
	ForwardOneToOne forwardOneToOne;
	DataManagementScreen dataManagement;
	SendTexttoUser sendTextToUser;
	LogoutScreen logout;

	

	@BeforeTest
	public void setUp() throws MalformedURLException {
		dc = new DriverCapablities();
		prop = dc.init_prop();
		driver = dc.init_ServiceCapablities(prop);
		loginScreen = new LoginScreen(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
}
