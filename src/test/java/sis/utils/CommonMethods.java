package sis.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import sis.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	public static void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void clickBox(List<WebElement> listElement, String value) {

		String actualValue;

		for (WebElement el : listElement) {
			actualValue = el.getAttribute("value").trim();
			if (actualValue.equals(value) && el.isEnabled()) {
				el.click();
				break;
			}
		}

	}

	public static void wait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void selectDropdown(WebElement element, int index) {

		Select sl = new Select(element);

		int size = sl.getOptions().size();
		if (size > index) {
			sl.selectByIndex(index);
		}

	}

	public static void selectDropdown(WebElement element, String visibleText) {

		Select select = new Select(element);

		List<WebElement> options = select.getOptions();
		for (WebElement el : options) {
			if (el.getText().equals(visibleText)) {
				select.selectByVisibleText(visibleText);
				break;
			}

		}

	}

	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}

	}

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}
	}

	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}
		return alertText;
	}

	public static void sendAlertText(String text) {

		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}

	}

	public static void switchToFrame(String frame) {

		try {
			driver.switchTo().frame(frame);
		} catch (NoSuchFrameException e) {

			e.printStackTrace();
		}

	}

	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {

			e.printStackTrace();
		}

	}

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {

			e.printStackTrace();
		}

	}

	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();

		for (String window : childWindows) {

			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}

		}

	}

	public static void selectDate(List<WebElement> elements, String date) {
		for (WebElement day : elements) {
			if (day.isEnabled()) {
				if (day.getText().equals(date)) {
					day.click();
					break;
				}

			} else {
				System.out.println("The date is not enabled!!");
				break;
			}
		}
	}

	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		return sdf.format(date);

	}

	public static byte[] takesScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {

			System.out.println("Cannot take a screenshot!");
		}

		byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);

		return picByte;

	}

	
	
	
	
	
	
	
}
