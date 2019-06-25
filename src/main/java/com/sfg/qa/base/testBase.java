/**
 * @author Adi
 */
package com.sfg.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sfg.qa.util.testUtil;
import com.sfg.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Setting up the test base
 *
 */
public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public testBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/sfg" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		long pagetimeout = Long.parseLong(prop.getProperty("pagetimeout"));
		long implicitwait = Long.parseLong(prop.getProperty("implicitwait"));

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().version("2.40").setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pagetimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
