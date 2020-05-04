package com.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.utils.Constants;
import com.qa.utils.TimeUtils;

import comqa.pages.BundlesPage;
import comqa.pages.CartPage;
import comqa.pages.HomePage;
import comqa.pages.KurtisPage;
import comqa.pages.LoginPage;
import comqa.pages.NewLaunchPage;
import comqa.pages.ProductDescPage;
import comqa.pages.ProductListPage;
import comqa.pages.SalwarPage;

public class ProductDescPageTest {
  
	Properties prop;
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	LoginPage loginPage;
	HomePage homePage;
	KurtisPage kurtispage;
	String str;
	ProductListPage  productlistpage;
	ProductDescPage  productdescpage;
	CartPage cartpage;
	TimeUtils ts = new TimeUtils();
  
  @Test(priority=1)
  public void selectSize5XL() {
	  
	   productdescpage.selectSize();
  }
  
  
  
  @Test(priority=2)
  public void addQty() {
	  productdescpage.addQty();  
  }
  
  

  @Test(priority=3)
  public void clickOnAddBtn() {
	  
	 cartpage= productdescpage.addItem();  
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
		productdescpage=productlistpage.clickImage();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}


}
