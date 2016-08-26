package automation.utils;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementUtil  extends ObjectReference {
	protected WebDriver driver = null;
	private static final Logger logger = LoggerFactory.getLogger(ElementUtil.class);
	
	public ElementUtil(TestInit ti) {
		this.driver = ti.getDriver();
	}
	
	/**
	 * Waits for a specific element. Has a 13 seconds timeout.
	 * @param by
	 * @throws InterruptedException
	 */
	public void waitForElementPresent(By by) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 15)
				break;
			if (isElementPresent(by))
				break;
			Thread.sleep(1000);
		}
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			// Do nothing 
		}
		return false;
	}

	public String getText(By by) {
		String value = driver.findElement(by).getText();
		return value;
	}

	public String getValue(By by) {
		String value = "";
		if (isElementPresent(by)) {
			value = driver.findElement(by).getAttribute("value");
		}
		return value;
	}

	public void type(By by, String value) throws InterruptedException {
		try {
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (Exception e) {
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		}
	}
	
	public boolean isElementVisible(final By by) throws InterruptedException {
		boolean value = false;
		waitForElementPresent(by);
		if (driver.findElement(by).isDisplayed()) {
			value = true;
		}
		return value;
	}
	
	/**
	 * Checks if element is available and clicks it when it's visible
	 * @param element
	 * @return True or False. If element is clicked/visible
	 * @throws InterruptedException
	 */
	public boolean isClickedElementAvailable(String element) throws InterruptedException {
		boolean passed = false;
		By avaibleElement = By.xpath(element);
		if (!isElementAvailabe(element)) {
			logger.info("Element is not available");
			passed = false;
		} else {
			driver.findElement(avaibleElement).click();
			passed = true;
		}
		return passed;
	}
	
	/**
	 * Check if the element is available.
	 * @param element
	 * @return True or False. If element is available on the page
	 * @throws InterruptedException
	 */
	public boolean isElementAvailabe(String element) throws InterruptedException {
		boolean isAvailable = false;
		By avaibleElement = By.xpath(element);

		if (!isElementPresent(avaibleElement)) {
			waitForElementPresent(avaibleElement);
			Assert.assertTrue(element + " is not available.", isElementPresent(avaibleElement));
			isAvailable = true;
		} else if (isElementPresent(avaibleElement)) {
			Assert.assertTrue(isElementPresent(avaibleElement));
			isAvailable = true;
		}

		return isAvailable;
	}
	
	public boolean hoverElement(String xPath) throws InterruptedException {
		boolean pass = false;
		By hoverElement = By.xpath(xPath);
		if (isElementAvailabe(xPath)) {
			Actions actions = new Actions(driver);
			WebElement mainMenu = driver.findElement(hoverElement);
			actions.moveToElement(mainMenu).click().build().perform();
			pass=true;
		}
		return pass;
	}
	
	/**
	 * It will wait for the page to load and all its elements
	 * @param driver
	 * @param timeInMills
	 */
	public void waitForPageToLoad(WebDriver driver, long timeInMills) {
		driver.manage().timeouts().implicitlyWait(timeInMills, TimeUnit.MILLISECONDS);
	}
}
	