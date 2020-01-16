package br.com.rsinet.hub_tdd.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModules.SearchByImage_Action;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.Data;
import br.com.rsinet.hub_tdd.util.Driver;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class SearchByImage_TC {
	
	private static WebDriver driver;
	
	@BeforeMethod
	public static void IniciaNavegador() throws Exception {
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		
		driver = Driver.iniciaChrome();
		
	}

	@Test(groups = "Procurar por imagem" ,priority = 0)
	public static void SearchByImageValid() throws Exception{
		
		driver.get(Constant.URL);
		
		SearchByImage_Action.ExecuteValid(driver);
		
		String tituloTablet = Products_Page.title_Product(driver).getText();
		String produtoClicado = Data.nomeTablet().toUpperCase();
		System.out.println(produtoClicado);
		
		assertEquals(tituloTablet.equals(produtoClicado), true);
	}
	
	@Test(groups = "Procurar por imagem" ,priority = 1)
	public static void SearchByImageInvalid() throws InterruptedException{
		
		driver.get(Constant.URL);
		
		String txtNotebookHome = Home_Page.txt_NotebookInvalid(driver).getText();
		
		SearchByImage_Action.ExecuteInvalid(driver);
		
		String txtNotebookProduct = Products_Page.title_Product(driver).getText();
		
		assertEquals(txtNotebookHome.contentEquals(txtNotebookProduct), false);
		
	}
	
	@AfterMethod
	public static void FechaNavegador() {
		
		Driver.FechaChrome(driver);
		
	}

}
