/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung.tables;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Paul Manthei
 *
 */
@XmlRootElement()
public class DVDVerleihStore {

	@XmlElementWrapper(name="kundenList")
	@XmlElement(name="kunde")
	private List<Kunde> kundenList;
	@XmlElementWrapper(name="dvdList")
	@XmlElement(name="dvd")
	private List<DVD> dvds;
	@XmlElementWrapper(name="verleihList")
	@XmlElement(name="verleih")
	private List<Verleih> verleihungen;

	public List<Kunde> getKundensList() {
		return kundenList;
	}
	public void setKundenList(List<Kunde> kundenList) {
		this.kundenList = kundenList;
	}
	public List<DVD> getDvdsList() {
		return dvds;
	}
	public void setDvdList(List<DVD> dvds) {
		this.dvds = dvds;
	}
	public List<Verleih> getVerleihsList() {
		return verleihungen;
	}
	public void setVerleihList(List<Verleih> verleihungen) {
		this.verleihungen = verleihungen;
	}
	
}
