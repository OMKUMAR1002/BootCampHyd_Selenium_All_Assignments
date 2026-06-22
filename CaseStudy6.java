package com.CaseStudy6;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ChromeCaseStudy6 {
	WebDriver driver;
	String URL = "https://store.webkul.com\r\n";
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	@Test
	public void Test() throws IOException {
		String title = driver.getTitle();
		System.out.println("The title is: " +title);
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshot/image2.png");
		FileUtils.copyFile(src, des);
		System.out.println("Screen shot saved successfully");
		
	}
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
