/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.DVDVerleihStore;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;

/**
 * @author Paul Manthei
 *
 */
public class XMLDatenhaltung implements IDatenhaltung {

	private static final String XML_PATH = "./Datenbank/DVDVerleihStore.xml";
	private DVDVerleihStore store = new DVDVerleihStore();
	
	public XMLDatenhaltung() {	}
	
	private void initDatenhaltung() throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(DVDVerleihStore.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		store = (DVDVerleihStore) unmarshaller.unmarshal(new FileReader(XML_PATH));
	}
	
	private void close() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(DVDVerleihStore.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(store, new File(XML_PATH));
	}
	
	@Override
	public List<Kunde> getKundenList() throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		close();
		return store.getKundensList();
	}
	
	@Override
	public List<DVD> getDVDList() throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		close();
		return store.getDvdsList();
	}
	
	@Override
	public List<Ausleihe> getAusleiheList() throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		close();
		return store.getVerleihsList();
	}

	@Override
	public List<Kunde> addKunde(Kunde kunde) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<Kunde> kundenList = getKundenList();
		kundenList.add(kunde);
		store.setKundenList(kundenList);
		close();
		return kundenList;
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<Kunde> kundenList = getKundenList();
		int index = 0;
		for (Kunde kunde2 : kundenList) {
			if (kunde2.equals(kunde)) {
				kundenList.set(index, kunde2);
			}
			index++;
		}
		store.setKundenList(kundenList);
		close();
		return kundenList;
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<Kunde> kundenList = getKundenList();
		kundenList.remove(kunde);
		store.setKundenList(kundenList);
		close();
		return kundenList;
	}

	@Override
	public List<DVD> addDVD(DVD dvd) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<DVD> dvdList = getDVDList();
		dvdList.add(dvd);
		store.setDvdList(dvdList);
		close();
		return dvdList;
	}

	@Override
	public List<DVD> updateDVD(DVD dvd) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<DVD> dvdList = getDVDList();
		int index = 0;
		for (DVD dvd2 : dvdList) {
			if (dvd2.equals(dvd)) {
				dvdList.set(index, dvd2);
			}
		}
		store.setDvdList(dvdList);
		close();
		return dvdList;
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<DVD> dvdList = getDVDList();
		dvdList.remove(dvd);
		store.setDvdList(dvdList);
		close();
		return dvdList;
	}

	@Override
	public List<Ausleihe> addAusleihe(Ausleihe verleih) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<Ausleihe> verleihList = getAusleiheList();
		verleihList.add(verleih);
		store.setVerleihList(verleihList);
		close();
		return verleihList;
	}

	@Override
	public List<Ausleihe> updateAusleihe(Ausleihe verleih) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<Ausleihe> verleihList = getAusleiheList();
		int index = 0;
		for (Ausleihe verleih2 : verleihList) {
			if (verleih2.equals(verleih)) {
				verleihList.set(index, verleih2);
			}
		}
		store.setVerleihList(verleihList);
		close();
		return verleihList;
	}

	@Override
	public List<Ausleihe> deleteAusleihe(Ausleihe verleih) throws FileNotFoundException, JAXBException {
		initDatenhaltung();
		List<Ausleihe> verleihList = getAusleiheList();
		verleihList.remove(verleih);
		store.setVerleihList(verleihList);
		close();
		return verleihList;
	}
	
}