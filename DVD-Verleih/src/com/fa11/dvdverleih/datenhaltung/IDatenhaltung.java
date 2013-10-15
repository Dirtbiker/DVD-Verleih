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
	
	public List<DVD> getDVDList() throws SQLException, ClassNotFoundException;
	
	public List<Verleih> getVerleihList() throws SQLException, ClassNotFoundException;
	
}
