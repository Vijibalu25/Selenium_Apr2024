package Marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week5.testNG_readExcelassignment.ReadExcel;

public class BaseClassOpportunity {

	public static ChromeDriver driver;
	public static String oppNameValue;
	
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void preConditions(String url,String uName, String pWord) throws InterruptedException
	{
		
//		1.Launch the browser.
        ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
	     driver = new ChromeDriver(options);
	
	    driver.manage().window().maximize();	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
//	    2.Load the URL: https://login.salesforce.com.
	    driver.get(url);
	    
	    
//	    3.Enter the username as gokul.sekar@testleaf.com.
	    driver.findElement(By.id("username")).sendKeys(uName);
	
//	    4.Enter the password as Leaf$123.
	    driver.findElement(By.id("password")).sendKeys(pWord);
//	    5.Click on the Login button.
	    driver.findElement(By.id("Login")).click();
//	    6.Click on the toggle menu button in the left corner.
	   
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")).click();
	    
//	    7.Click on "View All" and select "Sales" from the App Launcher.
	    Thread.sleep(3000);
	
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
		
//	    8.Click on the "Opportunity" tab.
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		
		driver.executeScript("arguments[0].click();", opp);
	}
	
	@AfterMethod
	public void postCondition()
	{
		System.out.println("Test Case has been executed");
		System.out.println("***************************");
		driver.close();
		
	}
	
	@DataProvider
	public static String[][] data() throws IOException
	{
		return ReadExcelOpportunity.readData();
	}

}
