/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.util.Date;

/**
 * @author Paul Manthei
 *
 */
public class Verleih {

	private int leihvorgangs_nr;
	private int dvd_nr;
	private int kunden_nr;
	private Date ausleihe;
	private Date rueckgabe;
	
	public Verleih() {
		// TODO Auto-generated constructor stub
	}

	public int getLeihvorgangs_nr() {
		return leihvorgangs_nr;
	}

	public void setLeihvorgangs_nr(int leihvorgangs_nr) {
		this.leihvorgangs_nr = leihvorgangs_nr;
	}

	public int getDvd_nr() {
		return dvd_nr;
	}

	public void setDvd_nr(int dvd_nr) {
		this.dvd_nr = dvd_nr;
	}

	public int getKunden_nr() {
		return kunden_nr;
	}

	public void setKunden_nr(int kunden_nr) {
		this.kunden_nr = kunden_nr;
	}

	public Date getAusleihe() {
		return ausleihe;
	}

	public void setAusleihe(Date ausleihe) {
		this.ausleihe = ausleihe;
	}

	public Date getRueckgabe() {
		return rueckgabe;
	}

	public void setRueckgabe(Date rueckgabe) {
		this.rueckgabe = rueckgabe;
	}
	
}
