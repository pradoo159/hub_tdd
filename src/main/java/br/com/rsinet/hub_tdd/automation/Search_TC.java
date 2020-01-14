package br.com.rsinet.hub_tdd.automation;

import static junit.framework.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.appModules.Search_Action;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class Search_TC {
	
	private static ChromeDriver driver;
	private static int optionValid = 2;
	private static int optionInvalid = 3;

	@BeforeClass
	public static void IniciaNavegadorEExcel() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();


	}

	@Test
	public void PesquisaProdutoValido() throws Exception {

		driver.get("http://advantageonlineshopping.com/");
		Search_Action.ExecuteValid(driver, optionValid);
		String textoProduto = Products_Page.title_Product(driver).getText();
		String textoReal = ExcelUtils.getCellData(optionValid, 0);
		assertEquals(true, textoProduto.contains(textoReal.toUpperCase()));
		ExcelUtils.setCellData("Funcionou", optionValid, 1);

	}
	
	@Test
	public void PesquisaProdutoInvalido() throws Exception {

		driver.get("http://advantageonlineshopping.com/");
		Search_Action.ExecuteInvalid(driver, optionInvalid);
		String textoFalha = Products_Page.txt_NoResult(driver).getText();
		assertEquals(true, textoFalha.contains("No results for"));
		ExcelUtils.setCellData("Funcionou", optionInvalid, 1);

	}
	
	@AfterClass
	public static void FechaNavegadorOK() throws Exception {
		
		driver.close();
		
	}

}
