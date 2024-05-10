package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002_Amazon {

	public static void main(String[] args) throws InterruptedException {
		//01) Launch Chrome  
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//02) Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//03) Type "Bags for b" in the Search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for b");
		
		//04) Choose the  item in the result (bags for boys)
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		
		//05) Print the total number of results (like 50000)  1-48 of over 30,000 results for "bags for boys"
		String totalResults = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		
		System.out.println("total number of results :"+totalResults);
		
		//06) Select the first brand in the left menu  (like American Tourister)
		driver.findElement(By.xpath("(//span[text()='Brand']//following::div)[1]")).click();
		
		//07) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		//08) Print the first resulting bag info (name, discounted price)
		
		String brandName = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base a-text-center']//following::h2)")).getText();
		String discountedPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		
		System.out.println("Brand Name :"+brandName+"\n"+"discountedPrice :"+discountedPrice);
		
		//09) Get the page title and close the browser(driver.close
		String title = driver.getTitle();
		System.out.println("Current Page Title :"+title);
		
		driver.close();

	}

}
