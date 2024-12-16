package automatingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		//https://rahulshettyacademy.com/dropdownsPractise/
		WebDriver driver =new ChromeDriver();
	
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//this method is works only Select tag
		Select dropdown = new Select(staticDropdown);
		//choosing based on index
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		//we can select based on visible text also
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//If we want to select by value that is nothingbut in html wise based on Attribute
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}
