package br.com.rsinet.hub_tdd.automation;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModules.Register_Action;
import br.com.rsinet.hub_tdd.util.DriverFactory;
import br.com.rsinet.hub_tdd.util.Log;
import br.com.rsinet.hub_tdd.util.Print_Func;

public class Register_TC {
	
	private static WebDriver driver;

					// INICIA O NAVEGADOR 
	@BeforeMethod
	public static void IniciarLoja() {
		DOMConfigurator.configure("log4j.xml");
		
		driver = DriverFactory.iniciaChrome();
		
		Log.info("Novo ChromeDriver instanciado!");
		
	}

						// INICIA O CADASTRO VÁLIDO
	@Test(groups = "Cadastro", priority = 0)
	public void cadastroValido() throws InterruptedException {
		
		DriverFactory.abrirSite(driver);
		Reporter.log("Aplicação Web Iniciada! (cadastro válido)");
		Log.info("Começando Cadastro Válido");
		
		Register_Action.ExecuteValid(driver, "pradov206", "emersonpradoo@hotmail.com");
		Reporter.log("Cadastrado com sucesso!");
		
		assertEquals("http://advantageonlineshopping.com/#/", driver.getCurrentUrl());
		Print_Func.captureScreenShot(driver, "cadastro_valido");
		Reporter.log("Finalizando cadastro válido");

	}
	
						// INICIA O CADASTRO INVÁLIDO
	@Test(groups = "Cadastro", priority = 1)
	public void cadastroComEmailInvalido() {
		
		DriverFactory.abrirSite(driver);
		Reporter.log("Aplicação Web Iniciada! (cadastro inválido)");
		Log.info("Começando Cadastro Inválido");
		
		Register_Action.ExecuteInvalid(driver, "prado13242", "emersonpradoo@hotmail.com2");
		assertEquals("http://advantageonlineshopping.com/#/register", driver.getCurrentUrl());
		Reporter.log("Não foi possível cadastrar o usuário!");
		
		Reporter.log("Finalizando cadastro inválido");
		
	}
	
							// FECHA O NAVEGADOR
	@AfterMethod
	public static void FecharNavegador() {
		DriverFactory.FechaChrome(driver);
	}
	

}
