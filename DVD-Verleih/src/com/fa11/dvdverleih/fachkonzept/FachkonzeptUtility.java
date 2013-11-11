package com.fa11.dvdverleih.fachkonzept;

import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;

public class FachkonzeptUtility {	
	public static boolean isDVDAvailable(int dvdNummer, IFachkonzept fachkonzept) {
		DVD thisOne = fachkonzept.getDVDByID(dvdNummer);
		
		for(Ausleihe currentAusleihe : fachkonzept.getAllVerleihe()) {
			if(currentAusleihe.getDvd_nr() == thisOne.getDvd_nr() && currentAusleihe.getRueckgabe() == null) {
				return false;
			}
		}
		return true;	
	}
}
