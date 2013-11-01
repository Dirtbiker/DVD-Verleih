/**
 * @author Marco de Haan
 * Created: 20.09.2013
 * 
 */
package com.fa11.dvdverleih.fachkonzept;

import java.util.List;

import com.fa11.dvdverleih.datenhaltung.IDatenhaltung;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;

/**
 * @author Marco de Haan
 *
 */
public class Fachkonzept implements IFachkonzept {
	
	private IDatenhaltung datenhaltung;
	
	public Fachkonzept(IDatenhaltung datenhaltung) {
		
		this.datenhaltung = datenhaltung;
	}

	@Override
	public Kunde getKundeByID(int kundenNummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> getAllKunden() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKunde(Kunde kundenDaten) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKunde(int kundenNummer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createKunde(Kunde kundenDaten) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DVD getDVDByID(int dvdNummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> getAllDVDs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDVD(DVD updateDVD) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDVD(int dvdNummer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createDVD(DVD dvdDaten) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ausleihe> getAllVerleihe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ausleihe> getKundenVerleih(int kundenNummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createVerleih(Ausleihe neuerVerleih) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVerleih(Ausleihe updateVerleih) {
		// TODO Auto-generated method stub
		
	}

}
