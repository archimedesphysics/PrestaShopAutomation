
package com.prestashop.tests;
import static com.prestashop.tests.Utilities.*;
import static com.prestashop.tests.Utilities.signIn;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class UnitTest {
	static WebDriver driver; 
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
	public void wrongcredentialTest() {
		loginFunctionality("abc212@gmail.com","asdasd","Authentication failed."); 
//		String expected1="Authentication failed."; 
//		emailAuthenticationTest("abc212@gmail.com","asdasd"); 
//		String actual1=driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
//		Assert.assertEquals(actual1, expected1);
		//Assert.assertEquals(expected1, actual1);
	}
	@Test
	public void invalidEmailTest() {
	loginFunctionality("abc212@gmai","asdasd","Invalid email address."); 
	}
	@Test
	public void blankEmailTest() {
	loginFunctionality("","asdasd","An email address required."); 
	}
	@Test
	public void blankPasswordTest() {
	loginFunctionality("abc212@gmail.com","","Password is required."); 
	}
	
	@AfterClass
	public static void tearDown(){
		driver.close();
	}

	
	
}