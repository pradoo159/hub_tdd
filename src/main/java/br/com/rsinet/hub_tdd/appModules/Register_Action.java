package br.com.rsinet.hub_tdd.appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.LogIn_Page;
import br.com.rsinet.hub_tdd.pageObject.Register_Page;
import br.com.rsinet.hub_tdd.util.Log;
public class Register_Action {
	public static void ExecuteValid(WebDriver driver, String user, String email) {

		Home_Page.lnk_LogIn(driver).click();
		Log.info("Clicando no link login");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.lnk_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.lnk_CreateAccount(driver));
		Log.info("clique em create account");

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		Register_Page.txtbx_UserName(driver).sendKeys(user);
		Log.info("escrevendo o username");
		Register_Page.txtbx_Email(driver).sendKeys(email);
		Log.info("escrevendo o email");
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Log.info("escrevendo a senha");
		Register_Page.txtbx_ConfirmPassword(driver).sendKeys("Teste@1234");
		Log.info("escrevendo a confirmação da senha");

		Register_Page.txtbx_FirstName(driver).sendKeys("Emerson");
		Log.info("escrevendo o nome");
		Register_Page.txtbx_LastName(driver).sendKeys("Prado");
		Log.info("escrevendo o sobrenome");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("997420076");
		Log.info("escrevendo o número de telefone");

		Register_Page.listbx_Country(driver).selectByVisibleText("Brazil");
		Log.info("Selecionando o país");
		Register_Page.txtbx_City(driver).sendKeys("Osasco");
		Log.info("escrevendo o nome da cidade");
		Register_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		Log.info("escrevendo o endereço");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Log.info("escrevendo o nome do estado");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06293110");
		Log.info("escrevendo o código postal");

		Register_Page.checkbx_Agree(driver).click();
		Log.info("aceitando a checkbox de termos");
		Register_Page.btn_Register(driver).click();
		Log.info("clicando em registrar");

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
		Log.info("escrevendo o username");
		Register_Page.txtbx_Email(driver).sendKeys(email);
		Log.info("escrevendo o email");
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Log.info("escrevendo a senha");
		Register_Page.txtbx_ConfirmPassword(driver).sendKeys("Teste@1234");
		Log.info("escrevendo a confirmação da senha");

		Register_Page.txtbx_FirstName(driver).sendKeys("Emerson");
		Log.info("escrevendo o nome");
		Register_Page.txtbx_LastName(driver).sendKeys("Prado");
		Log.info("escrevendo o sobrenome");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("997420076");
		Log.info("escrevendo o número de telefone");

		Register_Page.listbx_Country(driver).selectByVisibleText("Brazil");
		Log.info("Selecionando o país");
		Register_Page.txtbx_City(driver).sendKeys("Osasco");
		Log.info("escrevendo o nome da cidade");
		Register_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		Log.info("escrevendo o endereço");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Log.info("escrevendo o nome do estado");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06293110");
		Log.info("escrevendo o código postal");

		Register_Page.checkbx_Agree(driver).click();
		Log.info("aceitando a checkbox de termos");
		Register_Page.btn_Register(driver).click();
		Log.info("clicando em registrar\n");

	}

}
