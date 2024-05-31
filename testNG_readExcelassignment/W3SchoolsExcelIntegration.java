package week5.testNG_readExcelassignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class W3SchoolsExcelIntegration {
	
	@DataProvider()
	public String[][] data() throws IOException
	{
		//ReadExcel rd = new ReadExcel();
		
		//String[][] data = rd.readexcel();
		//return data;
		
		return ReadExcel.readexcel();
	}
	@Test(dataProvider = "data")
	public void integrateExcel(String cardName, String ccNum, String cVV, String fullName, String eMail, String address, String city, String zip,String state)
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_checkout_form");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame("iframeResult");
		
		//Name on Card: [Provide a data from Excel sheet]
		driver.findElement(By.id("cname")).sendKeys(cardName);
		
		//Credit card number: [Provide a data from Excel sheet]
		driver.findElement(By.id("ccnum")).sendKeys(ccNum);
		
		//Exp Month: Oct
		driver.findElement(By.id("expmonth")).sendKeys("September");
		
		//CVV: [Provide a data from Excel sheet]
		driver.findElement(By.id("cvv")).sendKeys(cVV);
		
		//Exp Year: 2018
		driver.findElement(By.id("expyear")).sendKeys("2018");
		
		//Full Name: [Provide a data from Excel sheet]
		driver.findElement(By.id("fname")).sendKeys(fullName);
		
		//Email: [Provide a data from Excel sheet ]
		driver.findElement(By.id("email")).sendKeys(eMail);
		
		//Address: [Provide a data from Excel sheet]
		driver.findElement(By.id("adr")).sendKeys(address);
		
		//City: [Provide a data from Excel sheet]
		driver.findElement(By.id("city")).sendKeys(city);
		
		//Zip: [Provide a data from Excel sheet]
		driver.findElement(By.id("zip")).sendKeys(zip);
		
		//State: [Provide a data from Excel sheet]
		driver.findElement(By.id("state")).sendKeys(state);
		
		
	}

}
