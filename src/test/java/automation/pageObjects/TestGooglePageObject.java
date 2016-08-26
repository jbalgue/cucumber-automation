package automation.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation.utils.ElementUtil;
import automation.utils.ObjectReference;
import automation.utils.TestInit;

public class TestGooglePageObject extends ObjectReference {
	private WebDriver driver = null;
	private ElementUtil elementUtil = null;
	private TestInit ti = null;
	private static final Logger logger = LoggerFactory.getLogger(TestGooglePageObject.class);

	public TestGooglePageObject(TestInit ti) {
		this.driver = ti.getDriver();
		this.elementUtil = ti.getElementUtil();
		this.ti = ti;
	}

	public void goToGoogle(String url) {
		String redirectTo = url.replace("{serverUrl}", ti.getEnvironmentUrl());
		driver.navigate().to(redirectTo);
		logger.info("Redirected to Google site");
	}

	public void checkLogo() throws InterruptedException {
		Assert.assertTrue("UNAVAILABLE Google Logo", elementUtil.isElementAvailabe(GOOGLE_LOGO));
		logger.info("Google logo is available");
	}
}
