package week2.day1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC007_RadioButtonDemo {
	
	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/radio.xhtml");
		
		//Select 'Your most favourite browser' from the radio buttons
		WebElement sel =driver.findElement(By.xpath("//label[text()='Chrome']/preceding-sibling::div"));
		sel.click();
		//Click on a radio button, then click on the same radio button again to verify that	it becomes ‘unselected’.

		//Identify the radio button that is initially selected by default.
		
		
		//Check and select the age group (21-40 Years) if not already selected.
		boolean isSelectedCheck =driver.findElement(By.xpath("//input[@value='21-40 Years']")).isSelected();
		assertEquals(isSelectedCheck, true, "Value has been selected");
		driver.close();
//		if(agegroup.isSelected());
//		{
//			System.out.println("Value has been selected by default");
//		}
//		else
//		{
//			System.out.println("Value has not been selected by default");
//		}
//		
//		
		
	
	}
}
