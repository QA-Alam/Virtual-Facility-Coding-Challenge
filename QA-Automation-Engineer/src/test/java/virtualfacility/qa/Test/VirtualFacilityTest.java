package virtualfacility.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utility.UtilityPage;
import virtualfacility.qa.page.BasePage;
import virtualfacility.qa.page.MasterPageFactory;

public class VirtualFacilityTest extends BasePage {

	MasterPageFactory elementPage;
	UtilityPage testUtil;

	public VirtualFacilityTest() {
		super();
	}
	
	/*
	 * @BeforeSuite 
	 * public void dbTabledelete() throws Throwable {
	 * DatabaseList.delecteTable(); }
	 */

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.navigate().refresh();
		testUtil = new UtilityPage();
		elementPage = new MasterPageFactory();
	}

	@AfterMethod
	public void tearDown() {
	try {
		//DatabaseList.dbTable(data);
	} catch (Throwable e) {
	}
		driver.quit();
	}

	@Test(priority = 1)
	public void Virtual_Facility_Coding_Challenge_1() {
		try {
			elementPage.verifyElementTestOne(driver);
		} catch (Throwable e) {
		}
	}

	@Test(priority = 2)
	public void Virtual_Facility_Coding_Challenge_2() {

		try {
			elementPage.ClickOnETHLink().click();
		} catch (Exception e) {
		}
		try {
			elementPage.EnterStockPrice();
		} catch (Exception e) {
		}
		try {
			elementPage.EnterStockQuantity();
		} catch (Exception e) {
		}
		try {
			elementPage.EnterStockTotalAmount();
		} catch (Exception e) {
		}
		try {
			elementPage.verifyElementTestTow(driver);
		} catch (Exception e) {
		}

	}
}
