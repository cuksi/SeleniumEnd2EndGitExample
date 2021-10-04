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

public class ValidateTitle extends Base{
	
	public WebDriver driver;
	private LandingPage l;
	
	public static Logger log = LogManager.getLogger(Base.class.getName()); 
	
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
		
	}
	
	@Test
	public void validateAppTitle() throws IOException {	
		
		
		
		l = new LandingPage(driver); 
		
		
		
		
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");		
		
		log.info("Successfully validated text message");
		

		
		
		
		
	}
	
	@Test
	public void validateEmail() {
		
		
		
		Assert.assertEquals(l.getEmail().getText(), "info@qaclickacademy.com");
		
		log.info("Successfully validated e-mail");
		
		
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		
	}
	
	

}
