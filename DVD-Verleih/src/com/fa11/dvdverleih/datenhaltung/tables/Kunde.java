/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;

import java.sql.Date;

/**
 * @author Paul Manthei
 *
 */
public class Kunde {

	private int p_kunden_nr;
	private String anrede;
	private String vorname;
	private String nachname;
	private Date geburtstag;
	private String plz;
	private String ort;
	private String strasse;
	private int hausnummer;
	private String telefon_nummer;
	
	public Kunde() {	}

	public Kunde(int kunden_nr, String anrede, String vorname, String nachname, Date geburtstag, String plz, String ort, String strasse, int hausnummer, String telefon_nummer) {
		this(anrede, vorname, nachname, geburtstag, plz, ort, strasse, hausnummer, telefon_nummer);
		this.setKunden_nr(kunden_nr);
	}
	
	public Kunde(String anrede, String vorname, String nachname, Date geburtstag, String plz, String ort, String strasse, int hausnummer, String telefon_nummer) {
		this.setAnrede(anrede);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setGeburtstag(geburtstag);
		this.setPlz(plz);
		this.setOrt(ort);
		this.setStrasse(strasse);
		this.setHausnummer(hausnummer);
		this.setTelefon_nummer(telefon_nummer);
	}
	
	public int getKunden_nr() {
		return p_kunden_nr;
	}

	public void setKunden_nr(int kunden_nr) {
		this.p_kunden_nr = kunden_nr;
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

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
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
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Kunde) {
			return (this.p_kunden_nr == ((Kunde)object).p_kunden_nr);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "DVD=[p_kunden_nr=" + this.p_kunden_nr + ",anrede=" + this.anrede 
				+ ",vorname=" + this.vorname + ",nachname=" + this.nachname
				+ ",geburtstag=" + this.geburtstag + ",plz=" + this.plz
				+ ",ort=" + this.ort + ",strasse=" + this.strasse
				+ ",hausnummer=" + this.hausnummer + ",telefon_nummer=" + this.telefon_nummer + "]";
	}

}
