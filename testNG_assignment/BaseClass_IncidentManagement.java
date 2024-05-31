package week5.testNG_assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class BaseClass_IncidentManagement {
	
	public static String incidentNumber;
	public ChromeDriver driver;
	public Shadow dom;
	
	
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void preCondition(String url, String uName, String pWord) {
		
	driver = new ChromeDriver();
	
    driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	//1.Launch ServiceNow application
	driver.get(url);
	
	//2.Login with valid credential
	
	driver.findElement(By.id("user_name")).sendKeys(uName);
	
	driver.findElement(By.id("user_password")).sendKeys(pWord);
	
	driver.findElement(By.id("sysverb_login")).click();
	
	
	//3. Click -All and  Enter Incident in filter navigator and press enter
	
	dom = new Shadow(driver);
	dom.setImplicitWait(10);
	
	WebElement all = dom.findElementByXPath("//div[@aria-label='All']");
	
	all.click();
	
	WebElement serviceCataloge = dom.findElementByXPath("//input[@id='filter']");
	serviceCataloge.sendKeys("Incidents", Keys.ENTER);

	dom.findElementByXPath("//a[@aria-label='Incidents']").click();


}
	
	@AfterMethod
	public void postCondition()
	{
		System.out.println("Test Case has been executed");
		System.out.println("****************************");
		driver.close();
	}
}