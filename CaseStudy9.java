package com.CaseStudy9;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

public class ChromeCaseStudy9 {
	WebDriver driver;
	String URL ="https://www.easycalculation.com/";
	
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.navigate().to(URL);
	}
	
	@Test
	public void Test() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,6000)");
		
		driver.findElement(By.xpath("//a[normalize-space()='Area Tutorials']")).click();
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
