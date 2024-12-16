package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExample3 {

	public static void main(String[] args) {
		//sibling - parent traverse
		WebDriver driver = new ChromeDriver();
		
		/*Due to Selenium manager even we are not given the path for the chrome it will contnue the testing
		 * Selenium Manager will work on the backend it will automatically detect the link of browser based on 18th line and it will execute'
		 * This is the latest feature*/
		//System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//paerent to child Mechanism
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getTagName());
		//parent-grandparent-child
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
