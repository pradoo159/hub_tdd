package br.com.rsinet.hub_tdd.appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.util.Data;

public class Search_Action {

	public static void ExecuteValid(WebDriver driver, int option) throws Exception {

		Home_Page.btn_Search(driver).click();

		if (option == 1) {

			String excelOption = Data.nomeTablet();
			
			Home_Page.txtbx_Search(driver).sendKeys(excelOption);
			Home_Page.txtbx_Search(driver).sendKeys(Keys.ENTER);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"search\"]/div/div")));
			Products_Page.lnk_Tablet(driver).click();

		} else if (option == 2) {

			String excelOption = Data.nomeLaptop();
			
			Home_Page.txtbx_Search(driver).sendKeys(excelOption);
			Home_Page.txtbx_Search(driver).sendKeys(Keys.ENTER);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"search\"]/div/div")));
			Products_Page.lnk_Laptop(driver).click();
			
		}

	}
	
	public static void ExecuteInvalid(WebDriver driver, int option) throws Exception {
		
		Home_Page.btn_Search(driver).click();
		
		if (option == 3) {

			String excelOption = Data.pesquisaInvalida1();
			
			Home_Page.txtbx_Search(driver).sendKeys(excelOption);
			Home_Page.txtbx_Search(driver).sendKeys(Keys.ENTER);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"search\"]/div/div")));

		} else if (option == 4) {
			
			String excelOption = Data.pesquisaInvalida2();
			
			Home_Page.txtbx_Search(driver).sendKeys(excelOption);
			Home_Page.txtbx_Search(driver).sendKeys(Keys.ENTER);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"search\"]/div/div")));
			
		}
		
	}

}
