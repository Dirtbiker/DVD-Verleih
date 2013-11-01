/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;

/**
 * @author Paul Manthei
 *
 */
public interface IDatenhaltung {

	public void initDatenhaltung() throws SQLException, JAXBException, ClassNotFoundException, FileNotFoundException;
	public void close() throws SQLException, JAXBException;
	
	public List<Kunde> getKundenList() throws SQLException, ClassNotFoundException;
	public List<Kunde> addKunde(Kunde kunde) throws ClassNotFoundException, SQLException;
	public List<Kunde> updateKunde(Kunde kunde) throws ClassNotFoundException, SQLException;
	public List<Kunde> deleteKunde(Kunde kunde) throws ClassNotFoundException, SQLException;
	
	public List<DVD> getDVDList() throws SQLException, ClassNotFoundException;
	public List<DVD> addDVD(DVD dvd) throws ClassNotFoundException, SQLException;
	public List<DVD> updateDVD(DVD dvd) throws ClassNotFoundException, SQLException;
	public List<DVD> deleteDVD(DVD dvd) throws ClassNotFoundException, SQLException;
	
	public List<Ausleihe> getVerleihList() throws SQLException, ClassNotFoundException;
	public List<Ausleihe> addVerleih(Ausleihe verleih) throws ClassNotFoundException, SQLException;
	public List<Ausleihe> updateVerleih(Ausleihe verleih) throws ClassNotFoundException, SQLException;
	public List<Ausleihe> deleteVerleih(Ausleihe verleih) throws ClassNotFoundException, SQLException;
	
}
