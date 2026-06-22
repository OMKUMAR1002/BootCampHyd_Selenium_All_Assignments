package com.CaseStudy11;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ChromeCaseStudy11 {
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
		
		WebElement element = driver.findElement(By.xpath("//a[@class='_btnclick']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
//		Thread.sleep(10000);
////		driver.findElement(By.className("_crosslog")).click();
//		Thread.sleep(10000);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='_dropdownromenu drhvr']//a[1]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element1));

		element1.click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshot/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, des);
		System.out.println("Screen shot saved successfully");
		
		driver.findElement(By.id("txtEmailNew")).sendKeys("omkumar@gmail.com");
		driver.findElement(By.id("shwotp")).click();
	}
//	@AfterTest
//	public void TearDown() {
//		driver.quit();
//	}

}
