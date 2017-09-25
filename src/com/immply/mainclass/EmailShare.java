package com.immply.mainclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;


public class EmailShare {
	public static WebDriver driver;
	Functions obj5;


	public EmailShare(){
		this.driver=driver;
		obj5 = new Functions(driver);
	}

	  @Test(priority=6)
	  public void testEmailShare() throws InterruptedException {
		  obj5.ClickOnEmailShare("Lord", "Paul", "sa.lordpaul@gmail.com", "sa.johnrichardley@gmail.com,sa.robertcook@gmail.com");
	  }

}

