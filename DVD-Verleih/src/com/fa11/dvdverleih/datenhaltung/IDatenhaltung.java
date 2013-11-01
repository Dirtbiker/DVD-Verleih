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
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;

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
	
	public List<Verleih> getVerleihList() throws SQLException, ClassNotFoundException;
	public List<Verleih> addVerleih(Verleih verleih) throws ClassNotFoundException, SQLException;
	public List<Verleih> updateVerleih(Verleih verleih) throws ClassNotFoundException, SQLException;
	public List<Verleih> deleteVerleih(Verleih verleih) throws ClassNotFoundException, SQLException;
	
}
