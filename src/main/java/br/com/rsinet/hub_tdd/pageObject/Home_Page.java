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

	public static WebElement txt_Login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));

		return element;

	}
	
	public static WebElement btn_Search(WebDriver driver) {

		element = driver.findElement(By.id("searchSection"));

		return element;

	}
	
	public static WebElement txtbx_Search(WebDriver driver) {

		element = driver.findElement(By.id("autoComplete"));
		
		return element;

	}

	public static WebElement btn_Tablet(WebDriver driver) {
		
		element = driver.findElement(By.id("tabletsTxt"));
		
		return element;
		
	}
	
	public static WebElement lnk_NotebookInvalid(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"popular_items\"]/div/div[2]/a"));
		
		return element;
		
	}
	
	public static WebElement txt_NotebookInvalid(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"popular_items\"]/div/div[2]/p"));
		
		return element;
		
	}
	
}
