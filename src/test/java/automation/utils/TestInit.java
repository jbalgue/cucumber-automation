package automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import automation.pojo.UserCredentials;

/**
 * When running a feature file, this class (<b>TestInit.class</b>)
 * will run on top of StepDef classes to load some other classes,
 * like web drivers etc.</br>
 * 
 * Additional objects that needs to be initialize before some StepDef classes,
 * should be placed here.
 * 
 * @author julius.balgue
 *
 */
public class TestInit {
	
	private WebDriver driver =  null;
	private ElementUtil elementUtil =  null;
	private TestDataConfigUtil config = null;
	private String environmentUrl = "";
	private UserCredentials userCredentials;
	
	public TestInit() throws Exception { 
		System.out.println(">>>>>>>>>>>>>>>>>>>> Initializing TestInit <<<<<<<<<<<<<<<<<<<<");
		this.config = TestDataConfigUtil.getTestDataConfig();
		this.driver = new DriverManager().getDriver();
		if (this.driver == null) {
			throw new Exception("Driver instance is null");
		}

		//Set Environment
		String env = this.config.getConfig("environment");
		this.environmentUrl = getEnvURL(env);
		
		//Set user
		UserCredentials uc = new UserCredentials();
		uc.setFreeUser(this.config.getConfig("email"));
		uc.setFreePass(this.config.getConfig("password"));
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();

		this.userCredentials = uc;
		this.elementUtil = new ElementUtil(this);
	}
	
	private String getEnvURL(String env) {
		return this.config.getConfig(env + ".environment.url");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public ElementUtil getElementUtil() {
		return elementUtil;
	}

	public void setElementUtil(ElementUtil elementUtil) {
		this.elementUtil = elementUtil;
	}

	public TestDataConfigUtil getConfig() {
		return config;
	}

	public void setConfig(TestDataConfigUtil config) {
		this.config = config;
	}

	public String getEnvironmentUrl() {
		return environmentUrl;
	}

	public void setEnvironmentUrl(String environmentUrl) {
		this.environmentUrl = environmentUrl;
	}
	
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	
}
