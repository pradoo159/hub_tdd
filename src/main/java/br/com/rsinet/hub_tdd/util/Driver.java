package br.com.rsinet.hub_tdd.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver iniciaChrome() {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}

	public static void FechaChrome(WebDriver driver) {

		driver.close();

	}

}
