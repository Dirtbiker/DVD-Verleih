/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.sql.SQLException;
import java.util.List;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;

/**
 * @author Paul Manthei
 *
 */
public interface IDatenhaltung {

	public Kunde getKunde(int kunden_nr);
	public List<Kunde> getKundenList() throws SQLException;
	public List<Kunde> updateKunde(Kunde kunde);
	public List<Kunde> insertKunde(Kunde kunde);
	public List<Kunde> insertKunde(List<Kunde> kundeList);
	public List<Kunde> deleteKunde(Kunde kunde);
	public List<Kunde> deleteKunde(List<Kunde> kundeList);
	
	public DVD getDVD(int dvd_nr);
	public List<DVD> getDVDList() throws SQLException;
	public List<DVD> updateDVD(DVD dvd);
	public List<DVD> insertDVD(DVD dvd);
	public List<DVD> insertDVD(List<DVD> dvdList);
	public List<DVD> deleteDVD(DVD dvd);
	public List<DVD> deleteDVD(List<DVD> dvdList);
	
	public Verleih getVerleih(int verleih_nr);
	public List<Verleih> getVerleihList() throws SQLException;
	public List<Verleih> updateVerleih(Verleih verleih);
	public List<Verleih> insertVerleih(Verleih verleih);
	public List<Verleih> insertVerleih(List<Verleih> verleihList);
	public List<Verleih> deleteVerleih(Verleih verleih);
	public List<Verleih> deleteVerleih(List<Verleih> verleihList);
	

	
}
