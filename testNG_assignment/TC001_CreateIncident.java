package week5.testNG_assignment;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;



public class TC001_CreateIncident extends BaseClass_IncidentManagement{
	
	@Test(priority=1)
	public  void createIncident() throws InterruptedException
	{
	
		//4. Click on Create new button and fill the manadatory fields and Click Submit
		
		WebElement iframeEle = dom.findElementByXPath("//iframe[@id='gsft_main']");
		
		driver.switchTo().frame(iframeEle);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		
		System.out.println(incidentNumber);
		
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		
		
	    Set<String> childWindow = driver.getWindowHandles();	
         List<String> wLists = new ArrayList<>(childWindow);
     	driver.switchTo().window(wLists.get(1));
     	     	
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Vijayalakshmi", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tbody//tr//td[3]/a")).click();
		
		driver.switchTo().window(parentWindow);
		
		driver.switchTo().frame(iframeEle);
	
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Windows Account Locked");
	
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)

		
	
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
			
		
		WebElement search = dom.findElementByXPath("//input[@id='sncwsgs-typeahead-input']");
		search.click();
		search.sendKeys(incidentNumber);
		
		dom.findElementByXPath("//span[text()='View results']").click();
		
		dom.findElementByXPath("//li[@class='focus-record record default global']").click();
		
		Thread.sleep(5000);
		String title = driver.getTitle();
		
		System.out.println("Page title  --->"+title);
		
		//String verifyInci = driver.findElement(By.xpath("//div[@class='navbar-title-display-value']")).getText();
		//String verifyInci = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		
	
		
		if(title.contains(incidentNumber))
		{
			System.out.println("Incident has been logged succesfully----->" +incidentNumber);
			
			
		}
		else
		{
			System.out.println("Please check  ---->" +incidentNumber);
		}
		
	}	
	
	  
		
	}


