package br.com.rsinet.hub_tdd.appModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.LogIn_Page;
import br.com.rsinet.hub_tdd.pageObject.Register_Page;

public class Register_Action {

	public static void ExecuteValid(WebDriver driver, String user, String email) {

		Home_Page.lnk_LogIn(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.lnk_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.lnk_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		Register_Page.txtbx_UserName(driver).sendKeys(user);
		Register_Page.txtbx_Email(driver).sendKeys(email);
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Register_Page.txtbx_ConfirmPassword(driver).sendKeys("Teste@1234");

		Register_Page.txtbx_FirstName(driver).sendKeys("Emerson");
		Register_Page.txtbx_LastName(driver).sendKeys("Prado");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("997420076");

		Register_Page.listbx_Country(driver).selectByVisibleText("Brazil");
		Register_Page.txtbx_City(driver).sendKeys("Osasco");
		Register_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06293110");

		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btn_Register(driver).click();

		wait.until(ExpectedConditions.textToBePresentInElement(Home_Page.txt_Login(driver), user));

	}

	public static void ExecuteInvalid(WebDriver driver, String user, String email) {

		Home_Page.lnk_LogIn(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.lnk_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.lnk_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		Register_Page.txtbx_UserName(driver).sendKeys(user);
		Register_Page.txtbx_Email(driver).sendKeys(email);
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Register_Page.txtbx_ConfirmPassword(driver).sendKeys("Teste@1234");

		Register_Page.txtbx_FirstName(driver).sendKeys("Emerson");
		Register_Page.txtbx_LastName(driver).sendKeys("Prado");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("997420076");

		Register_Page.listbx_Country(driver).selectByVisibleText("Brazil");
		Register_Page.txtbx_City(driver).sendKeys("Osasco");
		Register_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06293110");

		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btn_Register(driver).click();

	}

}
