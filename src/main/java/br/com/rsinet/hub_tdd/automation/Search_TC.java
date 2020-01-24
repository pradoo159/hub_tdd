package br.com.rsinet.hub_tdd.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModules.Search_Action;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.DriverFactory;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Print_Func;

public class Search_TC {

	private static WebDriver driver;
	private static int optionValid = 2;
	private static int optionInvalid = 4;

	// INICIA O NAVEGADOR E O EXCEL
	@BeforeMethod
	public static void IniciaNavegadorEExcel() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");

		driver = DriverFactory.iniciaChrome();

	}

	// INICIA A PESQUISA DE TEXTO POR UM PRODUTO VÁLIDO
	@Test(groups = "Procurar por texto", priority = 0)
	public void PesquisaProdutoValido() throws Exception {

		Reporter.log("Aplicação Web Iniciada! (pesquisa por texto válida)\n");
		DriverFactory.abrirSite(driver);
		
		Search_Action.ExecuteValid(driver, optionValid);
		Reporter.log("Produto encontrado!\n");
		
		String textoProduto = Products_Page.title_Product(driver).getText();
		String textoReal = ExcelUtils.getCellData(optionValid, 0);
		assertEquals(true, textoProduto.contains(textoReal.toUpperCase()));
		
		ExcelUtils.setCellData("Funcionou", optionValid, Constant.Col_Result);
		Reporter.log("Pesquisa por produto valido finalizada!\n");

		Print_Func.captureScreenShot(driver, "pesquisa_por_texto_valida");

	}

	// INICIA A PESQUISA POR TEXTO INVÁLIDA
	@Test(groups = "Procurar por texto", priority = 1)
	public void PesquisaProdutoInvalido() throws Exception {

		Reporter.log("Aplicação Web Iniciada! (pesquisa por texto inválida)\n");
		DriverFactory.abrirSite(driver);
		
		Search_Action.ExecuteInvalid(driver, optionInvalid);
		Reporter.log("Produto não encontrado!\n");
		
		String textoFalha = Products_Page.txt_NoResult(driver).getText();
		assertEquals(true, textoFalha.contains("No results for"));
		
		ExcelUtils.setCellData("Funcionou", optionInvalid, Constant.Col_Result);
		Reporter.log("Pesquisa por produto invalido finalizada!\n");

		Print_Func.captureScreenShot(driver, "pesquisa_por_texto_invalida");
	}

	// FECHA O NAVEGADOR
	@AfterMethod
	public static void FechaNavegador() throws Exception {

		DriverFactory.FechaChrome(driver);

	}

}
