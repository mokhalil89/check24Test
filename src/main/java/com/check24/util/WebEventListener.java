package com.check24.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.check24.base.TestBase;


public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		if(element==null) {
			System.out.println("Found element : " + element + " by :"+by.toString());
		}else {
			System.out.println("Can not find element by :" +by.toString());
		}
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("before executing script "+script);
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("after executed script "+script);
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("before alert accept");
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("after alert accept");
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("before alert dismiss");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("after alert dismiss");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("before navigate refresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("after navigate refresh");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("before change of value");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("after change of value");
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("after screenshot");
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		System.out.println("after get text "+arg2);
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("after switch to window");
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("before get screen shot");
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		System.out.println("before get text ");
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("before switch to window");
	}

}
