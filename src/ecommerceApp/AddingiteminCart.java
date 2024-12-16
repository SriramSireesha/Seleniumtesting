package ecommerceApp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingiteminCart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(3000);
		int j=0;
		String[] Itemsneeded = {"Cucumber", "Brocolli"};
	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for (int i =0;i<products.size();i++)
		{
			//Brocolli - 1 Kg ( So, we are splitting the name with Kg's)
			
			String[] name = products.get(i).getText().split("-");
			
			//trim is used to remove white spaces in the selected list here for cucum
			String formatedName = name[0].trim();
			
			//format it to get  actual vegetables name
			//Convert array in to list easy search
			//check wheather name you extracted is present arraylist or not
			List ItemsneededList = Arrays.asList(Itemsneeded);
			Thread.sleep(3000);
		if(ItemsneededList.contains(ItemsneededList))
			{
				j++;
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			
			if(j==2) {
				break;
			}
			//driver.close();		
			}

	}

}
}



