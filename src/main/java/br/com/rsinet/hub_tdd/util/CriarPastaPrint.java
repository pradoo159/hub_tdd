package br.com.rsinet.hub_tdd.util;

import java.io.File;

import org.testng.annotations.BeforeSuite;

/*
 * Classe que cria uma pasta por suite para armazenar screenshots dos cenários
 */

public class CriarPastaPrint {
	
	public static String diretorioPasta = System.getProperty("user.dir") + "/screenshots/" + HoraData.horas();
	
	@BeforeSuite
	private void PastaScreenshot() {
		File pastaPrint = new File(diretorioPasta);
		pastaPrint.mkdir();
	}

}
