package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC004_DeleteLead {
	
	public static void main(String[] args) throws InterruptedException
	{
	
	//Initialize the WebDriver (ChromeDriver)
	ChromeDriver driver = new ChromeDriver();
	
	//Load the URL http://leaftaps.com/opentaps/
	driver.get("http://leaftaps.com/opentaps/");
	
	//Maximize the browser window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Enter the Username
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	
	//Enter Password
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	
	//Click on the Login Button.
	driver.findElement(By.className("decorativeSubmit")).click();
	
	//Click on the CRM/SFA Link
	driver.findElement(By.partialLinkText("CRM/SFA")).click();
	
	
	//Click on the Leads Button
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
	
	//Click "Find leads
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	
	//Click on the "Phone" tab.
	
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	
	//Enter the phone number
	driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
	
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9500768884");
	
	//Click the "Find leads" button
	
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
	//Capture the lead ID of the first resulting lead
	Thread.sleep(2000);
	String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).getText();
	//String leadID = driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])")).getText();
	
	
	System.out.println("Lead ID :"+leadID);
	
	//Click the first resulting lead
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
	
	//Click the "Delete" button
	driver.findElement(By.className("subMenuButtonDangerous")).click();
	
	//Click "Find leads" again
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	
	//Enter the captured lead ID
	
	driver.findElement(By.xpath("//label[text()='Lead ID:']//following::input[@name='id']")).sendKeys(leadID);
	
	//Click the "Find leads" button
	
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);	
	
	//Verify the presence of the message "No records to display" in the Lead List. This	message confirms the successful deletion.
	String verifyLeadID = driver.findElement(By.className("x-paging-info")).getText();
	
	System.out.println(verifyLeadID);
	
	if(verifyLeadID.equals("No records to display"))
	{
		System.out.println("Lead ID has been deleted succesfully");
		driver.close();
	}
	else
	{
		System.out.println("Lead Id is not deleted");
	}
	
}
}
