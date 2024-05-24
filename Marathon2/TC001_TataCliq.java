package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC001_TataCliq {
	
	public static void main (String[] arg) throws InterruptedException, IOException

	{
		
	
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		
		//Handled Sweet Alert
		driver.findElement(By.id("wzrk-cancel")).click();
		
		
		//MouseHover on 'Brands'
		WebElement brand = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(brand).perform();
		
		//MouseHover on 'Watches & Accessories'
		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		
		builder.moveToElement(watches).perform();
		
		
		//Choose the first option from the 'Featured brands'
		driver.findElement(By.xpath("(//div[@class='DesktopHeader__featureBrands']//div)[2]")).click();
		
		//Select sortby: New Arrivals
		
		WebElement sort = driver.findElement(By.xpath("//select[@label='Popularity']"));
		
		Select sorting = new Select(sort);
		
		sorting.selectByValue("isProductNew");
		
		
		//choose men from catagories filter
		
		driver.findElement(By.xpath("//div[@class='FilterDesktop__newFilCheckbox']")).click();
		
		Thread.sleep(3000);
		//print all price of watches

		List<WebElement> prices = driver.findElements(By.xpath("(//div[@class='ProductDescription__priceHolder']/h3)"));
		
		String price1 = prices.get(0).getText();
		
		
		for(int i=0; i<=prices.size()-1;i++)
		{
			String price = prices.get(i).getText();
			System.out.println(price);
		}
		
		//click on the first resulting watch.
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])")).click();
		
		Set<String> childWindow = driver.getWindowHandles();
		
		List<String> cWindow = new ArrayList<>(childWindow);
		
		driver.switchTo().window(cWindow.get(1));
		
		//compare two price are similar
		
		String firstPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		String fp = firstPrice.replaceAll("[A-Za-z]", "");
		String finalPrice1 = fp.replace(":", "");
		String finalPrice = finalPrice1.replace(" ", "");
		
		
		System.out.println("Compare :"+finalPrice);
		
		if(price1.equalsIgnoreCase(finalPrice))
			
		{
			System.out.println("Comparing the price value :"+price1+firstPrice);
		}
		
	
		
		//click Add to cart and get count from the cart icon
		
		driver.findElement(By.xpath("(//div[@class='ProductDescriptionPage__buttonAddToBag '])[2]")).click();
		
		String cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		
		System.out.println("Added cart Count is :"+cartCount);
		
		//Click on the cart
		driver.findElement(By.className("DesktopHeader__cartCount")).click();
		
		Thread.sleep(2000);
		//Take a snap of the resulting page.
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\Dell\\Desktop\\MyProject\\Selenium\\src\\main\\java\\Marathon2\\cart.png");
		
		FileUtils.copyFile(src, des);
		
		
		Thread.sleep(3000);
		
		//All the opened windows one by one.
		
	
		driver.close();
		
		driver.quit();
		
		
		
		

	}
}
