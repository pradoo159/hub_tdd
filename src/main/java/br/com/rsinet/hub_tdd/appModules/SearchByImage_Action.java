package br.com.rsinet.hub_tdd.appModules;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;

public class SearchByImage_Action {
	
	// Método que faz a pesquisa por imagem válida
	public static void ExecuteValid(WebDriver driver) throws Exception{
		
		Home_Page.btn_Tablet(driver).click();
		
		Products_Page.lnk_Tablet(driver).click();
		
	}
	
	// Método que faz a pesquisa por imagem inválida
	public static void ExecuteInvalid(WebDriver driver) {
		
		Home_Page.lnk_NotebookInvalid(driver).click();
		
	}

}
