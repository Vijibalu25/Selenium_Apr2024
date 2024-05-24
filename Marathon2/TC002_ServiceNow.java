package Marathon2;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class TC002_ServiceNow {
	
	public static void main(String[] arg) throws InterruptedException, IOException
	{
		
		ChromeDriver driver = new ChromeDriver();
		
        driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Launch a web browser.
		driver.get("https://dev200784.service-now.com/");
		
		//Enter the username and the password 
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		
		driver.findElement(By.id("user_password")).sendKeys("k6C8-ajUWqY%");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		Thread.sleep(6000);
		
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(10);
		
		WebElement all = dom.findElementByXPath("//div[@aria-label='All']");
		
		all.click();
		
		
		//dom.setImplicitWait(10);
		//Thread.sleep(5000);
		WebElement serviceCataloge = dom.findElementByXPath("//input[@id='filter']");
		serviceCataloge.sendKeys("Service Catalog", Keys.ENTER);
		
		//Thread.sleep(5000);
		WebElement sc = dom.findElementByXPath("//a[@aria-label='Service Catalog']");
		sc.click();
		
		//Click on "Mobiles."
		WebElement iframeDom = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframeDom);
		
		//Thread.sleep(7000);
		//driver.findElement(By.xpath("(//div[@class=' drag_section_part glide-grid-block'])[8]//table[1]/tbody/tr/td[4]/a")).click();
		
		//driver.findElement(By.xpath("(//div[@id='com.glideapp.servicecatalog.RenderCategory_0171654541786008']//table/tbody/tr/td)[4]/a")).click();
		
		driver.findElement(By.xpath("(//h2[contains(text(),'Mobile')]/ancestor::a)[2]")).click();
		
		//Click on "Apple MacBook Pro 13."
		
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']/ancestor::a")).click();
		
		//Choose all mandatory fields
		//Is this a replacement for a lost or broken iPhone?
		WebElement yes = driver.findElement(By.xpath("//label[text()='Yes']"));
		yes.click();
		
		//What was the original phone number?
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("0123456789");
		
		//Monthly data allowance
		WebElement DataAllowance = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		
		Select selectDataAllowance = new Select(DataAllowance);
		selectDataAllowance.selectByValue("unlimited");
		
		//Choose the colour
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		
		//Choose the storage
		driver.findElement(By.xpath("//label[contains(text(),'512 GB')]")).click();
		
		
			
		//Click on "Order now"
		driver.findElement(By.id("oi_order_now_button")).click();
		
		//Print the order message.
		String success = driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();
		
		System.out.println("Print the order message :"+success);
		
		//Print the request number
		
		String requestNumber = driver.findElement(By.xpath("//a[@class='linked requestItemUrl']/b")).getText();
		System.out.println("Request Number :"+requestNumber);
		
		//Take a snap of the resulting page.
		File src = driver.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\Dell\\Desktop\\MyProject\\Selenium\\src\\main\\java\\Marathon2\\ServiceRequestSnap.png");
		
		FileUtils.copyFile(src, des);
		
		

		//Close the browser
		driver.close();
		
		
		
	
	}

}
