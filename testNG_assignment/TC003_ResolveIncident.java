package week5.testNG_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC003_ResolveIncident extends BaseClass_IncidentManagement {
	
	@Test(enabled =true, dependsOnMethods = "week5.testNG_assignment.TC002_UpdateIncident.updateIncident")
	public void resolveIncident() throws InterruptedException
	{
		//4.  click on open and Search for the existing incident and navigate into the incident.
	
		System.out.println("Resolve Incident test case execution started:");
		System.out.println("Incident Number to be used for this method is :"+incidentNumber);

		
		WebElement search = dom.findElementByXPath("//input[@id='sncwsgs-typeahead-input']");
		search.click();
		search.sendKeys(incidentNumber);
		
		dom.findElementByXPath("//span[text()='View results']").click();
		
		dom.findElementByXPath("//li[@class='focus-record record default global']").click();
		
		
		WebElement iframe3 = dom.findElementByXPath("//iframe[@name='gsft_main']");
				
		driver.switchTo().frame(iframe3);
		
//		5. Update the state as Resolved 
		
		WebElement incidentState = driver.findElement(By.xpath("//select[@id='incident.state']"));
		
		Select iState = new Select(incidentState);
		
		iState.selectByVisibleText("Resolved");
		
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		
		Thread.sleep(3000);
		WebElement resolutionCode = driver.findElement(By.xpath("//select[@id='incident.close_code']"));
		
		Select code = new Select(resolutionCode);
		
		code.selectByValue("Workaround provided");
		
		
	   driver.findElement(By.xpath("//textarea[@id='incident.close_notes']")).sendKeys("Work around provided hence closing the ticket");
		

		
		
//		6. Click update  and verify the State
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		driver.switchTo().defaultContent();
		
		System.out.println("Resolve Incident has been completed");
		
		dom.findElementByXPath("//li[@class='focus-record record default global']").click();
		
		WebElement iframe4 = dom.findElementByXPath("//iframe[@name='gsft_main']");
		
		driver.switchTo().frame(iframe4);
		
		WebElement verifyincidentState = driver.findElement(By.xpath("//select[@id='incident.state']"));
		
		Select verifyiState = new Select(verifyincidentState);
		
		WebElement verifyFirstSelectedOption = verifyiState.getFirstSelectedOption();
		String verifyFirstSelectedOptionText = verifyFirstSelectedOption.getText();
		
        
        System.out.println("Verify the updated state :"+verifyFirstSelectedOptionText);
        if(verifyFirstSelectedOptionText.equalsIgnoreCase("Resolved")) {
        	System.out.println("Resolved incident test case is successful -->"+incidentNumber+"--"+verifyFirstSelectedOptionText);
        	
        }
        else
        {
        	System.out.println("Please check the incident --->"+incidentNumber);
        }
		
	}

}
