package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capturing the all elements
		List<WebElement> veg=driver.findElements(By.xpath("//tr/td[1]"));
		
		//capturing all elements
		List<String> originalList=veg.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		System.out.print(sortedList);
		///compare original list vs sortd list
		Assert.assertTrue(originalList.equals(sortedList));
	}

}
