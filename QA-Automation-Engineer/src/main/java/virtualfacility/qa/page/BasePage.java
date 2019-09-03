package virtualfacility.qa.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utility.UtilityPage;

public class BasePage {

	public static Logger logger;
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public Properties configProp;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Actions action;
	public static WebDriverWait wait;

	public WebDriver getDriver() {
		return driver;
	}

	public BasePage() {
		logger = Logger.getLogger("Virtual Facility"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");// Added logger
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "./src/main/java/virtualfacility/config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unlikely-arg-type" })
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			logger.info("******** I am a chrome browser*********");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new EventFiringWebDriver(new ChromeDriver(options));

		} else if (browserName.equals("headless")) {
			logger.info("******** I am a headless mode chrome browser*********");
			String chromeDriverPath = "./Driver/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("ie")) {
			logger.info("******** I am a ie browser*********");
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains().equals(true);
			ieOptions.requireWindowFocus().equals(true);
			ieOptions.ignoreZoomSettings().equals(true);
			ieOptions.enableNativeEvents().equals(false);
			ieOptions.enablePersistentHovering().equals(true);
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver(ieOptions);

		} else if (browserName.equals("edge")) {
			logger.info("******** I am a edge browser*********");
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(UtilityPage.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityPage.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));

	}
}
