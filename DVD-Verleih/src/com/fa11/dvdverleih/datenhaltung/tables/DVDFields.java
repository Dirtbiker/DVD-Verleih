/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;

/**
 * @author Paul Manthei
 *
 */
public enum DVDFields {

	p_dvd_nr(TableDatatype.INTEGER),
	titel(TableDatatype.VARCHAR),
	genre(TableDatatype.VARCHAR),
	erscheinungsjahr(TableDatatype.INTEGER);
	
	private TableDatatype datatype;
	
	private DVDFields(TableDatatype datatype) {
		this.datatype = datatype;
	}
	
	public TableDatatype datatype() { return this.datatype; }
	
}
