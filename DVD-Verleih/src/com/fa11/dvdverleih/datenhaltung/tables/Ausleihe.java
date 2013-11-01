/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;

import java.sql.Date;

/**
 * @author Paul Manthei
 *
 */
public class Ausleihe {

	private int p_leihvorgangs_nr;
	private int f_dvd_nr;
	private int f_kunden_nr;
	private Date ausleihe;
	private Date rueckgabe;
	
	public Ausleihe() {	}

	public Ausleihe(int leihvorgangs_nr, int dvd_nr, int kunden_nr, Date ausleihe, Date rueckgabe) {
		this(dvd_nr, kunden_nr, ausleihe, rueckgabe);
		this.setLeihvorgangs_nr(leihvorgangs_nr);
	}

	public Ausleihe(int dvd_nr, int kunden_nr, Date ausleihe, Date rueckgabe) {
		this.setDvd_nr(dvd_nr);
		this.setKunden_nr(kunden_nr);
		this.setAusleihe(ausleihe);
		this.setRueckgabe(rueckgabe);
	}

	public int getLeihvorgangs_nr() {
		return p_leihvorgangs_nr;
	}

	public void setLeihvorgangs_nr(int leihvorgangs_nr) {
		this.p_leihvorgangs_nr = leihvorgangs_nr;
	}

	public int getDvd_nr() {
		return f_dvd_nr;
	}

	public void setDvd_nr(int dvd_nr) {
		this.f_dvd_nr = dvd_nr;
	}

	public int getKunden_nr() {
		return f_kunden_nr;
	}

	public void setKunden_nr(int kunden_nr) {
		this.f_kunden_nr = kunden_nr;
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
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Ausleihe) {
			return (this.p_leihvorgangs_nr == ((Ausleihe)object).p_leihvorgangs_nr);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "DVD=[p_leihvorgangs_nr=" + this.p_leihvorgangs_nr + ",f_dvd_nr=" + this.f_dvd_nr 
				+ ",f_kunden_nr=" + this.f_kunden_nr + ",ausleihe=" + this.ausleihe
				+ ",rueckgabe=" + this.rueckgabe + "]";
	}

}
