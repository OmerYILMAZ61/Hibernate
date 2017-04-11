package com.ss.secim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parti {

	@Id
	int id;
	
	@Column(name = "isim",nullable=true)
	String name;
	
	
	int oy_sayisi;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getOy_sayisi() {
		return oy_sayisi;
	}


	public void setOy_sayisi(int oy_sayisi) {
		this.oy_sayisi = oy_sayisi;
	}
	
	
}
