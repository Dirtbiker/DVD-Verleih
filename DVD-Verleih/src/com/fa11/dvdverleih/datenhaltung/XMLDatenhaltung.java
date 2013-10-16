/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.util.LinkedList;
import java.util.List;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;

/**
 * @author Paul Manthei
 *
 */
public class XMLDatenhaltung implements IDatenhaltung {

	List<Kunde> kunden = new LinkedList<>();
	List<DVD> dvds = new LinkedList<>();
	List<Verleih> verleihungen = new LinkedList<>();
	
	public XMLDatenhaltung() {
		
	}
	
	@Override
	public List<Kunde> getKundenList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<DVD> getDVDList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Verleih> getVerleihList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}