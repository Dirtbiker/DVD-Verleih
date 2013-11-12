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

	/**
	 * Selektiert alle vorhandenen Kunden.
	 * 
	 * @return Liste aller vorhandenen Kunden. 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Kunde> getKundenList() throws SQLException, ClassNotFoundException, JAXBException, FileNotFoundException;

	/**
	 * Pflegt einen neuen Kunden in die Datenhaltung ein und returnt eine aktualisierte Liste.
	 * 
	 * @param kunde Neuer Kunde.
	 * @return Aktualisierte Liste aller vorhandenen Kunden.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Kunde> addKunde(Kunde kunde) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
	/**
	 * Ändert einen bestehenden Kunden und returnt eine aktualisierte Liste. 
	 * 
	 * @param kunde Bestehender Kunde mit veränderten Daten.
	 * @return Aktualisierte Liste aller vorhandenen Kunden.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Kunde> updateKunde(Kunde kunde) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
	/**
	 * Löscht einen bestehenden Kunden und returnt eine aktualisierte Liste
	 * 
	 * @param kunde Zu löschender Kunde.
	 * @return Aktualisierte Liste aller vorhandenen Kunden.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Kunde> deleteKunde(Kunde kunde) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	

	/**
	 * Selektiert alle vorhandenen DVDs.
	 * 
	 * @return Liste aller vorhandenen DVDs.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<DVD> getDVDList() throws SQLException, ClassNotFoundException, JAXBException, FileNotFoundException;

	/**
	 * Pflegt eine neue DVD in die Datenhaltung ein und returnt eine aktualisierte Liste.
	 * 
	 * @param dvd Neue DVD.
	 * @return Aktualisierte Liste aller vorhandenen DVDs.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<DVD> addDVD(DVD dvd) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;

	/**
	 * Ändert eine bestehende DVD und returnt eine aktualisierte Liste. 
	 * 
	 * @param dvd Bestehende DVD mit veränderten Daten.
	 * @return Aktualisierte Liste aller vorhandenen DVDs.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<DVD> updateDVD(DVD dvd) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
	/**
	 * Löscht eine bestehende DVD und returnt eine aktualisierte Liste
	 * 
	 * @param dvd Zu löschende DVD.
	 * @return Aktualisierte Liste aller vorhandenen DVDs.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<DVD> deleteDVD(DVD dvd) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	

	/**
	 * Selektiert alle vorhandenen Leihvorgänge.
	 * 
	 * @return Liste aller vorhandenen Leihvorgänge.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Ausleihe> getAusleiheList() throws SQLException, ClassNotFoundException, JAXBException, FileNotFoundException;

	/**
	 * Pflegt einen neuen Leihvorgang in die Datenhaltung ein und returnt eine aktualisierte Liste.
	 * 
	 * @param vewrleih Neuer Leihvorgang.
	 * @return Aktualisierte Liste aller vorhandenen Kunden.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Ausleihe> addAusleihe(Ausleihe verleih) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;

	/**
	 * Ändert einen bestehenden Leihvorgang und returnt eine aktualisierte Liste. 
	 * 
	 * @param veleih Bestehender Leihvorgang mit veränderten Daten.
	 * @return Aktualisierte Liste aller vorhandenen Leihvorgänge.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Ausleihe> updateAusleihe(Ausleihe verleih) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
	/**
	 * Löscht einen bestehenden Leihvorgang und returnt eine aktualisierte Liste
	 * 
	 * @param verleih Zu löschender Leihvorgang.
	 * @return Aktualisierte Liste aller vorhandenen Leihvorgänge.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public List<Ausleihe> deleteAusleihe(Ausleihe verleih) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException;
	
}
