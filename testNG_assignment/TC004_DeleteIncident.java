package week5.testNG_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC004_DeleteIncident extends BaseClass_IncidentManagement{
	
	@Test(enabled = true,dependsOnMethods="week5.testNG_assignment.TC003_ResolveIncident.resolveIncident")
	public void deleteIncident()
	{
		System.out.println("Delete Incident test case execution started:");
		System.out.println("Incident Number to be used for this method is :"+incidentNumber);
		//4. Search for the existing incident and navigate into the incident
	
		WebElement search = dom.findElementByXPath("//input[@id='sncwsgs-typeahead-input']");
		search.click();
		search.sendKeys(incidentNumber);
		
		dom.findElementByXPath("//span[text()='View results']").click();
		
		dom.findElementByXPath("//li[@class='focus-record record default global']").click();
		
		
		WebElement iframe4 = dom.findElementByXPath("//iframe[@name='gsft_main']");
		
		driver.switchTo().frame(iframe4);
		
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		driver.findElement(By.id("ok_button")).click();

		driver.switchTo().defaultContent();
		
		
		
		//6. Verify the deleted incident
		
		dom.findElementByXPath("//input[@id='sncwsgs-typeahead-input']");
		search.click();
		
		
		dom.findElementByXPath("//span[@class='sn-global-typeahead-btn -clear -global']").click();

		search.sendKeys(incidentNumber, Keys.ENTER);
	
		WebElement iframe5 = dom.findElementByXPath("//iframe[@name='gsft_main']");
		
		driver.switchTo().frame(iframe5);
		
		String deleteMsg = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		//String VerifyDeleteResult = dom.findElementByXPath("//h1[@class='now-heading -header -primary']").getText();
		
		System.out.println("Delete confirmation message :"+deleteMsg);
		
		if(deleteMsg.contains("Record not found"))
		{
			System.out.println("Incident has been deleted successfully and its confirmation message"+incidentNumber+"--"+deleteMsg);
		}
		else
		{
			System.out.println("Please check the incident ---->"+incidentNumber);
		}
	}

}
