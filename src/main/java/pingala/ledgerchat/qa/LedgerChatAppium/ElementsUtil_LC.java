package pingala.ledgerchat.qa.LedgerChatAppium;

import java.sql.DriverAction;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class ElementsUtil_LC {
	
	//private AndroidDriver driver;
	private AppiumDriver driver;

	public ElementsUtil_LC(AppiumDriver driver) {
		this.driver = driver;

	}  
	
	public static By getBy(String locatorType, String locatorValue) {

		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = AppiumBy.id(locatorValue);
			break;
	
		case "accessibiltyid":
			locator = AppiumBy.accessibilityId(locatorValue);
			break;
			
		case "xpath":
			locator = AppiumBy.xpath(locatorValue);
			break;
			
		default:
			break;
		}
		return locator;
	}

	
	/**Method is used to Find the WebElement
	 * @param locator
	 * @return - WebElement
	 */
	
	public WebElement getFindElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**Method is used to SendKeys to a field 
	 * @param By locator, String which we are passing to the field 
	 * @return - NIL
	 */
	public void doSendKeys(By locator, String value) {
		getFindElement(locator).sendKeys(value);
	}
	
	/**Method is used to SendKeys using String By Locator 
	 * @param By locator, String which we are passing to the field 
	 * @return - NIL
	 */

	public  void doSendKeys(String locatorType, String locatorValue, String value){
		getFindElement(getBy(locatorType,locatorValue)).sendKeys(value);
	}
	
	/**Method is used to Click a field/button 
	 * @param By locator 
	 * @return - NIL
	 */
	
	public void doClick(By locator) {
		getFindElement(locator).click();
		
	}
	
	
	public boolean doIsEnabled (By locator) {
		return getFindElement(locator).isEnabled();
	}
	
	
	
	/**
	 * Getting Web Elements from a page
	 * @return List WebElements
	 */
	public List<WebElement> getElementsList(By locator)	{
		
		return driver.findElements(locator);
	}
	
	
	/**
	 * Getting Web Elements Label names
	 * @param locator
	 * @return List of WebElements label names
	 */
	
	public void doClickFromList(By locator, String textName) {
		
		List<WebElement> usrname = getElementsList(locator);
		for (WebElement e :usrname)
		{
			String attrVal = e.getText();	
			if (attrVal.contains(textName))
			{
				e.click();
			
				break;
			}
			
		}
}
		

	public String doGetText(By locator) {
		
		return getFindElement(locator).getText();
	
	}
	
	//********************************Wait-Utils*************************************************************/
		/*
		 * An expectation for checking an element is visible and enabled such that you can click it
		 * @param locator
		 * @param timeout
		 */
		
		 public void clickWhenReady(By locator, int timeout) {
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			 wait.until(ExpectedConditions.elementToBeClickable(locator));
		 }
	
		 /**An expectation for checking that an element is present on the DOM of a page. This does not
	   	   necessarily mean that the element is visible.
		 * @param locator
		 * @param timeout
		*/
		
		public WebElement waitForElementPresence(By locator, int timeout) {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		}
		
		public void waitForElementPresentAndClick(By locator, int timeout) {
			
			waitForElementPresence(locator, timeout).click();
		
		}
		
		
		public String waitForElementGetText(By locator, int timeout) {
			String elemText = waitForElementPresence(locator,timeout).getText();
			return elemText;
		}
		
	
		
		 /**
		   * An expectation for checking that an element is present on the DOM of a page and visible.
		   * Visibility means that the element is not only displayed but also has a height and width that is
		   * greater than 0.
		   * Default pollingTime = 0.5 Sec
		   * @param locator used to find the element
		   * @return the WebElement once it is located and visible
		   */
			
		public WebElement waitForElementVisiblity(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		
		public void waitForElementVisiblityandClick(By locator, int timeout) {
			
			waitForElementVisiblity(locator, timeout).click();
		
		}
		
		 /**
		   * An expectation for checking that an element is present on the DOM of a page and visible.
		   * Visibility means that the element is not only displayed but also has a height and width that is
		   * greater than 0.
		   * Default pollingTime = Customized
		   * @param locator used to find the element
		   * @return the WebElement once it is located and visible
		   */
		public WebElement waitForElementVisiblityPollTime(By locator, int timeout, int pollingTime) {
			WebDriverWait wait = new WebDriverWait(driver,
					Duration.ofSeconds(timeout),Duration.ofSeconds(pollingTime));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
				
		/**
		 * wait Method for the Page title to load.	 *
		 * @param titleVal The value to be contained in the page title.
		 * @param timeout The maximum time to wait for the condition, in seconds.
		 * @return True if the page title contains the specified value within the given timeout, 
		 * false otherwise.
		 */
		
		public boolean waitForPageTitle(String titleVal, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.titleContains(titleVal));
		}
		
		/**
		 * Method to get the Page title until the page loads.
		 * @param titleVal The expected page title.
		 * @param timeout The maximum time to wait for the page title, in seconds.
		 * @return The page title if found within the timeout; otherwise, null.
		 */
		public String goGetPageTitleWait(String titleVal, int timeout) {
			if (waitForPageTitle(titleVal, timeout)) {
				return driver.getTitle();
			}
			return null;
		}
		
		/**
		 * Method to get the Page URL in "Fraction value"
		 * @param urlFration The fraction of the URL to be contained.
		 * @param timeout The maximum time to wait for the URL fraction, in seconds.
		 * @return The current URL if the specified fraction is contained within the timeout; otherwise, null.
		 */
		public String waitForURLContains(String urlFration, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			if(wait.until(ExpectedConditions.urlContains(urlFration))){
				return driver.getCurrentUrl();
			}
			return null;
		}
		
		public String waitForURLToBe (String url, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			if (wait.until(ExpectedConditions.urlToBe(url))) {
				return driver.getCurrentUrl();
			}
			return null;
			
		}
		
		public void waitForElementDisplayed(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		
		public boolean waitForElementNotVisiblity(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			
			}
		
		public boolean waitForInvisibilityText(By locator, int timeout, String compText) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			
			return wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, compText));
		}
		

		public boolean waitForElementNotVisiblityText(By locator, int timeout, String compText) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			
			String text = waitForElementGetText(locator,timeout);
			if(text.equals(compText)) {
				return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
				
			}
			return false;
		}
		
		
		
		/* 
		 * ___________________________Wait-WebElementsList_________________________________
		 */
		
		/*
		 * An expectation for checking that there is at least one element present on a web page.
		 * @param locator
		 * @param timeout
		 * @return List of WebElements
		 */
		
		public List<WebElement> waitForWebElementsPresence(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
		}
		

		public void doWaitAndClickFromList(By locator, String textName, int timeout) {
			
			List<WebElement> usrname = waitForWebElementsPresence(locator,timeout);
			for (WebElement e :usrname)
			{
				String attrVal = e.getText();	
				if (attrVal.contains(textName))
				{
					e.click();
				
					break;
				}
				
			}
		}
		
		/*
		 * Windows*********************Action KEys*************************
		 */
		
		public void doActionsEscape() {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ESCAPE);
		}
		
		public void doActionsClearField() {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.CLEAR);
		}
		
		public void doLongPress(WebElement locator) {
		
		
		}
		
		
	/*
	 * ********************* Appium - Gestures **************** 
	 */
		public Dimension getScreenSize() {
			return driver.manage().window().getSize();
		}

		
		public Point getCenterOfElement(Point location, Dimension size) {
			// TODO Auto-generated method stub
			return new Point(location.getX() + size.getWidth()/2, 
					         location.getY() + size.getHeight()/2);
			
		}
		
		public void longPressElement(AndroidDriver driver, By element) {
				Point location = ((WebElement) element).getLocation();
				Dimension size  = ((WebElement) element).getSize();
				getCenterOfElement(location, size);
				
				Point centerOfElement = getCenterOfElement(location, size);
				
				PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
				Sequence sequence = new Sequence(finger1, 0);
				sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement));
				sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
				sequence.addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), centerOfElement));
				sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
				//driver.perform(ImmutableList.of(sequence));
				driver.perform(Collections.singletonList(sequence));
				
		}

		
	
}
