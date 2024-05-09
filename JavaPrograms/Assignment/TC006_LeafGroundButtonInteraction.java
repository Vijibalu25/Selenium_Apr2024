package week2.day1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC006_LeafGroundButtonInteraction {
	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/button.xhtml");
		
		//Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String title = driver.getTitle();
		if(title.equalsIgnoreCase(title))
		{
			System.out.println("Click and Confirm title Test case is pass");
		}
		else
		{
			System.out.println("Click and Confirm title Test case is fail");
		}
		
		
	
		//Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
		driver.navigate().back();
	   
	  // boolean isEnabledButton = driver.findElement(By.xpath("//button[@type='button']//span[text()='Disabled']")).isEnabled();
	   String text = driver.findElement(By.xpath("(//h5[text()='Confirm if the button is disabled.']//following::button[@type='button'])[1]")).getText();
	   System.out.println(text);
	   if(driver.findElement(By.xpath("(//h5[text()='Confirm if the button is disabled.']//following::button[@type='button'])[1]")).isEnabled())
	   {
		   System.out.println("It is enabled");
	   }
	   else
	   {
		   System.out.println("It is not enabled");
		  // driver.close();
	   }
	   
	   //Find and print the position of the button with the text ‘Submit.’
	   String text1 = driver.findElement(By.xpath("(//h5[text()='Find the position of the Submit button']//following::span[text()='Submit'])[1]")).getText();
	   System.out.println(text1);
	  Rectangle res=  driver.findElement(By.xpath("(//h5[text()='Find the position of the Submit button']//following::span[text()='Submit'])[1]")).getRect();
	  System.out.println(res);

	  //Find and print the background color of the button with the text ‘Find the Save button color.’
	  String saveText = driver.findElement(By.xpath("//h5[text()='Find the Save button color']//following::span[text()='Save']")).getText();
	  String buttoncolor=driver.findElement(By.xpath("//h5[text()='Find the Save button color']//following::span[text()='Save']")).getCssValue(("backgroundColor"));
	  System.out.println(buttoncolor +""+saveText);
	  
	  //Find and print the height and width of the button with the text ‘Find the height and width of this button.’
	  
	
	}

}
