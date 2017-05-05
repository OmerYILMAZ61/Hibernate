package com.ss.telefone.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SorgulaEnitity {

	Date basTar;
	Date bitTar;
	String adSoyad;
	String gorTip;
	
	
	public Date getBasTar() {
		return basTar;
	}
	public void setBasTar(String basTar) {
		this.basTar = convertStringToDate(basTar);
	}
	public Date getBitTar() {
		return bitTar;
	}
	public void setBitTar(String bitTar) {
		this.bitTar = convertStringToDate(bitTar);
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String getGorTip() {
		return gorTip;
	}
	public void setGorTip(String gorTip) {
		this.gorTip = gorTip;
	}
	
	public Date convertStringToDate(String date){
		if(date.equals("  -  -    "))
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date basTarihDate = null;
		try {
			basTarihDate = formatter.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return basTarihDate;
	}
	
}
