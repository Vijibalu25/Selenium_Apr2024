package week5.testNG_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC002_UpdateIncident extends BaseClass_IncidentManagement {
	
	@Test(enabled = true, dependsOnMethods= "week5.testNG_assignment.TC001_CreateIncident.createIncident")
   public void updateIncident() throws InterruptedException
		 {
		System.out.println("Update Incident test case execution started:");
		System.out.println("Incident Number to be used for this method is :"+incidentNumber);
		
		WebElement search = dom.findElementByXPath("//input[@id='sncwsgs-typeahead-input']");
		search.click();
		search.sendKeys(incidentNumber);
		
		dom.findElementByXPath("//span[text()='View results']").click();
	
		dom.findElementByXPath("//li[@class='focus-record record default global']").click();
		
		
		WebElement iframe1 = dom.findElementByXPath("//iframe[@name='gsft_main']");
				
		driver.switchTo().frame(iframe1);
		
		
		//5. Update the incidents with Urgency as High and State as In Progress
		
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		
		Select secState=new Select(state);
		secState.selectByVisibleText("In Progress");
		
		WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		
		Select secUr = new Select(urgency);
		secUr.selectByValue("1");
		
		driver.findElement(By.xpath("(//textarea[@placeholder='Work notes'])[1]")).sendKeys("Changed the status to in progress");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		driver.switchTo().defaultContent();
		
		System.out.println("Updated the incident");
		
		//6. Verify the priority and state 
		
		 Thread.sleep(3000);
		 dom.findElementByXPath("//li[@class='focus-record record default global']").click();
		 
         WebElement iframe2 = dom.findElementByXPath("//iframe[@id='gsft_main']");
         driver.switchTo().frame(iframe2);
         
         WebElement verifyStateOption = driver.findElement(By.xpath("//select[@id='incident.state']"));
 	
 		 Select VerifysecState=new Select(verifyStateOption);
         WebElement selectedOption = VerifysecState.getFirstSelectedOption();
         String selectedOptiontext = selectedOption.getText();
         
		
		 Thread.sleep(3000);
		// String verifyState = driver.findElement(By.xpath("//span[text()='Incident state']//following::span")).getText();
		 
		 if(selectedOptiontext.equalsIgnoreCase("in progress"))
		 {
			  	System.out.println("Update incident test case is successful -->"+incidentNumber+"--"+selectedOptiontext);
	        
		 }
		 
	        else
	        {
	        	System.out.println("Please check the incident --->"+incidentNumber);
	        }
			
		
		
		
		
		}
		
}