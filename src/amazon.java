import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String URL = "https://www.amazon.com/";

		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		//find the search box and search airpods and click
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("airpods");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();

		List<WebElement> ProductList = driver.findElements(By.xpath("//div[@class='a-section']//span[contains(@class,'a-size-medium a-color-base a-text-normal')]"));
		List<WebElement> PriceList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));
		System.out.println("Total earbuds are " +PriceList.size());
		
		for (int i= 0;i<PriceList.size();i++) {
			System.out.println("Product  and price are "  +ProductList.get(i).getText()+ "" +PriceList.get(i).getText());
			
		}
		
		 String ParentWindow = driver.getWindowHandle();
		    String Expected_value = ProductList.get(0).getText();
		    ProductList.get(0).click();	    
		    Set <String> allWindows =driver.getWindowHandles();
			for(String win : allWindows) {
				System.out.println(win);
				if(!win.equals(ParentWindow)) {
					driver.switchTo().window(win);
					}
				}
			 WebElement String = driver.findElement(By.id("productTitle"));
			    String ActualValue = String.getText();
			    if(ActualValue.equals(Expected_value)) {
			    	System.out.println("Title is matching");
			    }else {
			    	System.out.println("Failed in title verification");
			    }








	}



}
