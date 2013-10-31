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

	public DVD() {	}

	public DVD(int dvd_nr, String titel, String genre, int erscheinungsjahr) {
		this(titel, genre, erscheinungsjahr);
		this.setDvd_nr(dvd_nr);
	}

	public DVD(String titel, String genre, int erscheinungsjahr) {
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
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof DVD) {
			return (this.p_dvd_nr == ((DVD)object).p_dvd_nr);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "DVD=[p_dvd_nr=" + this.p_dvd_nr + ",titel=" + this.titel 
				+ ",genre=" + this.genre + ",erscheinungsjahr=" + this.erscheinungsjahr + "]";
	}
	
}
