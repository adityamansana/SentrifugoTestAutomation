/**
 * @author Aditya Mansana
 */
package com.sfg.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfg.qa.base.testBase;

public class OrDashboardPage extends testBase{

	
	@FindBy(xpath="//img[@id='profile_img']")
	WebElement profileImage;
	
	@FindBy(xpath="//div[@class='member_name']")
	WebElement MemberName;
	
	// Initializing the Page Objects:
		public OrDashboardPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyProfileImage() {
			return profileImage.isDisplayed();
		}
		
		public String verifyMember() {
			return MemberName.getText().toString();
		}
}
