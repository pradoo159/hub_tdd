package br.com.rsinet.hub_tdd.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.appModules.Register_Action;

public class Register_TC {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {

			WebDriver driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get("http://advantageonlineshopping.com/");

			Register_Action.Execute(driver);

			driver.quit();
		}

	}

}
