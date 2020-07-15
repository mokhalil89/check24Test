package com.check24.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.check24.base.TestBase;
import com.check24.util.TestUtil;

public class Check24Page extends TestBase {

	//@FindBy(xpath = "//*[@id=\"c24-content\"]/div/app-comparison/app-calculator/div/div/div/div[1]/input")
	//WebElement amount;
	
	@FindBy(xpath="//div[@class='howMuch input-wrapper']//input")
	WebElement amount1;
	
	@FindBy(xpath ="//*[@id=\"c24-content\"]/div/app-comparison/app-calculator/div/div/div/div[2]/div[2]/ul")
	WebElement durationUl;
	
	@FindBy(id="duration")
	WebElement durationDiv;
	
	
	@FindBy(xpath ="//*[@id=\"c24-content\"]/div/app-comparison/app-calculator/div/div/div/div[3]/div[2]/ul")
	WebElement purposeUl;
	
	@FindBy(id="purpose")
	WebElement purposeDiv;
	
	@FindBy(xpath = "//*[@id=\"c24-content\"]/div/app-comparison/div[2]/div/div/app-filter/div[1]/div[1]")
	WebElement filter;
	 
	@FindBy(xpath = "//*[@id=\"c24-content\"]/div/app-comparison/div[2]/div/div/app-filter/div[1]/div[2]")
	WebElement openSort;
	
	@FindBy(xpath = "//*[@id=\"product_id_432\"]/div[1]/label")
	WebElement checkBox;
	
	@FindBy(className = "productList")
	WebElement productList;
	
	@FindBy(className = "productToCompare")
	List<WebElement> productToCompare;
	
	@FindBy(className = "monthlyRate")
	List<WebElement> monthlyRates;
	
	@FindBy(className = "filtersContent")
	WebElement filtersContent;
	
	@FindBy(xpath = "//*[@id=\"duration\"]/i/b")
	WebElement durationLabel;
	
	@FindBy(xpath = "//*[@id=\"c24-content\"]/div/app-comparison/div[2]/div/div/app-filter/div[2]/div/ul")
	WebElement appFilter;
	
	// Initializing the Page Objects:
	public Check24Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void validate(Double newAmount) throws InterruptedException {
		amount1.click();
		amount1.sendKeys(newAmount.toString());
		openSort.click();
		Thread.sleep(3000L);
		for (WebElement element : monthlyRates) {
			String value = element.getText().replace("€", "").replace(" ", "").replace(",", "");
			Double filteredValues = Double.valueOf(value);
			Assert.assertTrue(filteredValues >= newAmount);
		}

	}
	
	public void validate(Double newAmount, String duration) throws InterruptedException {
		amount1.click();
		amount1.sendKeys(newAmount.toString());
		durationDiv.click();
		Thread.sleep(3000L);
		TestUtil.selectUlValue(durationUl, duration);
		String durationLabelString = durationLabel.getText().replace("€", "").replace(" ", "").replace(",", "");
		openSort.click();
		Thread.sleep(3000L);
		for (WebElement element : monthlyRates) {
			String value = element.getText().replace("€", "").replace(" ", "").replace(",", "");
			Double filteredValues = Double.valueOf(value);
			Assert.assertTrue(filteredValues >= Double.valueOf(durationLabelString));
		}

	}
	
	public void validate(Double newAmount, String duration, String purposeString) throws InterruptedException {
		amount1.click();
		amount1.sendKeys(newAmount.toString());
		durationDiv.click();
		Thread.sleep(2000L);
		TestUtil.selectUlValue(durationUl, duration);
		Thread.sleep(2000L);
		String durationLabelString = durationLabel.getText().replace("€", "").replace(" ", "").replace(",", "");
		purposeDiv.click();
		TestUtil.selectUlValue(purposeUl, purposeString);
		openSort.click();
		Thread.sleep(5000L);
		for (WebElement element : monthlyRates) {
			String value = element.getText().replace("€", "").replace(" ", "").replace(",", "");
			Double filteredValues = Double.valueOf(value);
			Assert.assertTrue(filteredValues >= Double.valueOf(durationLabelString));
		}

	}
	
	public void validateFilter() throws InterruptedException {
		openSort.click();
		Thread.sleep(3000L);
		Assert.assertTrue(appFilter!=null);
		Thread.sleep(3000L);
		Assert.assertTrue(filtersContent!=null);
	}
	
	public void validateProducts() throws InterruptedException {
		checkBox.click();
		Thread.sleep(3000L);
		Assert.assertTrue(productList != null);
		Assert.assertTrue(productToCompare.size() > 0);
	}
	

	
	
	

}
