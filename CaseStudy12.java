package com.CaseStudy12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeCaseStudy12 {

    WebDriver driver;
    String URL = "https://www.easemytrip.com/";

    @BeforeTest
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void TestAssertions() {

        String String1 = "MyAccount";
        String String2 = "My Booking";

      
        Assert.assertEquals(String1, "MyAccount");
        System.out.println("assertEquals Passed");

        
        Assert.assertNotEquals(String1, String2);
        System.out.println("assertNotEquals Passed");


        Assert.assertTrue(String1.equals("MyAccount"));
        System.out.println("assertTrue Passed");

    
        Assert.assertFalse(String1.equals(String2));
        System.out.println("assertFalse Passed");

     
        String value1 = null;
        Assert.assertNull(value1);
        System.out.println("assertNull Passed");

       
        String value2 = "EaseMyTrip";
        Assert.assertNotNull(value2);
        System.out.println("assertNotNull Passed");
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
