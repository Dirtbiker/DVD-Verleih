/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;


/**
 * @author Paul Manthei
 *
 */
public enum AusleiheFields {

	p_leihvorgangs_nr(TableDatatype.INTEGER),
	f_dvd_nr(TableDatatype.INTEGER),
	f_kunden_nr(TableDatatype.INTEGER),
	ausleihe(TableDatatype.DATETIME),
	rueckgabe(TableDatatype.DATETIME);
	
	private TableDatatype datatype;
	
	private AusleiheFields(TableDatatype datatype) {
		this.datatype = datatype;
	}
	
	public TableDatatype datatype() { return this.datatype; }
	
}
