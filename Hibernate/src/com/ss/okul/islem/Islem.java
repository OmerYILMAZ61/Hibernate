package com.ss.okul.islem;

import java.util.Scanner;

import org.hibernate.Session;

import com.ss.okul.entitiy.Ogrenci;
import com.ss.okul.entitiy.Okul;

public class Islem {

	public static void main(String[] args) {
		
		DOA doa = new DOA();
		Scanner sc = new Scanner(System.in);
		
//		addOkul(doa,sc);
//		getOkul(doa,sc);
//		addOgrenci(doa,sc,okul);
		sc.close();
	}

	private static void addOkul(DOA doa, Scanner sc) {
		Okul okul = new Okul();
		System.out.println("okul ismi");
		okul.setName("dedeman");
	
		doa.addOkul(okul);
		
	}

	private static void getOkul(DOA doa, Scanner sc) {
		
		
	}

	private static void addOgrenci(DOA doa, Scanner sc,Okul okul) {
		System.out.println("ogrenci bilgilerini giriniz");
		Ogrenci ogrenci = new Ogrenci();
		
		System.out.println("ogrenci ismi");
		ogrenci.setName(sc.next());
		
		System.out.println("okul idyi giriniz");
		ogrenci.setOkul(okul);
		doa.addOgrenci(ogrenci);
	}
}
