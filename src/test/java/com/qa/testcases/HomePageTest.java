package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.basetest.BaseTest;

import comqa.pages.HomePage;
import comqa.pages.LoginPage;
import comqa.pages.NewLaunchPage;
import comqa.pages.BundlesPage;
import comqa.pages.KurtisPage;
import comqa.pages.SalwarPage;
import comqa.pages.SareesPage;
import io.qameta.allure.Step;

import com.qa.utils.Constants;
import com.qa.utils.ElementUtil;
import com.qa.utils.TimeUtils;


public class HomePageTest extends BaseTest{

	Properties prop;
	WebDriver driver;
	BaseTest baseTest ;
	LoginPage loginPage;
	HomePage homePage;
	NewLaunchPage newlaunchpage;
	BundlesPage bundlespage;
	KurtisPage kurtispage;
	SalwarPage salwarpage;
	TimeUtils ts = new TimeUtils();
	//SareesPage sareespage;
	
	
	
	@Test(priority=2)
	@Step("Home page : clickNewLaunchPage ")
	public void clickNewLaunchPage() {
		ts.shortWait();
		newlaunchpage=homePage.clickNewLaunch();
		ts.LongWait();
		Assert.assertEquals(newlaunchpage.header().trim(),Constants.NEWLAUNCH_PAGE_TITLE );
	}
	
	@Test(priority=3)
	@Step("Home page : clickBundlesPage ")
	public void clickBundlesPage() {
		ts.shortWait();
		bundlespage =homePage.clickBundles();
		ts.LongWait();
		Assert.assertEquals(bundlespage.header().trim(),Constants.BUNDLES_PAGE_TITLE);
	}
	
	
	@Test(priority=4)
	@Step("Home page : clickKurtisPage ")
	public void clickKurtisPage() {
		ts.shortWait();
		System.out.println("kurthis ---1");
		kurtispage=	homePage.clickKurtis();
		ts.LongWait();
		System.out.println("kurthis ---after click");
		System.out.println(kurtispage.header().trim());
		System.out.println("kurthis ---2");
		System.out.println(Constants.KURTISTOPS_PAGE_TITLE );
		Assert.assertEquals(kurtispage.header().trim(),Constants.KURTISTOPS_PAGE_TITLE );
	
	}
	

	@Test(priority=5)
	@Step("Home page : clickSalwarPage ")
	public void clickSalwarPage() {
		ts.shortWait();
		salwarpage=	homePage.clickSalwarSuit();
		ts.LongWait();
		Assert.assertEquals(salwarpage.header().trim(),Constants.SALWAR_PAGE_TITLE );
	
	}
	
	
	
	@Test(priority=1)
	@Step("Home page : checkWelcomeMessage ")
	public void checkWelcomeMessage() {
		System.out.println(1);
		ts.MediumWait();
		System.out.println(prop.getProperty("welcomemsg").trim());
		Assert.assertEquals(homePage.checkWelcomeMessage1().trim(), prop.getProperty("welcomemsg").trim());
		
	}

	@BeforeTest
	public void beforeTest() {
		baseTest = new BaseTest();
		prop=baseTest.init_properties();
		driver=baseTest.initialization(prop);
		loginPage = new LoginPage(driver);
		homePage=loginPage.clickLoginBtn(prop.getProperty("username"), prop.getProperty("pwd"));
		//homePage = new HomePage(driver);
	}

	@AfterTest
	public void afterTest() {
	//	driver.quit();
	}

}
