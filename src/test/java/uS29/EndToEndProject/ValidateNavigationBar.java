package uS29.EndToEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;



public class ValidateNavigationBar extends Base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName()); 
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
		
		
		
	}
	
	@Test
	public void basePageNavigation() throws IOException {	
		
		LandingPage l = new LandingPage(driver);
		
		
		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());	
		
		log.info("Navigation bar is displayed");
		
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		
	}
	
	

}
