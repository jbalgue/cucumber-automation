package automation.utils;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;

public class DriverManager {
	public WebDriver getDriver() throws Exception {
		
		WebDriver driver = null;
		TestDataConfigUtil config = TestDataConfigUtil.getTestDataConfig();

		boolean automateOnBrowserStack = Boolean.parseBoolean(config.getConfig("automate.on.browserstack"));
		if (automateOnBrowserStack) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			boolean testOnMobile = Boolean.parseBoolean(config.getConfig("bs.test.on.mobile"));// Determines whether to test on desktop or mobile

			if (testOnMobile) {
				capabilities.setCapability("browserName", config.getConfig("bs.mobile.browser.name"));
				capabilities.setPlatform(Platform.MAC);
				capabilities.setCapability("device", config.getConfig("bs.mobile.device"));
			} else {
				capabilities.setCapability("browser", config.getConfig("bs.browser"));
				capabilities.setCapability("browser_version", config.getConfig("bs.browser.version"));
				capabilities.setCapability("os", config.getConfig("bs.os"));
				capabilities.setCapability("os_version", config.getConfig("bs.os.version"));
				
				String browserResolution = config.getConfig("bs.resolution");
				if (browserResolution != null && !browserResolution.equals("")) {
					capabilities.setCapability("resolution", browserResolution);
				}
			}

			capabilities.setCapability("browserstack.debug", config.getConfig("bs.debug"));
			capabilities.setCapability("build", config.getConfig("bs.build"));
			capabilities.setCapability("project", config.getConfig("bs.project"));

			String browserStackURL = "http://" + config.getConfig("bs.username") + ":" + config.getConfig("bs.automate.key") + "@hub.browserstack.com/wd/hub";
			driver = new RemoteWebDriver(new URL(browserStackURL), capabilities);
		} else {
			String useBrowser = config.getConfig("browser");
			System.out.println(">>>>>>>>>>>>>>>>>>>> Browser: " + useBrowser.toUpperCase());
			if (useBrowser.toLowerCase().equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", config.getConfig("chromeDriverPath"));
				driver =  ThreadGuard.protect(new ChromeDriver());
			} else if (useBrowser.toLowerCase().equals("firefox")) {
				driver =  ThreadGuard.protect(new FirefoxDriver());
			} else if (useBrowser.toLowerCase().equals("safari")) {
				driver = ThreadGuard.protect(new SafariDriver());
			} else if (useBrowser.toLowerCase().equals("ie")) {
				driver = ThreadGuard.protect(new InternetExplorerDriver());
			} else {
				throw new RuntimeException("Unsupported webdriver: " + useBrowser);
			}
		}

		return driver;
	}
}
