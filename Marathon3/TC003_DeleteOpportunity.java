package Marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TC003_DeleteOpportunity extends BaseClassOpportunity{

	@Test(dependsOnMethods= "Marathon3.TC002_EditOpportunity.editOpp")
	public void deleteOpp() throws InterruptedException
	{
//		    9.Search for the Opportunity 'Salesforce Automation by Your Name'.
		 driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(oppNameValue, Keys.ENTER);
//		    10.Click on the Dropdown icon and select 'Delete'.
		 Thread.sleep(2000);
			driver.findElement(By.xpath("//table/tbody/tr/td[8]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='branding-actions actionMenu']//ul//li[2]/a")).click();
		
//		    12.Verify whether the Opportunity is deleted using the Opportunity Name.
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			Thread.sleep(2000);
			String verifyDeleteMessage = driver.findElement(By.xpath("//span[contains(@class,'small forceActionsText')]")).getText();
			
			System.out.println(verifyDeleteMessage);
	}
}
