/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;


/**
 * @author Paul Manthei
 *
 */
public class DVD {

	private int p_dvd_nr;
	private String titel;
	private String genre;
	private int erscheinungsjahr;

	public DVD() {
		
	}

	public DVD(int dvd_nr, String titel, String genre, int erscheinungsjahr) {
		this.setDvd_nr(dvd_nr);
		this.setTitel(titel);
		this.setGenre(genre);
		this.setErscheinungsjahr(erscheinungsjahr);
	}

	public int getDvd_nr() {
		return p_dvd_nr;
	}

	public void setDvd_nr(int dvd_nr) {
		this.p_dvd_nr = dvd_nr;
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
