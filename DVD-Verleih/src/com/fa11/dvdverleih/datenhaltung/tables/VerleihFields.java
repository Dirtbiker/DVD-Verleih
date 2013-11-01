/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;


/**
 * @author Paul Manthei
 *
 */
public enum VerleihFields {

	p_leihvorgangs_nr(TableDatatype.INTEGER),
	f_dvd_nr(TableDatatype.INTEGER),
	f_kunden_nr(TableDatatype.INTEGER),
	ausleihe(TableDatatype.INTEGER),
	rueckgabe(TableDatatype.INTEGER);
	
	private TableDatatype datatype;
	
	private VerleihFields(TableDatatype datatype) {
		this.datatype = datatype;
	}
	
	public TableDatatype datatype() { return this.datatype; }
	
}
