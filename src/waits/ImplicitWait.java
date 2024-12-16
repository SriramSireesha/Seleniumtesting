package waits;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ImplicitWait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
				
				WebDriver driver =new ChromeDriver();
				System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");	
				
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				//Because of the above condition (that we are giving globally ) So, it will check and execute at each and every line
				String[] Itemsneeded = {"Cucumber", "Brocolli", "Beetroot"};
			
				driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				//without creatting objects we will use this method
				
				additems(driver,Itemsneeded);

				
				//even we are calling method from same class also we need to call through object 
				
			/*	ImplicitWait I = new ImplicitWait();
				if we are using static Object creating using another method is not necessary
				I.additems(driver,Itemsneeded); */
				
				driver.findElement(By.cssSelector("img[alt='Cart']")).click();
				driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
				driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
				driver.findElement(By.cssSelector("button.promoBtn")).click();
				System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		}


public static void additems(WebDriver driver,String[] Itemsneeded) {
	int j=0;
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
		if(ItemsneededList.contains(formatedName))
		{
			j++;
		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		
		if(j==3) {
			break;
		}
		//driver.close();		
		}

}

}
}
