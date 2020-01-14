package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.util.Log;

public class Home_Page {

	private static WebElement element;

	public static WebElement lnk_LogIn(WebDriver driver) {

		element = driver.findElement(By.id("menuUserLink"));

		Log.info("Elemento Login encontrado");
		
		return element;

	}

	public static WebElement txt_Login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		
		Log.info("Elemento Login TextBox encontrado");

		return element;

	}
	
	public static WebElement btn_Search(WebDriver driver) {

		element = driver.findElement(By.id("searchSection"));
		
		Log.info("Elemento Botão Pesquisar encontrado");

		return element;

	}
	
	public static WebElement txtbx_Search(WebDriver driver) {

		element = driver.findElement(By.id("autoComplete"));
		
		Log.info("Elemento TextBox Pesquisar encontrado");

		return element;

	}

	public static WebElement btn_Tablet(WebDriver driver) {
		
		element = driver.findElement(By.id("tabletsTxt"));
		
		Log.info("Produto Tablet encontrado");
		
		return element;
		
	}
	
}
