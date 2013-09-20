/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.util.Date;

/**
 * @author Paul Manthei
 *
 */
public class Kunde {

	private int kunden_nr;
	private String anrede;
	private String vorname;
	private int nachname;
	private Date geburtstag;
	private String plz;
	private String ort;
	private String strasse;
	private int hausnummer;
	private String telefon_nummer;
	
	public Kunde() {
		// TODO Auto-generated constructor stub
	}

	public int getKunden_nr() {
		return kunden_nr;
	}

	public void setKunden_nr(int kunden_nr) {
		this.kunden_nr = kunden_nr;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getNachname() {
		return nachname;
	}

	public void setNachname(int nachname) {
		this.nachname = nachname;
	}

	public Date getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(Date geburtstag) {
		this.geburtstag = geburtstag;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getTelefon_nummer() {
		return telefon_nummer;
	}

	public void setTelefon_nummer(String telefon_nummer) {
		this.telefon_nummer = telefon_nummer;
	}
	
}
