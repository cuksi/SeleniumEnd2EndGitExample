package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------
		//ovo su komanda koje su koristene za url i izbor browser-a iz file-a data.properties
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------
		//ovo ispod su komande za postavljanje parametara da se vuce iz Mavena
		
		//mvn test -Dbrowser=chrome  -> ovo je komanda koja se kuca prilikom pokretanja testa iz Maven-a.
		
		String browserName2 = System.getProperty("browser");	//ova ce komanda da proverava da li ima u Mavenu properties sa imenom browser
		
		System.out.println(browserName2);
		
		if(browserName2.contains("chrome")) {
			
			
			//execute in chrome driver
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			//driver = new ChromeDriver();	// ovo je komanda za pokretanje normalno chrome-a, koja je izbacena da bi radio u headless mode-u
			
			//------------------------------------------------------------------------------------------------------------------------------
			//ovo su komande koje su potrebne da bi se chrome pokrenuo u headless mode-u
			
			ChromeOptions options = new ChromeOptions();
			
			
			
				if(browserName2.contains("headless")) {
				
					options.addArguments("headless");	
					
				
				}
				
				driver = new ChromeDriver(options);
				
					
			
			
		} else if (browserName2.equals("firefox")) {
			
			//execute in firefox 
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if(browserName2.equals("IE")) {
			
			//execute in IE
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		//wait before script fail
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
																											
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
		
	}

}
