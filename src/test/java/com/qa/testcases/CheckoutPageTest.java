package com.qa.testcases;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.utils.ExcelUtil;
import com.qa.utils.TimeUtils;
import com.qa.utils.ExcelUtil;

//import ApachePOIAPI_In_TestNG.TestUtil;
import comqa.pages.CartPage;
import comqa.pages.HomePage;
import comqa.pages.KurtisPage;
import comqa.pages.LoginPage;
import comqa.pages.ProductDescPage;
import comqa.pages.ProductListPage;
import comqa.pages.CheckoutPage;
public class CheckoutPageTest {
 
	
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
	CheckoutPage checkoutPage;
	String subTot;
	ExcelUtil excel;
	TimeUtils ts = new TimeUtils();
  
  @Test(priority=2)
  public void chkQtyInCart() {
	 String str = checkoutPage.getQtyOnCheckOutPage();
	 System.out.println(" getQtyOnCheckOutPage " + str);
	 System.out.println(" cartpage.getQtyIncart " + cartpage.getQtyIncart());
	 Assert.assertEquals(str, cartpage.getQtyIncart());
	  
  }
  
  @Test(priority=3)
  public void getPriceOnChkoutPage() {
	 String str = checkoutPage.getPriceOnChkoutPage();
	 System.out.println(" getPriceOnChkoutPage " + str);
	
		 Assert.assertEquals(str, subTot);
  }
  
	
	@DataProvider
	public Object[][] getBillingTestData() {
		 System.out.print(10);
		 ExcelUtil excel = new ExcelUtil(driver);
		 System.out.print(9);
		Object data[][] = excel.getTestdata("billingdata");
		return data;
	}

	@Test(priority=1, dataProvider = "getBillingTestData")
	public void createNewBillingTest(String fn, String ln, String company,String street1, String street2, String city,String state,String postalcode, String phone) {
		 System.out.print(10);
		 checkoutPage.fillBillingDtls(fn, ln, company, street1, street2, city, state, postalcode, phone);
		// Assert.assertEquals(name, firstname+" "+lastname);
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
		ts.shortWait();
		productlistpage = kurtispage.chooseBySize(driver);
		ts.shortWait();
		productdescpage=productlistpage.clickImage();
		productdescpage.selectSize();
		productdescpage.addQty();
		cartpage=productdescpage.addItem();
		ts.shortWait();
		 subTot=cartpage.getSubTotalinCartPage();
		 ts.shortWait();	
		checkoutPage=cartpage.clickProceedbtn();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}
