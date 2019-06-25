/**
 * 
 */
package com.sfg.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfg.qa.base.testBase;
import com.sfg.qa.pages.OrDashboardPage;
import com.sfg.qa.pages.OrLoginPage;

/**
 * @author Aditya Mansana
 *
 */
public class DashboardPageTest extends testBase{
	
	
	OrLoginPage loginpage;
	OrDashboardPage dashboardpage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginpage = new OrLoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.validateLoginPageTitle();
		System.out.println("Login page title: " + title);
		Assert.assertEquals(title, "Sentrifugo - Open Source HRMS");
		
	}
	
	@Test(priority=2)
	public void logintest() {
		dashboardpage = loginpage.login(prop.getProperty("superadusername"), prop.getProperty("superadpassword"));
	}

	@Test(priority=3)
	public void dashboardTest() {
		Assert.assertTrue(dashboardpage.verifyProfileImage());
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}


