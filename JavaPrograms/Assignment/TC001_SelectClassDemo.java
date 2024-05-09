package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC001_SelectClassDemo {
	
	public static void main(String[] args)
	{

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://en-gb.facebook.com");
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Vijayalakshmi");
		driver.findElement(By.name("lastname")).sendKeys("Balasubamanian");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("vijibalu22255@gmail.com");
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Faceb00k1123");
		WebElement day = driver.findElement(By.name("birthday_day"));
		
		Select bday = new Select(day);
		bday.selectByValue("4");
		
       WebElement month = driver.findElement(By.id("month"));
		
		Select bmonth = new Select(month);
		bmonth.selectByVisibleText("May");
		
		WebElement year = driver.findElement(By.id("year"));
		
		Select byear = new Select(year);
		byear.selectByVisibleText("1991");
		WebElement gender = driver.findElement(By.xpath("//input[@name='sex']/preceding::label[text()='Female']"));
		gender.click();
		
		if(gender.isEnabled())
		{
			System.out.println("Gender is selected"+"\n"+"Test case is passed");
			driver.close();
		}
		else
		{
			System.out.println("Gender is not slected"+"\n"+"Test case is failed");
		}

		
	}

}
