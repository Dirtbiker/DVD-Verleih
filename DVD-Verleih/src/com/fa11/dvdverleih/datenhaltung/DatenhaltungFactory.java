/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

/**
 * @author Paul Manthei
 *
 */
public class DatenhaltungFactory {

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
