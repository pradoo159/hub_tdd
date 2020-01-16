package br.com.rsinet.hub_tdd.automation;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModules.Register_Action;
import br.com.rsinet.hub_tdd.util.Driver;
import br.com.rsinet.hub_tdd.util.Log;
import br.com.rsinet.hub_tdd.util.Print_Func;

public class Register_TC {
	
	private static WebDriver driver;

	@BeforeMethod
	public static void IniciarLoja() {
		DOMConfigurator.configure("log4j.xml");
		
		driver = Driver.iniciaChrome();
		
		Log.info("Novo ChromeDriver instanciado!");
		
	}

	@Test(groups = "Cadastro", priority = 0)
	public void cadastroValido() throws InterruptedException {
		
		driver.get("http://advantageonlineshopping.com/");
		Reporter.log("Aplicação Web Iniciada! (cadastro válido)");
		Log.info("Começando Cadastro Válido");
		
		Register_Action.ExecuteValid(driver, "pradov001", "emersonpradov001@hotmail.com");
		Reporter.log("Cadastrado com sucesso!");
		
		assertEquals("http://advantageonlineshopping.com/#/", driver.getCurrentUrl());
		Print_Func.captureScreenShot(driver);
		Reporter.log("Finalizando cadastro válido");

	}
	
	@Test(groups = "Cadastro", priority = 1)
	public void cadastroComEmailInvalido() {
		
		driver.get("http://advantageonlineshopping.com/");
		Reporter.log("Aplicação Web Iniciada! (cadastro inválido)");
		Log.info("Começando Cadastro Inválido");
		
		Register_Action.ExecuteInvalid(driver, "prado13242", "emersonpradoo@hotmail.com2");
		assertEquals("http://advantageonlineshopping.com/#/register", driver.getCurrentUrl());
		Reporter.log("Não foi possível cadastrar o usuário!");
		
		Print_Func.captureScreenShot(driver);
		Reporter.log("Finalizando cadastro inválido");
		
	}
	
	@AfterMethod
	public static void FecharNavegador() {
		Driver.FechaChrome(driver);
		
	}

}
