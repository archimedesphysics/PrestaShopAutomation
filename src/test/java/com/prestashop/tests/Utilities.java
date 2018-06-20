package com.prestashop.tests;
import static com.prestashop.tests.UnitTest.driver;
import static com.prestashop.tests.Utilities.emailAuthenticationTest;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Utilities {

	public static void signIn(String url, String xpath){
			driver.get( url );
			driver.findElement(By.xpath(xpath)).click();// change xpath
			
	}
	
	public static void emailAuthenticationTest(String id, String pwd){
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(id);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click(); 
		
	}
	public static void loginFunctionality(String id,String pwd,String expected){
		 
		emailAuthenticationTest(id,pwd); 
		String actual=driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
		Assert.assertEquals(actual, expected);
		
	}
}