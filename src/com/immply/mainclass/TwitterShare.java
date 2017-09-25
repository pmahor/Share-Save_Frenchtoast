package com.immply.mainclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;


public class TwitterShare {
	public static WebDriver driver;
	Functions obj4; 


	public TwitterShare() {
		this.driver=driver;
		obj4=new Functions(driver);
	}


	@Test(priority=4)
	  public void TweetShare() throws InterruptedException {
	  obj4.ClickOnTwitterShare("sa.lordpaul@gmail.com", "Test@1234");
	  }
	  
	  
	  @Test(priority=5)
	  public void TweetLoginPage() throws InterruptedException {
		  obj4.TwittLoginPage("Lord", "Paul", "sa.lordpaul@gmail.com");
	  }
	 
}
