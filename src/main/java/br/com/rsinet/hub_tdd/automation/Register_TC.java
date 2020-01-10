package br.com.rsinet.hub_tdd.automation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.appModules.Register_Action;
import br.com.rsinet.hub_tdd.util.Print_Func;
import junit.framework.Assert;

public class Register_TC {
	
	private static ChromeDriver driver;

	@BeforeClass
	public static void IniciarLoja() {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void cadastroValido() throws InterruptedException {
		driver.get("http://advantageonlineshopping.com/");
		Register_Action.ExecuteValid(driver, "pradov3", "emersonpradov3@hotmail.com");
		
		assertEquals("http://advantageonlineshopping.com/#/", driver.getCurrentUrl());
		Print_Func.captureScreenShot(driver);

	}
	
	@Test
	public void cadastroComEmailInvalido() {
		driver.get("http://advantageonlineshopping.com/");
		Register_Action.ExecuteInvalid(driver, "prado13242", "emersonpradoo@hotmail.com2");
		
		assertEquals("http://advantageonlineshopping.com/#/register", driver.getCurrentUrl());
		Print_Func.captureScreenShot(driver);
		
	}
	
	@AfterClass
	public static void FecharNavegador() {
		driver.quit();
		
	}

}
