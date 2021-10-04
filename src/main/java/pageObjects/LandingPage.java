package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By singIn = By.cssSelector("a[href*='sign_in']");
	
	private By title = By.cssSelector("div[class='text-center'] h2");
	
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	private By email = By.cssSelector("[href*='info@qaclickacademy.com']");
	
	
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}





	public LoginPage getLogIn() {	
		
		driver.findElement(singIn).click();
		
		LoginPage lp = new LoginPage(driver);
		
		return lp;
		
		
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
		
	}
	
	public WebElement getNavigationBar() {
		
		return driver.findElement(navBar);
		
	}
	
	public WebElement getEmail() {
		
		return driver.findElement(email);
		
	}

}
