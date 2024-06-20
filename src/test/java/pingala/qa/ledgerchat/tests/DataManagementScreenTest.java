package pingala.qa.ledgerchat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pingala.qa.ledgerechat.contantutils.Constants;

public class DataManagementScreenTest  extends BaseTest {
	
		@Test(priority=0)
		public void dataManagementScreensetup() {

			dataManagement = loginScreen.dataManagementLogin(prop.getProperty("dataManagementUsr").trim(),
					prop.getProperty("dataManagementPwd").trim());
		}
		
		
		@Test(priority=1)
		public void humBurgerSectionTest() {
			String userprofileName = dataManagement.clickHumBurgerIcon();
			System.out.println(userprofileName);
			Assert.assertEquals(userprofileName, Constants.PROFILE_HUMBUR_SECTION);
		}
				
		@Test(priority=2)
		public void dataManagementPanelTest() {
			String dm_title = dataManagement.doClickOnDataManagement();
			System.out.println("title:" + dm_title);
			Assert.assertEquals(dm_title, Constants.DATAMANAGE_PANEL_HEADER);
		}
		
		@Test(priority=3)
		public void defaultPurgeSectionTest() {
			String purgeInfo = dataManagement.doGetPurgeInfo();
			System.out.println("Purge Content:" + purgeInfo);
			Assert.assertEquals(purgeInfo, Constants.LOGGED_USER_KUMAR_NAME);
		}
			
		@Test(priority=4)
		public void setPurgeDateTest() {
			dataManagement.purgeDateSelection(prop.getProperty("purgeMonth"), prop.getProperty("purgeDate"), prop.getProperty("purgerYear"));
			
		}
	


}
