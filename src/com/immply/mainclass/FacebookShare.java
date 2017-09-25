package com.immply.mainclass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;
import com.immply.readproperties.ReadProperties;


public class FacebookShare {
	public static WebDriver driver;
	Functions obj3;
	
	public FacebookShare(){
		this.driver=driver;
		obj3 =new Functions(driver);
	}

	  @Test(priority=1)
	  public void testWidget() throws InterruptedException{
		  obj3.ClickOnWidget();
	  }	  


	  @Test(priority=2)
	  public void testFBLoginPage() throws InterruptedException {
		  obj3.ClickOnFBShare("sa.lordpaul@gmail.com", "Test@1234");
	  }
	  
	   
	  @Test(priority=3)
	  public void testFBShareWindow() throws InterruptedException {
		  obj3.FBShareWindow();
	  }
	  
}