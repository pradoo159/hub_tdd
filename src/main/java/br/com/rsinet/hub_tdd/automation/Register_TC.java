package br.com.rsinet.hub_tdd.automation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModules.Register_Action;
import br.com.rsinet.hub_tdd.util.Log;
import br.com.rsinet.hub_tdd.util.Print_Func;

public class Register_TC {
	
	private static ChromeDriver driver;

	@BeforeClass
	public static void IniciarLoja() {
		DOMConfigurator.configure("log4j.xml");
		driver = new ChromeDriver();
		
		Log.info("Novo ChromeDriver instanciado!");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void cadastroValido() throws InterruptedException {
		driver.get("http://advantageonlineshopping.com/");
		Reporter.log("Aplicação Web Iniciada!");
		Log.info("Começando Cadastro Válido");
		Register_Action.ExecuteValid(driver, "pradov3", "emersonpradov3@hotmail.com");
		Reporter.log("Cadastrado com sucesso!");
		
		assertEquals("http://advantageonlineshopping.com/#/", driver.getCurrentUrl());
		Print_Func.captureScreenShot(driver);

	}
	
	@Test(priority = 1)
	public void cadastroComEmailInvalido() {
		driver.get("http://advantageonlineshopping.com/");
		Reporter.log("Aplicação Web Iniciada!");
		Log.info("Começando Cadastro Inválido");
		Register_Action.ExecuteInvalid(driver, "prado13242", "emersonpradoo@hotmail.com2");
		Reporter.log("Erro ao cadastrar usuário");
		
		assertEquals("http://advantageonlineshopping.com/#/register", driver.getCurrentUrl());
		Print_Func.captureScreenShot(driver);
		
	}
	
	@AfterClass
	public static void FecharNavegador() {
		driver.quit();
		Log.endTestCase("Register Test Case");
		
	}

}
