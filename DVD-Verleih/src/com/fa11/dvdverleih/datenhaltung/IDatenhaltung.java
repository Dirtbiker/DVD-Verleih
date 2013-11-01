/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;

/**
 * @author Paul Manthei
 *
 */
public interface IDatenhaltung {

	public List<Kunde> getKundenList() throws SQLException, ClassNotFoundException, JAXBException, FileNotFoundException;
	public List<Kunde> addKunde(Kunde kunde) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	public List<Kunde> updateKunde(Kunde kunde) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	public List<Kunde> deleteKunde(Kunde kunde) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
	public List<DVD> getDVDList() throws SQLException, ClassNotFoundException, JAXBException, FileNotFoundException;
	public List<DVD> addDVD(DVD dvd) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	public List<DVD> updateDVD(DVD dvd) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	public List<DVD> deleteDVD(DVD dvd) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
	public List<Ausleihe> getAusleiheList() throws SQLException, ClassNotFoundException, JAXBException, FileNotFoundException;
	public List<Ausleihe> addAusleihe(Ausleihe verleih) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	public List<Ausleihe> updateAusleihe(Ausleihe verleih) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	public List<Ausleihe> deleteAusleihe(Ausleihe verleih) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
}
