package com.CaseStudy4;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;



public class ChromeCaseStudy4 {
	WebDriver driver;
	String Url = "http://automationpractice.com/index.php";
	@BeforeTest
	public void Setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	@Test
	public void TestMethod() {
		driver.get(Url);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title" +pageTitle);
		System.out.println("Page Title Length" +pageTitle.length());
		
		
		
		String currentLink = driver.getCurrentUrl();
		System.out.println("Page Title" +currentLink);
		
		
		
		if(currentLink.equals(Url)) {
			System.out.println("Got Desired Result");
		}else {
			System.out.println("Not Got Desired Result");
			
		}
		
		String pageSource = driver.getPageSource();
		System.out.println("Page Source" +pageSource);
		int pageSourceLength = pageSource.length();
		System.out.println("Page Source Length" +pageSourceLength);
		
		
		WebElement links = driver.findElement(By.tagName("a"));
		System.out.println("Count Link" +links.getSize());
		
	}
	@AfterTest
	public void EndTest() {
		driver.close();
	}

}
