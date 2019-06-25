/**
 * @author Aditya Mansana 
 */
package com.sfg.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sfg.qa.base.testBase;

public class OrLoginPage extends testBase{

	
	@FindBy(xpath="//h3[@class='login_title']")
	WebElement lblLoginTitle;	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtuserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='loginsubmit']")
	WebElement btnSubmit;

	// Initializing the Page Objects:
	public OrLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyLoginLabel(){
		return lblLoginTitle.isDisplayed();
	}

	//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public OrDashboardPage login(String un, String pwd){
			txtuserName.sendKeys(un);
			txtpassword.sendKeys(pwd);
			btnSubmit.click();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", loginBtn);
		 */
			return new OrDashboardPage();
		}
}
