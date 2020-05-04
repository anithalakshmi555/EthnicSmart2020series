package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.basetest.BaseTest;

import comqa.pages.BundlesPage;
import comqa.pages.HomePage;
import comqa.pages.KurtisPage;
import comqa.pages.LoginPage;
import comqa.pages.NewLaunchPage;
import com.qa.utils.TimeUtils;

public class KurtisPageTest  {
	
	Properties prop;
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	LoginPage loginPage;
	HomePage homePage;
	KurtisPage kurtispage;
	String str;
	
	TimeUtils ts = new TimeUtils();
  
	/*
	 * public void clickSelectBySize() { kurtispage.chooseBySize(); str =
	 * kurtispage.kurtiName(); System.out.println(str); }
	 */
  @Test
  public void clickSelectBySize() { 
		  
//		 homePage= new   HomePage(driver);
//		ts.MediumWait();
//		 homePage.clickKurtis();
//	  System.out.println(kurtispage.header());
//	  ts.MediumWait();
	  kurtispage.chooseBySize(driver);
	  System.out.println(kurtispage.kurtiName());
	  System.out.println(kurtispage.kurtiDesc());
	  System.out.println(kurtispage.kurtiStockAvailabality());
	 
	  
  }
  
  
  @BeforeTest
	public void beforeTest() {
		prop=baseTest.init_properties();
		driver=baseTest.initialization(prop);
		//kurtispage= new KurtisPage(driver);
		loginPage = new LoginPage(driver);
		homePage=loginPage.clickLoginBtn(prop.getProperty("username"), prop.getProperty("pwd"));
		ts.MediumWait();
		homePage.checkWelcomeMessage1();
		ts.LongWait();
		kurtispage=homePage.clickKurtis();
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}


}
