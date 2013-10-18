/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

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
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;

/**
 * @author Paul Manthei
 *
 */
public class XMLDatenhaltung implements IDatenhaltung {

	private static final String XML_PATH = "./DVDVerleihStore.xml";
	private DVDVerleihStore store;
	
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

	@Override
	public List<Kunde> addKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> addDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> updateDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> addVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> updateVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> deleteVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void getBookstore() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(DVDVerleihStore.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		store = (DVDVerleihStore) unmarshaller.unmarshal(new FileReader("./verleih.xml"));
	}
	
}