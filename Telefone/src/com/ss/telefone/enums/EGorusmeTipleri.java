package com.ss.telefone.enums;

public enum EGorusmeTipleri {
	
	TELEFON (1,"Telefon"),
	YUZYUZE(2,"Yuzyuze");
	
	int id;
	String tip;
	
	EGorusmeTipleri(int id,String tip) {
		this.id=id;
		this.tip=tip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	
	
}
