package br.com.rsinet.hub_tdd.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.appModules.SearchByImage_Action;

public class SearchByImage_TC {

	public static void main(String[] args){

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SearchByImage_Action.Execute(driver);
		
		driver.quit();
		
	}

}
