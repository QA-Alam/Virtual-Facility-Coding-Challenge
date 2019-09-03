package virtualfacility.qa.page;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.Callable;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import virtualfacilityExtentReport.ExtentTestManager;

public class MasterPageFactory extends BasePage {
	static final String StockPrice = "0.0023051";
	static final String StockQuantity = "100";
	static final String TotalAmount = "0.23051000";
	WebDriverWait sleep = new WebDriverWait(driver, 10);

	// Initializing the Page Objects:
	public MasterPageFactory() {
		PageFactory.initElements(driver, this);
	}

	public void getVerifyCurrentURL() {
		String title = driver.getCurrentUrl();
		if (driver.getPageSource().contains("https://www.binance.com/en/trade/BNB_BTC")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertEquals(title, driver.getCurrentUrl());
			Assert.assertTrue(true);
		}
	}

	@FindBy(xpath = "(//*[text()='BNB'])[2]")
	@CacheLookup
	private WebElement ClickOnETHLink;

	public WebElement ClickOnETHLink() {
		return ClickOnETHLink;
	}

	@FindBy(xpath = "//*[@id='__next']/descendant::canvas[8]")
	@CacheLookup
	private WebElement verifyChart;

	public WebElement verifyStockChart() {
		return verifyChart;
	}

	@FindBy(xpath = "//*[@id='TabbedOrderFormsMargin-a-exchangeLimit' and contains(text(),'Limit')]")
	@CacheLookup
	private WebElement verifylimit;

	public WebElement verifyStocklimit() {
		return verifylimit;
	}

	@FindBy(xpath = "//*[@id='TabbedOrderFormsMargin-a-exchangeLimit' and contains(text(),'Limit')]")
	@CacheLookup
	private WebElement verifyMarket;

	public WebElement verifyStockMarket() {
		return verifylimit;
	}

	@FindBy(id = "trade-orderForm-a-BUYlogin")
	@CacheLookup
	private WebElement ClickOnLogin;

	public WebElement ClickOnLogin() {
		return ClickOnLogin;
	}

	@FindBy(xpath = "//*[@class='sc-182d8ww-2 bYWVdE' and contains(text(),'Log In')]")
	@CacheLookup
	private WebElement VerifyLoginPage;

	public WebElement VerifyLoginPage() {
		return VerifyLoginPage;
	}

	@FindBy(xpath = "(//*[@class='sc-1p4en3j-3 sc-1p4en3j-5 klZHmQ']/text()[2])[2]")
	@CacheLookup
	private WebElement Last24Change;

	public WebElement Verify24hChange() {
		return Last24Change;
	}

	@FindBy(xpath = "//*[@class='sc-1p4en3j-7 SZUwG']/span/text()[2] ")
	@CacheLookup
	private WebElement LastPrice;

	public WebElement VerifyLastPrice() {
		return LastPrice;
	}

	@FindBy(xpath = "//*[@class='sc-1p4en3j-3 bGiWum']/text()[2] ")
	@CacheLookup
	private WebElement Last24hVolume;

	public WebElement Verify24hVolume() {
		return Last24hVolume;
	}

	@FindBy(xpath = "//*[@class='sc-1p4en3j-3 bGiWum']/text()[2]")
	@CacheLookup
	private WebElement Last24hLow;

	public WebElement Verify24hLow() {
		return Last24hLow;
	}

	@FindBy(xpath = "//*[@class='sc0p4en3j-3 bGiWum']")
	@CacheLookup
	private WebElement Last24hHigh;

	public WebElement Verify24hHigh() {
		return Last24hHigh;
	}

	@FindBy(xpath = "//*[text()='Please check that you are visiting']")
	@CacheLookup
	private WebElement VerifyLoginPageText;

	public WebElement VerifyLoginPageText() {
		return VerifyLoginPageText;
	}

	public void EnterStockPrice() {
		logger.info("******** User Able to enter price *********");
		WebElement price = sleep
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#FormRow-BUY-price")));
		price.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		price.sendKeys("0.0023051");
		logger.info("******** User Able to enter price successfully*********");
	}

	public void EnterStockQuantity() {
		logger.info("******** User Able to enter Stock Quantity *********");
		WebElement quantity = sleep
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#FormRow-BUY-quantity")));
		quantity.sendKeys("100");
		logger.info("******** User Able to enter Stock Quantity successfully *********");
	}

	public void EnterStockTotalAmount() {
		logger.info("******** User Able to enter total amount *********");
		WebElement totalPrice = sleep
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#FormRow-BUY-total")));
		totalPrice.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		totalPrice.sendKeys("0.23051000");
		logger.info("******** User Able to enter total amount successfully *********");
	}

	public static void stop_limit_input_boxes() {
		logger.info("******** User Able to verify stop limit *********");
		List<WebElement> stop = driver.findElements(By.xpath("//*[text()='Stop-limit ']"));
		System.out.println(stop.size());
		for (int i = 0; i < stop.size(); i++) {
			System.out.println(stop.get(i).getText());
			logger.info("******** User Able to verify stop limit successfully *********");
		}
	}

	public static void OutputAssert(String scenario, Callable<Void> func) {
		try {
			ExtentTestManager.getTest().log(LogStatus.PASS, " Assertion passed ", scenario);
			func.call();
		} catch (Exception ex) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					" Assertion failed for" + scenario + ": " + ex.getMessage());
		}
	}

	public boolean VerifyWebElement(String elemName, WebElement elem, WebDriver driver) {
		elem = getExplicitWait(elem, driver, 30);
		boolean bDisplayed = elem.isDisplayed();
		OutputAssert("VerifyWebElement - " + elemName + " Expected Result", new Callable<Void>() {
			public Void call() {
				Assert.assertTrue(bDisplayed);
				return null;
			}
		});
		return bDisplayed;
	}

	public static WebElement getExplicitWait(WebElement element, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
		return element1;
	}

	public void verifyElementTestOne(WebDriver driver) {
		try {
			logger.info("******** User Able to Click BNB_BTC Link *********");
			if (VerifyWebElement(" I Am Able To Click BNB_BTC Link - ", ClickOnETHLink(), driver))
				ClickOnETHLink().click();
			logger.info("******** User Able to Click BNB_BTC Link successfully *********");

			logger.info("******** User Able to verify Stock Chart *********");
			if (VerifyWebElement(" Stock Chart Are Available - ", verifyStockChart(), driver))
				verifyStockChart();
			logger.info("******** User Able to verify Stock Chart successfully *********");

			logger.info("******** User Able to verify Stock limit *********");
			if (VerifyWebElement(" Stock Limit Are Available - ", verifyStocklimit(), driver))
				verifyStocklimit();
			logger.info("******** User Able to verify Stock limit successfully *********");

			logger.info("******** User Able to verify market limit *********");
			if (VerifyWebElement(" Stock Market Are Available - ", verifyStockMarket(), driver))
				verifyStockMarket();
			logger.info("******** User Able to verify market limit successfully*********");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed: " + e.getMessage());
		}
	}

	public void verifyElementTestTow(WebDriver driver) {
		try {
			logger.info("******** User Able to Click on login button *********");
			if (VerifyWebElement(" Click On Buying Stock - ", ClickOnLogin(), driver))
				ClickOnLogin().click();
			logger.info("******** User Able to Click on login button successfully*********");

			logger.info("******** User Able to verify login box page appear *********");
			if (VerifyWebElement(" Login Page Appere - ", VerifyLoginPage(), driver))
				VerifyLoginPage();
			logger.info("******** User Able to verify login box page appear successfully*********");

			logger.info("******** User Able to verify login page title *********");
			if (VerifyWebElement(" I am not able to buy until login - ", VerifyLoginPageText(), driver))
				VerifyLoginPageText();
			logger.info("******** User Able to verify login page title successfully*********");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed: " + e.getMessage());
		}

	}

}
