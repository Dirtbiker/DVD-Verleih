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

	public List<Kunde> getKundenList() throws SQLException, ClassNotFoundException;
	public List<Kunde> addKunde(Kunde kunde);
	public List<Kunde> updateKunde(Kunde kunde);
	public List<Kunde> deleteKunde(Kunde kunde);
	
	public List<DVD> getDVDList() throws SQLException, ClassNotFoundException;
	public List<DVD> addDVD(DVD dvd);
	public List<DVD> updateDVD(DVD dvd);
	public List<DVD> deleteDVD(DVD dvd);
	
	public List<Verleih> getVerleihList() throws SQLException, ClassNotFoundException;
	public List<Verleih> addVerleih(Verleih verleih);
	public List<Verleih> updateVerleih(Verleih verleih);
	public List<Verleih> deleteVerleih(Verleih verleih);
	
}
