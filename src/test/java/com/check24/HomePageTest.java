package com.check24;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.check24.base.TestBase;
import com.check24.pages.Check24Page;
import com.check24.util.TestUtil;

public class HomePageTest extends TestBase {
	
	TestUtil testUtil;
	Check24Page check24;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		check24 = new Check24Page();
	}
	
	
	@Test(priority=1)
	public void validateAmountFilterTest()  throws InterruptedException {
		check24.validate(Double.valueOf(2000));
	}
	
	@Test(priority=2)
	public void validateAmountAndDurationFilterTest() throws InterruptedException {
		check24.validate(Double.valueOf(2000), "84");
	}
	
	@Test(priority=3)
	public void validateAmountAndDurationFilterAndPurposeTest() throws InterruptedException {
		check24.validate(Double.valueOf(2000), "84", "8");
	}
	
	
	@Test(priority=4)
	public void validateFilterTest() throws InterruptedException {
		check24.validateFilter();
	}
	
	@Test(priority=5)
	public void validateProductsTest() throws InterruptedException {
		check24.validateProducts();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
