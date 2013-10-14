/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.sql.SQLException;

/**
 * @author Paul Manthei
 *
 */
public class DatenhaltungFactory {

	public static final String XML_DATENHALTUNG = "xml";
	public static final String SQLITE_DATENHALTUNG = "sqlite";
	
	public IDatenhaltung getDatenhaltung (String datenhaltung) throws ClassNotFoundException, SQLException {
		IDatenhaltung iDatenhaltung = null;
		switch (datenhaltung) {
		case XML_DATENHALTUNG:
			iDatenhaltung = new XMLDatenhaltung();
			break;
		
		case SQLITE_DATENHALTUNG:
			iDatenhaltung = new SQLiteDatenhaltung();
			break;
			
		default:
			break;
		}
		
		return iDatenhaltung;
	}
	
}
