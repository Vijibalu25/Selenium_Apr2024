package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC005_EditLead {
	
	public static void main(String[] args)
	{
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
		
		//Click on the Leads Button
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		//Click on Create Lead
		
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		
		//Enter the CompanyName Field Using Xpath
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Accenture");
		
			
		//Enter the FirstName Field Using Xpath
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Vijayalakshmi");
		
		//Enter the LastName Field Using Xpath
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Balasubramanian");
		
		//Enter the FirstName (Local) Field Using Xpath
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Viji");
		
		//Enter the Department Field Using any Locator of Your Choice
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		
		//Enter the Description Field Using any Locator of your choice
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium Automation - April");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9500768884");
		
		//Enter your email in the E-mail address Field using the locator of your choice

		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Vijibalu2225@gmail.com");
		
		//Select State/Province as NewYork Using Visible Text
		
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select selState = new Select(state);
		
		selState.selectByVisibleText("New York");
		
		//Click on the Create Button
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on the edit button
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Clear the Description Field.
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		//Fill the Important Note Field with Any text
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Edit lead is succesful");
		
		//Click on the update button
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Get the Title of the Resulting Page
		String resultPage = driver.getTitle();
		
		System.out.println(resultPage);
		
		//Close the browser window
		driver.close();
		
		
	}

}
