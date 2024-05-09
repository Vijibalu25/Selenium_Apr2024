package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC003_CheckBoxInteractions {
	
	public static void main (String[] arg) throws InterruptedException
	{
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL 
		driver.get("https://leafground.com/checkbox.xhtml");
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on the "Basic Checkbox.”
		driver.findElement(By.xpath("(//span[text()='Basic']/preceding-sibling::div)[2]")).click();
		
		//Click on the "Notification Checkbox."
		driver.findElement(By.xpath("(//span[text()='Ajax']/preceding-sibling::div)[2]")).click();
		
		//Verify that the expected message is displayed.
		String checkedText = driver.findElement(By.className("ui-growl-title")).getText();
		if(checkedText.equals("Checked"))
		{
			System.out.println("Verification Pass");
		}
		else
		{
			System.out.println("Verification failed");
		}
		
		
		//Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div")).click();

		
		//Click on the "Tri-State Checkbox."
		driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ']/parent::div")).click();
		
		
		//Verify which tri-state option has been chosen
		String triStateText = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		if(triStateText.equals("State has been changed."))
		{
			System.out.println("Tri-state option has been chosen" +triStateText);
		}
		else
		{
			System.out.println("Tri-state option has not been chosen" +triStateText);
		}
		
		
		
		//Click on the "Toggle Switch."
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		
		//Verify that the expected message is displayed.
		
		
		
		//Verify if the Checkbox is disabled.
		boolean enabled = driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget']//input)[3]")).isEnabled();
		//boolean enabled = driver.findElement(By.className("ui-chkbox-icon ui-icon ui-icon-blank ui-c")).isEnabled();
		if(enabled==true)
		{
			System.out.println("Checkbox is enabled");
		}
		else
		{
			System.out.println("Checkbox is disabled");
		}
		
		//Select multiple options on the page (details may be needed).
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s']")).click();
		
		driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']/following::label[text()='London']")).click();
		driver.findElement(By.xpath("//label[text()='Paris']")).click();
		
	
		
		
		//- Perform any additional actions or verifications required.
		
		
	
	
	}
	

}
