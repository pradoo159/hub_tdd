package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.util.Log;

public class LogIn_Page {

	private static WebElement element;

	public static WebElement txtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.name("username"));
		
		Log.info("Elemento TextBox Username encontrado");

		return element;

	}

	public static WebElement txtbx_Password(WebDriver driver) {

		element = driver.findElement(By.name("password"));
		
		Log.info("Elemento TextBox Password encontrado");

		return element;

	}

	public static WebElement btn_SignIn(WebDriver driver) {

		element = driver.findElement(By.id("sign_in_btnundefined"));
		
		Log.info("Elemento Botão SignIn encontrado");

		return element;

	}

	public static WebElement lnk_CreateAccount(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		
		Log.info("Elemento Botão Create Account encontrado");

		return element;

	}

}
