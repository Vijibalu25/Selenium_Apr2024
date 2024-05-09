package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC002_CreateAccount {
	
	
	public static void main(String[] args) throws InterruptedException
	{
		
		String accountName = "Selenium_April_New";
		//Initialize the WebDriver (ChromeDriver)
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL http://leaftaps.com/opentaps/
		driver.get("http://leaftaps.com/opentaps/");
		
		//Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the Username as "DemoSalesManager" and the Password as "crmsfa"
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on the Login Button.
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on the CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//Click on the "Accounts" tab
		
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		
		
		//Click on the "Create Account" button
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		
		//Enter an account name
		
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys(accountName);
		
		//Enter a description as "Selenium Automation Tester." 
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		
		
		
		
		//Select "ComputerSoftware" as the industry
		
		WebElement indus = driver.findElement(By.name("industryEnumId"));

		Select sec = new Select(indus);
		sec.selectByVisibleText("Computer Software");
		
		
		//Select "S-Corporation" as ownership using SelectByVisibleText
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select secOwn=new Select(ownership);
		secOwn.selectByVisibleText("S-Corporation");
		
		//Select "Employee" as the source using SelectByValue
		WebElement source = driver.findElement(By.id("dataSourceId"));
		Select secSource=new Select(source);
		secSource.selectByValue("LEAD_EMPLOYEE");
		
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex
		WebElement markt = driver.findElement(By.id("marketingCampaignId"));
		Select secMark=new Select(markt);
		secMark.selectByIndex(6);
		
		//Select "Texas" as the state/province using SelectByValue
		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select secState = new Select(state);
		secState.selectByValue("TX");
		
		//Click the "Create Account" button
		driver.findElement(By.className("smallSubmit")).click();
		
		Thread.sleep(3000);
		//Verify that the account name is displayed correctly.
		String verifyText = driver.findElement(By.xpath("//span[text()='Account Name']")).getText();
		if(accountName.equalsIgnoreCase(verifyText))
		{
			System.out.println("Account name is displayed correctly :"+accountName);
		}
		else
		{
			System.out.println("Account name is not correct");
		}
		
		
		//Close the browser window
		driver.close();
		
	}

}
