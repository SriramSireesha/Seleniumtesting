package miscellaneoustopics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handlingcertifications {

	public static void main(String[] args) {
		//chromeoptions method help to access the expired appilications
		ChromeOptions options =new ChromeOptions();
		//proxy method is used to tst the proxy of chrome behaviour
		//options.addExtentions("proxy",value)......this will gives the plugins for opened (testing browser) we are adding extentios
		Proxy proxy = new Proxy();
		//thebelow ipadrress dev or network team will give
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.defalut_directory", prefs);
		
		WebDriver driver =new ChromeDriver();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:SireeshaEclipse\\automationSelenium\\chromedriver-win64\\chromedriver.exe");
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		

	}

}
