package com.qa.testcases;
import org.testng.annotations.Test;
import com.qa.utils.ElementUtil;
import com.qa.utils.ExcelUtil;
import com.qa.utils.JavaScriptUtil;

import com.qa.utils.ExcelUtil;

import org.testng.annotations.BeforeTest;
		import org.testng.Assert;
		import org.testng.annotations.AfterTest;

		import java.util.Iterator;
		import java.util.Properties;
		import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.basetest.BaseTest;

import comqa.pages.CartPage;
import comqa.pages.HomePage;
import comqa.pages.LoginPage;
import comqa.pages.ProductDescPage;
import comqa.pages.ProductListPage;
import comqa.pages.CheckoutPage;
import comqa.pages.KurtisPage;
import comqa.pages.LoginPage;
import com.qa.utils.TimeUtils;

		public class dummy extends BaseTest {
	
			static WebDriver driver;
			ElementUtil elementUtil;
			JavaScriptUtil js;
			ProductDescPage productdescpage;
			CartPage cartpage;
			ProductListPage productlistpage;
			HomePage homepage ;
			CheckoutPage  checkoutpage;
			KurtisPage  kurtispage; 
			LoginPage loginPage;
			TimeUtils ts= new TimeUtils();
			static BaseTest baseTest;
			 static ExcelUtil excel ;
			static Object[][] data;
		
			static	Properties prop =new Properties();
			
			@FindBy(xpath="//h1")
			WebElement header;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:firstname']")
			WebElement firstName;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:lastname']")
			WebElement lastName;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:company']")
			WebElement company;

			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:street1']")
			WebElement street1;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:street2']")
			WebElement street2;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:vat_id']")
			WebElement gstNumber;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:city']")
			WebElement city;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:region']")
			WebElement state;
			
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:postcode']")
			WebElement postalcode;
			
			
			@FindBy(xpath="//div[@class='input-box']/select[@id='billing:country_id']")
			WebElement country;
			
			@FindBy(xpath="//div[@class='input-box']/input[@id='billing:telephone']")
			WebElement telephone;
			
			@FindBy(xpath="//li/input[@id='billing:use_for_shipping_yes']")
			WebElement shipToThisAddressRadiobtn;
			
			@FindBy(xpath="(//button[@title='Continue'  and @type='button']/span/span)[position()=2]")
			WebElement billingContinueBtn;
			

			@FindBy(xpath="//li[@id='opc-payment']/div/h2/parent::div//following-sibling::div/form/fieldset/dl/dt[3]/input[@id='p_method_phoenix_cashondelivery']")
			WebElement cashOnDelivery;
			
			

			@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td/h3")
			WebElement productNameInChkOutPage;
			
			

			@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td[2]/span[2]/span")
			WebElement priceOnChkoutPage;
			

			@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td[3]/span")
			WebElement qtyOnCheckOutPage;
			
			
			@FindBy(xpath="//table[@id='checkout-review-table']/tbody/tr/td[4]/span[2]/span")
			WebElement subTotalinCheckOutPage;
			
			@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[2]/td[2]/span")
			WebElement shippingChargesInChkoutPage;
			
			@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[4]/td[2]/span")
			WebElement gstChargesInCheckoutPage;
			
			@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[5]/td[2]/span")
			WebElement cashOnDelChargesInCheckoutPage;
			
			
			@FindBy(xpath="//table[@id='checkout-review-table']/tfoot/tr[6]/td[2]/strong/span")
			WebElement grandTotalInChekoutPage;
			

			@FindBy(xpath="//button[@title='Place Order']")
			WebElement placeOrderBtn;
			
			
			public dummy(WebDriver driver) {
				this.driver= driver;
				elementUtil= new ElementUtil(driver);
				js= new JavaScriptUtil(driver);
				  baseTest = new BaseTest();
				loginPage = new LoginPage(driver);
				homepage = new HomePage(driver);
				 kurtispage= new KurtisPage(driver);
				 productdescpage = new ProductDescPage(driver);
				 cartpage=new CartPage(driver);
				 productlistpage=new ProductListPage(driver);
				 
				  checkoutpage=new CheckoutPage(driver);
				
				//  excel = new excelUtil(driver);
				PageFactory.initElements(driver, this);
				
				
			}
			
			public void nav()
			{

				
				 prop= baseTest.init_properties();
				 driver=baseTest.initialization(prop);
				 loginPage = new LoginPage(driver);
				 homepage= loginPage.clickLoginBtn("manjula.swamy78@gmail.com", "Lotus@123");
				 kurtispage=homepage.clickKurtis();
				productlistpage=kurtispage.chooseBySize(driver);
				productdescpage=productlistpage.clickImage();
				productdescpage.selectSize();
				productdescpage.addQty();
				cartpage=productdescpage.addItem();
				checkoutpage=cartpage.clickProceedbtn();
				excel.getTestdata("BillData");
			}
			
			
			

			public static void main(String[] args) throws Exception {
				
				
				 
			//	dummy d = new dummy(driver);
				//d.nav();
		//		e1= new ee();
		//	data=e1.getTestData("BillData");
			
				   excel = new ExcelUtil(driver);
				 data=excel.getTestdata("billingdata");
				System.out.println(data[0][2]);
				
			

			}
		}
		
		
				  
				  
	