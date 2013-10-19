/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.DVDVerleihStore;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;

/**
 * @author Paul Manthei
 *
 */
public class XMLDatenhaltung implements IDatenhaltung {

	private static final String XML_PATH = "./DVDVerleihStore.xml";
	private DVDVerleihStore store;
	
	public XMLDatenhaltung() throws FileNotFoundException, JAXBException {
		getBookstore();
	}
	
	@Override
	public List<Kunde> getKundenList() {
		return store.getKundensList();
	}
	
	@Override
	public List<DVD> getDVDList() {
		return store.getDvdsList();
	}
	
	@Override
	public List<Verleih> getVerleihList() {
		return store.getVerleihsList();
	}

	@Override
	public List<Kunde> addKunde(Kunde kunde) {
		List<Kunde> kundenList = getKundenList();
		kundenList.add(kunde);
		store.setKundenList(kundenList);
		return getKundenList();
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) {
		List<Kunde> kundenList = getKundenList();
		kundenList.remove(kunde);
		store.setKundenList(kundenList);
		return getKundenList();
	}

	@Override
	public List<DVD> addDVD(DVD dvd) {
		List<DVD> dvds = getDVDList();
		dvds.add(dvd);
		store.setDvdList(dvds);
		return getDVDList();
	}

	@Override
	public List<DVD> updateDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) {
		List<DVD> dvds = getDVDList();
		dvds.remove(dvd);
		store.setDvdList(dvds);
		return getDVDList();
	}

	@Override
	public List<Verleih> addVerleih(Verleih verleih) {
		List<Verleih> verleihs = getVerleihList();
		verleihs.add(verleih);
		store.setVerleihList(verleihs);
		return getVerleihList();
	}

	@Override
	public List<Verleih> updateVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> deleteVerleih(Verleih verleih) {
		List<Verleih> verleihs = getVerleihList();
		verleihs.remove(verleih);
		store.setVerleihList(verleihs);
		return getVerleihList();
	}
	
	private void getBookstore() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(DVDVerleihStore.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		store = (DVDVerleihStore) unmarshaller.unmarshal(new FileReader(XML_PATH));
	}
	
}