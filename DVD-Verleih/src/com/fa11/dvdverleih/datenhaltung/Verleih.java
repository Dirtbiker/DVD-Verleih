/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

/**
 * @author Paul Manthei
 *
 */
public class Verleih {

	private int dvd_nr;
	private String titel;
	private String genre;
	private int erscheinungsjahr;
	
	public Verleih() {
		// TODO Auto-generated constructor stub
	}
	
	public Verleih(String titel, String genre, int erscheinungsjahr) {
		setTitel(titel);
		setGenre(genre);
		setErscheinungsjahr(erscheinungsjahr);
	}

	public int getDvd_nr() {
		return dvd_nr;
	}

	public void setDvd_nr(int dvd_nr) {
		this.dvd_nr = dvd_nr;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}

	public void setErscheinungsjahr(int erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}
	
}
