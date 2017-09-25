package com.immply.mainclass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.immply.callobjects.Functions;
import com.immply.readproperties.ReadProperties;

public class ParallelBrowserSetup {

	public WebDriver driver;
	Functions obj2;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(ReadProperties.Read().getProperty("driver1"),
					ReadProperties.Read().getProperty("driverpath1"));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty(ReadProperties.Read().getProperty("driver2"),
					ReadProperties.Read().getProperty("driverpath2"));
			driver = new InternetExplorerDriver();

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");

		} else {
			throw new Exception("Browser is not correct");
		}
		driver.get(ReadProperties.Read().getProperty("url1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		obj2 = new Functions(driver);
	}

}
