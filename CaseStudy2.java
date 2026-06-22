package com.CaseStudy2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeCaseStudy2 {
	WebDriver driver;
	String Url = "https://www.easycalculation.com/";
	@BeforeTest
	public void Setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	@Test
	public void TestMethod() {
		driver.get(Url);
		driver.findElement(By.id("googleSearchId")).sendKeys("Bangalore");
		driver.findElement(By.className("search_button")).click();
		String pageTitle = driver.getTitle();
		System.out.println("Page Title" +pageTitle);
		String pageSource = driver.getPageSource();
		System.out.println("Page Source" +pageSource);
		int pageSourceLength = pageSource.length();
		System.out.println("Page Source Length" +pageSourceLength);
		
	}
	@AfterTest
	public void EndTest() {
		driver.close();
	}

}
