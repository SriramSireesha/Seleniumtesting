package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locatrorsexample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		//https://rahulshettyacademy.com/AutomationPractice/
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//id
		driver.findElement(By.id("inputUsername")).sendKeys("Sireesha");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		//classnamewithID[input#id]
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//cssselector-->with-->tag.classname
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Hey");
		//css selector
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("siri@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		//xpath with child
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("sireesha@gmail.com");
		
		//css with child
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("7494868939");
		
		//Tagname
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7628949030");
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		//cssselector with childclass 
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		//Advanced locators 
		//cssselectorwithid or input#inputUsername
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("eesha");
		
		//cssSelector with Regularn expression
		driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys("rahulshettyacademy");
		
		//xpathwithregular expression --> contains
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
