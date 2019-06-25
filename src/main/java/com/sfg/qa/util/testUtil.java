package com.sfg.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sfg.qa.base.testBase;

public class testUtil extends testBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	//Click on a webElement
	public static void clickOn(By by) {
		driver.findElement(by).click();
	}
	
	//type into a text field
	public static void dataEntry(By by, String keysToSend) {
		driver.findElement(by).sendKeys(keysToSend);
	}
	
	//clear a text field
	public static void clearField(By by) {
		driver.findElement(by).clear();
	}
	
	
}
