/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Paul Manthei
 *
 */
@XmlRootElement()
public class XMLVerleih {

	@XmlElementWrapper(name="kundenList")
	@XmlElement(name="kunde")
	private List<Kunde> kunden = new ArrayList<>();
	@XmlElementWrapper(name="dvdList")
	@XmlElement(name="dvd")
	private List<DVD> dvds = new ArrayList<>();
	@XmlElementWrapper(name="verleihList")
	@XmlElement(name="verleih")
	private List<Verleih> verleihungen = new ArrayList<>();

	public List<Kunde> getKundenList() {
		return kunden;
	}
	public void setKundenList(List<Kunde> kundenList) {
		this.kunden = kundenList;
	}
	public List<DVD> getDvdList() {
		return dvds;
	}
	public void setDvdList(List<DVD> dvds) {
		this.dvds = dvds;
	}
	public List<Verleih> getVerleihList() {
		return verleihungen;
	}
	public void setVerleihList(List<Verleih> verleihungen) {
		this.verleihungen = verleihungen;
	}
	
}
