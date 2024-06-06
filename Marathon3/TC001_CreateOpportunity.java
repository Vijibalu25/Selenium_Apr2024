package Marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TC001_CreateOpportunity extends BaseClassOpportunity{
	 
	
	@Test(dataProvider="data")
	public  void createOpp(String opportunityName, String amount) throws InterruptedException
	{
	
//	    9.Click on the "New" button.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']/parent::a")).click();
//	    10.Enter the Opportunity name as 'Salesforce Automation by Your Name', get the text, and store it.
		WebElement oppName = driver.findElement(By.xpath("//input[@name='Name']"));
		oppName.sendKeys("Salesforce Automation by "+opportunityName);
		oppNameValue = oppName.getAttribute("value");
		System.out.println("Opportunity name is--->"+oppNameValue);
		
//	    11. Enter Amount as 75,000
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
//	    12.Choose the close date as Today.
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//div[@class='slds-datepicker slds-dropdown slds-dropdown_left']//table//tr//td[@class='slds-is-today']")).click();
		
		
//	    13.Select 'Stage' as 'Need Analysis'.
		driver.findElement(By.xpath("//button[@aria-label='Stage - Current Selection: --None--']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
//	    14.Click on the 'Save' button and verify the Opportunity Name.
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String verifyCreateMessage = driver.findElement(By.xpath("//span[contains(@class,'small forceActionsText')]")).getText();
		
		System.out.println(verifyCreateMessage);
        
	}
	
	

}

