package com.prestashop.tests;
import static com.prestashop.tests.UnitTest.driver;
import static com.prestashop.tests.Utilities.emailAuthenticationTest;
import static com.prestashop.tests.Utilities.signIn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnitTestPositive {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//full screen
				driver.manage().window().maximize();
				//set universal wait time in case web page is slow
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public static void setUpBeforeMethod(){
		signIn( "http://automationpractice.com", "//a[@class='login']"); 
		
		
	}
	@Test
	public void invalidEmailTest() throws InterruptedException {
		String expected="MY ACCOUNT";
		emailAuthenticationTest("archimedesphysics26@gmail.com","1234qwer"); 
		Thread.sleep(2000); 
	
		String actual=driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		Assert.assertEquals(actual, expected); 
	}
	@AfterClass
	public static void tearDown(){
		driver.close();
	}
	
}
