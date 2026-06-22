package com.CaseStudy5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;

public class ChromeCaseStudy5 {
	WebDriver driver;
	String URL = "https://store.webkul.com\r\n";
	@BeforeTest
	public void Setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	@Test
	public void Test() throws IOException {
		String title = driver.getTitle();
		System.out.println("The title is:" +title);
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/image1.png");
		FileUtils.copyFile(src,dest);
		System.out.println("Screen shot saved successfully");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The links are: " +links.size());
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
