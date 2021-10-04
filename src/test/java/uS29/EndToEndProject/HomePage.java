package uS29.EndToEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName()); 
	
	@BeforeMethod	
	public void initialize() throws IOException {		
		driver = initializeDriver();
		
		log.info("Driver is initialized");		
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {	
		
		
		
		LandingPage l = new LandingPage(driver);
		
		
		
		LoginPage lp = l.getLogIn();	
		
		log.info("Successfully navigated to login page");
		
		
		
		lp.getEmail().sendKeys(username);
		
		log.info("Successfully entered user name");
		
		lp.getPassword().sendKeys(password);
		
		log.info("Successfully entered password");
		
		
		
		log.info(text);
		
		
		
		lp.getLogin().click();
		
		log.info("Successfully clicked on login button");
		
		ForgotPassword fp = lp.forgotPassword();	
		
		fp.getEmail().sendKeys("xxx@xxx.com");	
		
		fp.sendMeInstructions().click();	
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		
		
		Object[][] data = new Object[2][3];
		
		//0th row
		data[0][0] = "nonRestricetedUser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non Restricted User";
		
		//1th row
		
		data[1][0] = "restrictedUser@qw.com";
		data[1][1] = "123456";
		data[1][2] = "Restricted User";
		
		
		return data;
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.close();
		
	}

}
