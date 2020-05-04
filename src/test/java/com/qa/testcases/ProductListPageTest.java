package com.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.utils.TimeUtils;

import comqa.pages.HomePage;
import comqa.pages.KurtisPage;
import comqa.pages.LoginPage;
import comqa.pages.ProductListPage;
import comqa.pages.ProductDescPage;

public class ProductListPageTest {
	
	Properties prop;
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	LoginPage loginPage;
	HomePage homePage;
	KurtisPage kurtispage;
	String str;
	ProductListPage  productlistpage;
	ProductDescPage  productdescpage;
	TimeUtils ts = new TimeUtils();
  
  @Test
  public void clickFirstImage() {
	  
	  productdescpage = productlistpage.clickImage();
  }
  
  
  
  @Test
  public void checkSize() {
	  String str = productlistpage.kurtiDesc();
	 Assert.assertEquals(str.trim(), "Description: 5XL");		  
  }
  
  @Test
  public void checkStock() {
	  String str1 = productlistpage.kurtiStockAvailabality();
	 Assert.assertEquals(str1.trim(), "Stock Availability: in stock");		  
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
		productlistpage = kurtispage.chooseBySize(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
