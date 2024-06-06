package Marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC002_EditOpportunity extends BaseClassOpportunity{

	@Test(enabled=true,dependsOnMethods= "Marathon3.TC001_CreateOpportunity.createOpp")
	public void editOpp() throws InterruptedException
	{
//	    9.Search for the Opportunity 'Salesforce Automation by Your Name'.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(oppNameValue, Keys.ENTER);
		
//	    10.Click on the Dropdown icon and select 'Edit'.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table/tbody/tr/td[8]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'uiMenuList forceActionsDropDownMenuList uiMenuList')]//ul//li[1]//a")).click();
	
		
//	    11.Choose the close date as Tomorrow's date.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//div[@class='slds-datepicker slds-dropdown slds-dropdown_left']//table//tr[2]//td[@data-value='2024-06-07']")).click();
		
//	    12.Select 'Stage' as 'Perception Analysis'.
		driver.findElement(By.xpath("//button[contains(@aria-label,'Stage - Current Selection')]")).click();
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
//	    13.Select 'Delivery/Installation Status' as 'In Progress'.
		WebElement delivetyStatus = driver.findElement(By.xpath("//button[contains(@aria-label,'Delivery/Installation Status')]"));
		driver.executeScript("arguments[0].click();", delivetyStatus);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		
//	    14.Enter Description as 'SalesForce'.
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SaleForce");
//	    15.Click on 'Save' and verify the Stage as 'Perception Analysis'.
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		String verifyEditMessage = driver.findElement(By.xpath("//span[contains(@class,'small forceActionsText')]")).getText();
		
		System.out.println(verifyEditMessage);
		
		String verifyStatus = driver.findElement(By.xpath("//div[@class='uiScroller scroller-wrapper scroll-bidirectional native']//table//tr[1]//td[5]")).getText();
		System.out.println(verifyStatus);
	
	}
	
}
