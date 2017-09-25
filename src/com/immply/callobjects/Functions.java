package com.immply.callobjects;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.immply.pageobjects.Objects;
import com.immply.readproperties.ReadProperties;


public class Functions {
	public static WebDriver driver;
	Objects obj1;


	// Class constructor
	public Functions(WebDriver driver){
		Functions.driver=driver;
		obj1 = new Objects(driver);
	}


	//Function Calling
	//Click on Share & Save widget
	public void ClickOnWidget() throws InterruptedException{
		try{
		driver.navigate().refresh();
		Thread.sleep(10000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='s4-widget-big']/img")));
		Thread.sleep(7000);
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}


	//Click on FShare Button
	public void ClickOnFBShare(String id,String pwd) throws InterruptedException{
		try{
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
		System.out.println("switch on iframe successfully");
		obj1.findElement2("//div[@id='sa-s4-facebook']").click();
		System.out.println("click on fb button successfully");
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Switch to new window opened
		Set<String> winHandles = driver.getWindowHandles();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		obj1.findElement1("email").clear();
		obj1.findElement1("email").sendKeys(id);

		obj1.findElement1("pass").clear();
		obj1.findElement1("pass").sendKeys(pwd);

		obj1.findElement1("u_0_2").click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\FacebookSharingEmailConformationPopup.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
		obj1.findElement2("//input[@id='sa_s4_your_email_share']").sendKeys("sa.lordpaul@gmail.com");
		obj1.findElement2("//button[contains(.,'Submit')]").click();
		Thread.sleep(8000);
		}catch(Exception ee){
			ee.printStackTrace();
		}
		
	}


	//Enter and Share post by Facebook
	public void FBShareWindow() throws InterruptedException {
		try{
		//String parentwindow = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver,30);
		Set<String> winHandles = driver.getWindowHandles();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("s4-main-iframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".FB_UI_Dialog")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.name("__CONFIRM__")));
		Thread.sleep(5000);
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\FacebookThankYouPopup.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}


	//Click on Twitter Share button
	public void ClickOnTwitterShare(String id,String pwd)throws InterruptedException{
		try{
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='s4-widget-big']/img")));
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
	    obj1.findElement2("//div[@id='sa-s4-twitter']").click();
		WebDriverWait wait = new WebDriverWait(driver,40);
		String parentwindow = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		for(String handle : winHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		obj1.findElement1("username_or_email").sendKeys(id);
		obj1.findElement1("password").sendKeys(pwd);
		obj1.findElement1("allow").click();
		Thread.sleep(5000);
/*		driver.switchTo().window(parentwindow);
		driver.switchTo().defaultContent();*/
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}


	//Enter Details in Twitter share
	public void TwittLoginPage(String name, String lastname, String email) throws InterruptedException{
	    try{
	    Set<String> winHandles = driver.getWindowHandles();
		for(String handle : winHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("s4-main-iframe"));

		obj1.findElement1("sa_s4_first_name_share").sendKeys(name);
		obj1.findElement1("sa_s4_last_name_share").sendKeys(lastname);
		obj1.findElement1("sa_s4_your_email_share").sendKeys(email);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//button[@class='btn btn-primary']")));
		Thread.sleep(7000);
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\TwitterThankYouPopup.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		Thread.sleep(7000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	    }catch(Exception ee){
			ee.printStackTrace();
		}

	}

	//Click on Email Share button and Share
	public void ClickOnEmailShare(String name, String lastname, String email, String shareEmail) throws InterruptedException{
		try{
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='s4-widget-big']/img")));
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
        obj1.findElement2("//div[@id='sa-s4-email']").click();
        Thread.sleep(5000);
		obj1.findElement2("//input[@name='first_name']").sendKeys("Lord#");
		obj1.findElement2("//button[contains(.,'Share Now')]").submit();
		Thread.sleep(2000);
		obj1.findElement2("//input[@name='first_name']").clear();
		obj1.findElement2("//input[@name='first_name']").sendKeys(name);
		Thread.sleep(2000);
		obj1.findElement1("sa_s4_last_name_share").sendKeys(lastname);
		Thread.sleep(2000);
		obj1.findElement1("sa_s4_your_email_share").sendKeys("sa.lord#paul@gmail.com");
		obj1.findElement2("//button[contains(.,'Share Now')]").submit();
		Thread.sleep(2000);
		obj1.findElement1("sa_s4_your_email_share").clear();
		obj1.findElement1("sa_s4_your_email_share").sendKeys(email);
		Thread.sleep(2000);
		obj1.findElement1("email_to_share").sendKeys(shareEmail);
		obj1.findElement2("//button[contains(.,'Share Now')]").submit();
//		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\EmailThankYouPopup.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		Thread.sleep(5000);
		driver.quit();
		}catch(Exception ee){
			ee.printStackTrace();
		}

	}

	//Switch to facebook login page
	public void FBPage() throws InterruptedException {
		try{
		FirefoxDriver obja = new FirefoxDriver();
		
		obja.get(ReadProperties.Read().getProperty("url2"));
		obja.manage().window().maximize();
		Thread.sleep(5000);
		obja.findElement(By.id("email")).sendKeys("sa.lordpaul@gmail.com");
		Thread.sleep(2000);
		obja.findElement(By.id("pass")).sendKeys("Test@1234");
		Thread.sleep(2000);
		obja.findElement(By.id("loginbutton")).click();
		Thread.sleep(12000);
		obja.findElement(By.xpath("//a[@title='Profile']")).click();
		Thread.sleep(8000);
		obja.findElement(By.xpath("//div[@class='_6l- __c_']")).click();
		Thread.sleep(5000);
		Set<String> winHandles = obja.getWindowHandles();
		for(String winHandle : obja.getWindowHandles())
		{
			obja.switchTo().window(winHandle);
		}
		Thread.sleep(30000);
		File scr=((TakesScreenshot)obja).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\FacebookUnlockCodePage.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
			Thread.sleep(3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(5000);
		}
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
		Thread.sleep(5000);
		obj1.findElement2("//input[@id='sa_s4_first_name_share']").sendKeys("Lord");
		Thread.sleep(2000);
		obj1.findElement2("//input[@id='sa_s4_last_name_share']").sendKeys("Paul");
		Thread.sleep(2000);
		obj1.findElement2("//input[@id='sa_s4_your_email_share']").sendKeys("sa.lordpaul25@gmail.com");
		Thread.sleep(2000);
		obj1.findElement2("//button[@type='submit']").click();
		obja.quit();
		}catch(Exception ee){
			ee.printStackTrace();
		}
	
	}

	
	//Switch to Twitter login page
	public void TwitterPage() throws InterruptedException{
		try {
		FirefoxDriver obja = new FirefoxDriver();
		obja.get(ReadProperties.Read().getProperty("url3"));
		obja.manage().window().maximize();
		Thread.sleep(5000);
		obja.findElement(By.xpath("//a[@class='Button StreamsLogin js-login']")).click();
		Thread.sleep(5000);
		obja.findElement(By.xpath("//input[@class='text-input email-input js-signin-email']")).sendKeys("sa.lordpaul@gmail.com");
		Thread.sleep(5000);
		obja.findElement(By.xpath("//input[@class='text-input']")).sendKeys("Test@1234");
		Thread.sleep(5000);
		obja.findElement(By.xpath("//input[@class='submit btn primary-btn js-submit']")).click();
		Thread.sleep(10000);
		obja.findElement(By.xpath("//span[contains(.,'Tweets')]")).click();
		Thread.sleep(5000);
		//img[@class='DashboardProfileCard-avatarImage js-action-profile-avatar']
		obja.findElement(By.xpath("//span[contains(.,'goo.gl/dKsou2')]")).click(); //span [@class='js-display-url']
		Thread.sleep(5000);
		Set<String> winHandles = obja.getWindowHandles();
		for(String winHandle : obja.getWindowHandles())
		{
			obja.switchTo().window(winHandle);
		}	
		Thread.sleep(30000);
		File scr=((TakesScreenshot)obja).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\TwitterUnlockCodePage.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(5000);
		}
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
		Thread.sleep(3000);
		obj1.findElement2("//input[@id='sa_s4_first_name_share']").sendKeys("Lord");
		Thread.sleep(2000);
		obj1.findElement2("//input[@id='sa_s4_last_name_share']").sendKeys("Paul");
		Thread.sleep(2000);
		obj1.findElement2("//input[@id='sa_s4_your_email_share']").sendKeys("sa.lordpaul26@gmail.com");
		Thread.sleep(2000);
		obj1.findElement2("//button[@type='submit']").click();
		obja.quit();
		}catch(Exception ee){
			ee.printStackTrace();
		}		
	}


	//Switch to gmail login page 
	public void GmailPage() throws InterruptedException{
		try{
		
		FirefoxDriver objc = new FirefoxDriver();
		objc.get(ReadProperties.Read().getProperty("url4"));
		objc.manage().window().maximize();
		Thread.sleep(10000);
		objc.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("sa.johnrichardley@gmail.com");
		objc.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(3000);
		objc.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Test@1234");
		objc.findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();
		Thread.sleep(5000);
		objc.findElement(By.name("q")).sendKeys("French Toast");
		objc.findElement(By.id("gbqfb")).click();
		Thread.sleep(5000);
		objc.findElement(By.xpath("//span[@id=':ew']")).click();    
		Thread.sleep(10000);
		objc.findElement(By.xpath("//img[@class='CToWUd']")).click();
		Set<String> winHandles = objc.getWindowHandles();
		for(String winHandle : objc.getWindowHandles())
		{
			objc.switchTo().window(winHandle);
		}
		
		Thread.sleep(20000);
		File scr=((TakesScreenshot)objc).getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Pankaj BACKUP\\Selenium\\Workspace\\Share_And_Save(French Toast)\\Screenshot\\EmailUnlockCodePage.jpg"); 
		try {
			FileUtils.copyFile(scr, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(driver.findElement(By.id("s4-main-iframe")));
		Thread.sleep(3000);
		obj1.findElement2("//input[@id='sa_s4_first_name_share']").sendKeys("Lord");
		Thread.sleep(2000);
		obj1.findElement2("//input[@id='sa_s4_last_name_share']").sendKeys("Paul");
		Thread.sleep(2000);
		obj1.findElement2("//input[@id='sa_s4_your_email_share']").sendKeys("sa.lordpaul27@gmail.com");
		Thread.sleep(2000);
		obj1.findElement2("//button[@type='submit']").click();	
		Thread.sleep(10000);
		
		objc.quit();
	}catch(Exception ee){
		ee.printStackTrace();
	}
}
}







