package com.fa11.dvdverleih;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;
import com.fa11.dvdverleih.datenhaltung.tables.XMLVerleih;



public class DVDVerleih {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, JAXBException, FileNotFoundException {

		XMLVerleih xmlVerleih = new XMLVerleih();

		List<Kunde> kundes = new ArrayList<>();
		List<DVD> dvds = new ArrayList<>();
		List<Verleih> verleihs = new ArrayList<>();
		
		Kunde kunde = new Kunde(1, "", "", "", new Date(1989, 12, 12), "", "", "", 19, "");
		Kunde kunde2 = new Kunde(2, "", "", "", new Date(1989, 12, 12), "", "", "", 19, "");
		kundes.add(kunde);
		kundes.add(kunde2);
		
		DVD dvd = new DVD(1, "Sharknado", "Thriller", 2001);
		DVD dvd2 = new DVD(2, "Sharknado", "Thriller", 2001);
		dvds.add(dvd);
		dvds.add(dvd2);
		
		Verleih verleih = new Verleih(1, 1, 1, new Date(2013, 12, 12), new Date(2013, 12, 14));
		Verleih verleih2 = new Verleih(2, 2, 2, new Date(2013, 12, 12), new Date(2013, 12, 14));
		verleihs.add(verleih);
		verleihs.add(verleih2);
	
		xmlVerleih.setKundenList(kundes);
		xmlVerleih.setDvdList(dvds);
		xmlVerleih.setVerleihList(verleihs);
		
		JAXBContext context = JAXBContext.newInstance(XMLVerleih.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		marshaller.marshal(xmlVerleih, System.out);
		marshaller.marshal(xmlVerleih, new File("./verleih.xml"));

		System.out.println();
		System.out.println("Output from our XML File: ");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		XMLVerleih xmlVerleih2 = (XMLVerleih) unmarshaller.unmarshal(new FileReader("./verleih.xml"));
		
		for (Kunde kunde3 : xmlVerleih2.getKundenList()) {
			System.out.println("Kunde: " + kunde3.getKunden_nr());
		}
		for (DVD dvd3 : xmlVerleih2.getDvdList()) {
			System.out.println("DVD: " + dvd3.getDvd_nr());
		}
		for (Verleih verleih3 : xmlVerleih2.getVerleihList()) {
			System.out.println("Verleih: " + verleih3.getLeihvorgangs_nr());
		}
		
//		System.out.println();
//	    System.out.println("Output from our XML File: ");
//	    Unmarshaller um = context.createUnmarshaller();
//	    Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));
//	    ArrayList<Book> list = bookstore2.getBooksList();
//	    for (Book book : list) {
//	      System.out.println("Book: " + book.getName() + " from "
//	          + book.getAuthor());
//	    }
		
	}
}
