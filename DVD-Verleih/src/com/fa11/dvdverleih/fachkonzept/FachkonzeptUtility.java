package com.fa11.dvdverleih.fachkonzept;

import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
/**
 * Utility Funktionen zum Fachkonzept
 * @author Marco de Haan
 *
 */
public class FachkonzeptUtility {	
	/**
	 * Prüft, ob eine bestimmte DVD zurzeit verliehen ist
	 * @author Marco de Haan
	 */
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
