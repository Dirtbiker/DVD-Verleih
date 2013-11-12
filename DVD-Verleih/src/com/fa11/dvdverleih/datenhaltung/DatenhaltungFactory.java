package com.fa11.dvdverleih.datenhaltung;

/**
 * @author Paul Manthei
 *
 */
public class DatenhaltungFactory {

	/**
	 * <code>getDatenhaltung</code> erstellt je nach Parameter die entsprechende Datenhaltung. 
	 * @param datenhaltungType
	 * @return IDatenhaltung
	 */
	public static IDatenhaltung getDatenhaltung (DatenhaltungType datenhaltungType) {
		IDatenhaltung iDatenhaltung = null;
		switch (datenhaltungType) {
		case xml:
			iDatenhaltung = new XMLDatenhaltung();
			break;
		
		case sqlite:
			iDatenhaltung = new SQLiteDatenhaltung();
			break;
			
		default:
			break;
		}
		
		return iDatenhaltung;
	}
	
}
