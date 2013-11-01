/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;

/**
 * @author Paul Manthei
 *
 */
public enum KundeFields {

	p_kunden_nr(TableDatatype.INTEGER), 
	anrede(TableDatatype.VARCHAR), 
	vorname(TableDatatype.VARCHAR), 
	nachname(TableDatatype.VARCHAR), 
	geburtstag(TableDatatype.DATETIME), 
	plz(TableDatatype.VARCHAR),
	ort(TableDatatype.VARCHAR),
	strasse(TableDatatype.VARCHAR),
	hausnr(TableDatatype.INTEGER), 
	telefonnr(TableDatatype.VARCHAR);
	
	private final TableDatatype datatype;
	
	private KundeFields(TableDatatype datatype) {
		this.datatype = datatype;
	}
	
	public TableDatatype datatype() { return this.datatype; }
	
}
