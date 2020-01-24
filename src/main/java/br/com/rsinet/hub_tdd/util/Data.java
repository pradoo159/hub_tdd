package br.com.rsinet.hub_tdd.util;

/*
 * Classe que armazena dados do excel em métodos estáticos
 */

public class Data{

	public static String nomeTablet() throws Exception { 
		return ExcelUtils.getCellData(1, 0);
	}
	
	public static String nomeLaptop() throws Exception { 
		return ExcelUtils.getCellData(2, 0);
	}
	
	public static String resultadoTablet() throws Exception { 
		return ExcelUtils.getCellData(1, 1);
	}
	
	public static String resultadoLaptop() throws Exception { 
		return ExcelUtils.getCellData(2, 1);
	}
	
	public static String pesquisaInvalida1() throws Exception { 
		return ExcelUtils.getCellData(3, 0);
	}
	
	public static String pesquisaInvalida2() throws Exception { 
		return ExcelUtils.getCellData(4, 0);
	}
	
	public static String resultadoPesquisaInvalida1() throws Exception { 
		return ExcelUtils.getCellData(3, 1);
	}
	
	public static String resultadoPesquisaInvalida2() throws Exception { 
		return ExcelUtils.getCellData(4, 1);
	}
	
}
