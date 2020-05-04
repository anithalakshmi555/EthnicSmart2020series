package com.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.utils.TimeUtils;

import comqa.pages.CartPage;
import comqa.pages.HomePage;
import comqa.pages.KurtisPage;
import comqa.pages.LoginPage;
import comqa.pages.ProductDescPage;
import comqa.pages.ProductListPage;

public class CartPageTest {
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
  public void chkQtyInCart() {
	 String str = cartpage.getQtyIncart();
	 Assert.assertEquals(str, "1");
	  
  }
  
  @Test(priority=2)
  public void getGstChargesIncartPage() {
	  String str = cartpage.getGstChargesIncartPage();
		 Assert.assertEquals(str, "Rs53.00");
  }
  
  @Test(priority=3)
  public void chkGrandTotalInCartPage() {
	  String str = cartpage.getGrandTotalInCartPage();
		 Assert.assertEquals(str,"Rs1,113.00" );
  }
  
  
  @Test(priority=2)
  public void chkSubTotalinCartPage() {
	 
	  String str = cartpage.getSubTotalinCartPage();
		 Assert.assertEquals(str, "Rs1,060.00");
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
		productdescpage.selectSize();
		productdescpage.addQty();
		cartpage=productdescpage.addItem();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
