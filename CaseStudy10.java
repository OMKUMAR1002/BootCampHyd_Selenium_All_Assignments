package com.CaseStudy10;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class ChromeCaseStudy10 {
	WebDriver driver;
	String URL ="https://www.easemytrip.com/";
	
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.navigate().to(URL);
	}
	
	@Test
	public void Test() throws Exception {
		
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//section[@class='_bordrtp']//div[@class='_dropdownromenu']//a[1]")).click();
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
