package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
	private static WebElement element;
	
	public static WebElement lnk_LogIn(WebDriver driver) {
		
		element = driver.findElement(By.id("menuUserLink"));
		
		return element;
		
	}

}
