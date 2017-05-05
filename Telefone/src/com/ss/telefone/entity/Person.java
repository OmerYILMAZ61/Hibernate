package com.ss.telefone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	int id;

	@Column(name = "ad_soyad")
	String adSoyad;

	String telefon;

	@Column(name = "gorusme_tipi")
	String gorusmeTipi;

	@Column(name = "gorusme_zamani")
	Date gorusmeZamani;
	
	String mesaj;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getGorusmeTipi() {
		return gorusmeTipi;
	}

	public void setGorusmeTipi(String gorusmeTipi) {
		this.gorusmeTipi = gorusmeTipi;
	}

	public Date getGorusmeZamani() {
		return gorusmeZamani;
	}

	public void setGorusmeZamani(Date gorusmeZamani) {
		this.gorusmeZamani = gorusmeZamani;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	public String getMesaj() {
		return mesaj;
	}
	
	
}
