package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.util.Log;

public class Products_Page {
	
	public static WebElement element;
	
	public static WebElement lnk_Tablet(WebDriver driver) {
		
		element = driver.findElement(By.linkText("HP ElitePad 1000 G2 Tablet"));
		
		Log.info("Produto Tablet encontrado");
		
		return element;
		
		
	}

	public static WebElement lnk_Laptop(WebDriver driver) {
		
		element = driver.findElement(By.linkText("HP Pavilion 15t Touch Laptop"));
		
		return element;
		
		
	}
	
	public static WebElement txt_NoResult(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span"));
		
		return element;
		
		
	}
	
	public static WebElement title_Product(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1"));
		
		return element;
		
		
	}
	
}
