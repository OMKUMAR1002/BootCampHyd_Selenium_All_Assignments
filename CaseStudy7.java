package com.CaseStudy7;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ChromeCaseStudy7 {
	WebDriver driver;
	String URL ="https://demo.opencart.com/";
	@BeforeTest
	@Parameters("browserName")
	
	public void Setup(String browserName) {
		  if(browserName.equalsIgnoreCase("chrome")) {
		        driver = new ChromeDriver();
		    }
		    else if(browserName.equalsIgnoreCase("edge")) {
		        driver = new EdgeDriver();
		    }
		    else if(browserName.equalsIgnoreCase("firefox")) {
		        driver = new FirefoxDriver();
		    }

		    driver.manage().window().maximize();
		    driver.navigate().to(URL);
	}
	
	@Test
	public void Test() throws Exception {
		String title = driver.getTitle();
		System.out.println("The title is:" +title);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshot/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, des);
		System.out.println("Screen shot saved successfully");
	}
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
