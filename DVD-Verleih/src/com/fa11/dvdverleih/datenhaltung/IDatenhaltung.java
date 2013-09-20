/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

/**
 * @author Paul Manthei
 *
 */
public interface IDatenhaltung {

	public Kunde getKunde(int kunden_nr);
	
	public DVD getDVD(int dvd_nr);
	
	public Verleih getVerleih(int kunden_nr, int dvd_nr);
	
}
