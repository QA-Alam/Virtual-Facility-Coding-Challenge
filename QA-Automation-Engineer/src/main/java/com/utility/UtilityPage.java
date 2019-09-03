package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import virtualfacility.qa.page.BasePage;

public class UtilityPage extends BasePage {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;

	public static WebElement getExplicitWait(By element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		return element1;
	}

	public boolean isElementPresent(WebElement element, WebDriver driver, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void drawBorder(WebElement webelement, String color) {
		WebElement element_node = webelement;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid " + color + "'", element_node);
	}

	public static String captureScreenShot(WebDriver driver, String ScreenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date.getTime());
		String destination = currentDir + "//Screen Shot//" + dateTime + "//" + ScreenShotName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
		}
		return destination;
	}
}
