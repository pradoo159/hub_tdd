package br.com.rsinet.hub_tdd.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
 * Classe que guarda a data e hora local em uma variável
 * 
 */

public class HoraData {

	private static final Date date = new Date();

	public static String horas() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH-mm-ss");
		return dateFormat.format(date);
	}

	public static void main(String[] args) {
		System.out.println(HoraData.horas());
	}

}
