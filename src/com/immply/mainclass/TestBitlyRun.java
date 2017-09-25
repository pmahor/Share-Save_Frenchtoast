package com.immply.mainclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;


public class TestBitlyRun {
	public static WebDriver driver;
	Functions obj6;


	public TestBitlyRun(){
		this.driver=driver;
		obj6 = new Functions(driver);
	}

	@Test(priority=7)
	public void testFBPage() throws InterruptedException {
		obj6.FBPage();
	}

	@Test(priority=8)
	public void TweetPage() throws InterruptedException {
		obj6.TwitterPage();
	}
  
	@Test(priority=9)
	public void testGmailPage() throws InterruptedException {
		obj6.GmailPage();
	}

}
