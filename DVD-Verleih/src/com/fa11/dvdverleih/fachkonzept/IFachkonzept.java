package com.fa11.dvdverleih.fachkonzept;

import java.util.List;

import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
/**
 * Interface zum Fachkonzept
 * @author Marco de Haan
 */
public interface IFachkonzept {
	
	public Kunde getKundeByID(int kundenNummer);
	public List<Kunde> getAllKunden();
	public void updateKunde(Kunde kundenDaten);
	public void deleteKunde(int kundenNummer);
	public void createKunde(Kunde kundenDaten);
	
	public DVD getDVDByID(int dvdNummer);
	public List<DVD> getAllDVDs();
	public void updateDVD(DVD updateDVD);
	public void deleteDVD(int dvdNummer);
	public void createDVD(DVD dvdDaten);

	public List<Ausleihe> getAllVerleihe();
	public List<Ausleihe> getKundenVerleih(int kundenNummer);
	public Ausleihe getVerleihByID(int verleihNummer);
	public void updateVerleih(Ausleihe updateVerleih);
	public void deleteVerleih(int verleihNummer);
	public void createVerleih(Ausleihe neuerVerleih);	
	
}
