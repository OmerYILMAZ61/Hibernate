package com.ss.secim.islem;

import java.util.List;
import java.util.Scanner;

import com.ss.secim.entity.Parti;
import com.ss.secim.entity.Secmen;

public class Islem {

	public static void main(String[] args) {

		DAO dao = new DAO();
		Scanner sc = new Scanner(System.in);
		
		partileriEkle(dao, sc);
		secmenEkle(dao, sc);
		oylamaYap(dao, sc);
		sonuclariGoster(dao,sc);

	}

	private static void sonuclariGoster(DAO dao, Scanner sc) {
		List<Parti> list = dao.getPartiList();
		System.out.println("Oy Sonuçlarý:");
		for (Parti parti : list) {
			System.out.println(parti.getName()+" Partisi " +parti.getOy_sayisi()+ " oy aldý");
		}
		
	}

	//oylama
	private static void oylamaYap(DAO dao, Scanner sc) {
		List<Secmen> list = dao.getSecmenList();
		int[] oySayisi = { 0, 0, 0, 0 };
		int secim;
		for (int i = 0; i < list.size(); i++) {
			Secmen secmen = list.get(i);
			
			System.out.println("Seçiminiz þu þekilde olucaktýr");
			System.out.println(" 1 = " + dao.getParti(1).getName() + " 2 = " + dao.getParti(2).getName() + " 3 = " + dao.getParti(3).getName() + " 4 = "
					+ dao.getParti(4).getName());

			System.out.println(secmen.getId() + " " + secmen.getName() + " Partinizi Seçiniz");
			secim = sc.nextInt();

			if (secim == 1) {
				oySayisi[0] ++;
			} else if (secim == 2) {
				oySayisi[1] ++;
			} else if (secim == 3) {
				oySayisi[2] ++;
			} else if (secim == 4) {
				oySayisi[3] ++;
			}

		}
		Parti parti = new Parti();
		for (int i = 0; i < oySayisi.length; i++) {
			
			parti.setId(i+1);
			parti.setName(dao.getParti(i+1).getName());
			parti.setOy_sayisi(oySayisi[i]);
			dao.updateParti(parti);
		}
		
		

	}

	// secmen ekleme
	private static void secmenEkle(DAO dao, Scanner sc) {

		Secmen secmen = new Secmen();
		System.out.println("Kaç seçmen var?");
		int sayi = sc.nextInt();
		for (int i = 0; i < sayi; i++) {
			System.out.println((i + 1) + ". Seçmeni giriniz  ");
			secmen.setName(sc.next());
			dao.add(secmen);

		}

	}

	// parti ekleme
	private static void partileriEkle(DAO dao, Scanner sc) {

		Parti parti = new Parti();
		for (int i = 0; i < 4; i++) {
			parti.setId(i + 1);
			System.out.println("Katýlacak " + (i + 1) + ". Partiyi giriniz  ");
			parti.setName(sc.next());
			dao.add(parti);
		}

	}
}
