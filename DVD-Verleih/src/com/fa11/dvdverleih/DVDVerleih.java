package com.fa11.dvdverleih;

import java.sql.SQLException;

import com.fa11.dvdverleih.datenhaltung.DatenhaltungFactory;
import com.fa11.dvdverleih.datenhaltung.IDatenhaltung;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;



public class DVDVerleih {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatenhaltungFactory factory = new DatenhaltungFactory();
		IDatenhaltung datenhaltung = factory.getDatenhaltung(DatenhaltungFactory.SQLITE_DATENHALTUNG);
		for (DVD dvd : datenhaltung.getDVDList()) {
			System.out.println(dvd.getTitel());
		}
	}
}
