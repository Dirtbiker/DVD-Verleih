/**
 * @author Marco de Haan
 * Created: 20.09.2013
 * 
 */
package com.fa11.dvdverleih.fachkonzept;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

import com.fa11.dvdverleih.datenhaltung.IDatenhaltung;
import com.fa11.dvdverleih.datenhaltung.XMLDatenhaltung;
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;

/**
 * @author Marco de Haan
 *
 */
public class Fachkonzept implements IFachkonzept {
	
	private IDatenhaltung datenhaltung;
	private List<Kunde> kundenList;
	private List<DVD> DVDList;
	private List<Ausleihe> verleiheList;
	
	public Fachkonzept(IDatenhaltung datenhaltung) {
		this.datenhaltung = datenhaltung;
		
		try {
			this.kundenList = datenhaltung.getKundenList();
			this.DVDList = datenhaltung.getDVDList();
			this.verleiheList = datenhaltung.getAusleiheList();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public Kunde getKundeByID(int kundenNummer) {
		for(Kunde kunde : this.kundenList) {
			if(kundenNummer == kunde.getKunden_nr()) {
				return kunde;
			}
		}
		return null;
	}

	@Override
	public List<Kunde> getAllKunden() {		
		return this.kundenList;
	}

	@Override
	public void updateKunde(Kunde kundenDaten) {
		try {
			this.kundenList = this.datenhaltung.updateKunde(kundenDaten);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public void deleteKunde(int kundenNummer) {
		for(Kunde kunde : this.kundenList) {
			if(kundenNummer == kunde.getKunden_nr()) {
				try {
					this.kundenList = this.datenhaltung.deleteKunde(kunde);
				} catch (FileNotFoundException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehlende oder fehlerhafte Dateien!");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehler beim Datenbankzugriff!");
				} catch (JAXBException e) {
					JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehler beim XML-Zugriff!");
				}
			}
		}	
	}

	@Override
	public void createKunde(Kunde kundenDaten) {
		
		if(this.datenhaltung instanceof XMLDatenhaltung) {
			int neueKundenID = 0;
			for(Kunde kunde : this.kundenList) {
				if(kunde.getKunden_nr() > neueKundenID) {
					neueKundenID = kunde.getKunden_nr();
				}
			}
			neueKundenID++;
			kundenDaten.setKunden_nr(neueKundenID);
		}
		
		try {
			this.kundenList = this.datenhaltung.addKunde(kundenDaten);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public DVD getDVDByID(int dvdNummer) {		
		for(DVD dvd : this.DVDList) {
			if(dvdNummer == dvd.getDvd_nr()) {
				return dvd;
			}
		}
		return null;
	}

	@Override
	public List<DVD> getAllDVDs() {		
		return this.DVDList;
	}

	@Override
	public void updateDVD(DVD updateDVD) {
		try {
			this.DVDList = this.datenhaltung.updateDVD(updateDVD);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public void deleteDVD(int dvdNummer) {
		for(DVD dvd : this.DVDList) {
			if(dvdNummer == dvd.getDvd_nr()) {
				try {
					this.DVDList = this.datenhaltung.deleteDVD(dvd);
				} catch (FileNotFoundException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehlende oder fehlerhafte Dateien!");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehler beim Datenbankzugriff!");
				} catch (JAXBException e) {
					JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehler beim XML-Zugriff!");
				}
			}
		}	
	}

	@Override
	public void createDVD(DVD dvdDaten) {
		
		if(this.datenhaltung instanceof XMLDatenhaltung) {
			int neueDVDID = 0;
			for(DVD dvd : this.DVDList) {
				if(dvd.getDvd_nr() > neueDVDID) {
					neueDVDID = dvd.getDvd_nr();
				}
			}
			neueDVDID++;
			dvdDaten.setDvd_nr(neueDVDID);
		}
		
		try {
			this.DVDList = this.datenhaltung.addDVD(dvdDaten);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public List<Ausleihe> getAllVerleihe() {
		return this.verleiheList;
	}

	@Override
	public List<Ausleihe> getKundenVerleih(int kundenNummer) {
		List<Ausleihe> kundenVerleihe = new ArrayList<Ausleihe>();
		
		for(Ausleihe ausleihe : this.verleiheList) {
			if(ausleihe.getKunden_nr() == kundenNummer) {
				kundenVerleihe.add(ausleihe);
			}
		}		
		return kundenVerleihe;
	}

	@Override
	public void createVerleih(Ausleihe neuerVerleih) {

		if(this.datenhaltung instanceof XMLDatenhaltung) {
			int neueAusleihID = 0;
			for(Ausleihe ausleihe : this.verleiheList) {
				if(ausleihe.getLeihvorgangs_nr() > neueAusleihID) {
					neueAusleihID = ausleihe.getLeihvorgangs_nr();
				}
			}
			neueAusleihID++;
			neuerVerleih.setLeihvorgangs_nr(neueAusleihID);
		}
		
		try {
			this.verleiheList = this.datenhaltung.addAusleihe(neuerVerleih);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public void updateVerleih(Ausleihe updateVerleih) {
		try {
			this.verleiheList = this.datenhaltung.updateAusleihe(updateVerleih);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehlende oder fehlerhafte Dateien!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim Datenbankzugriff!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
			System.err.println("Fehler beim XML-Zugriff!");
		}
	}

	@Override
	public Ausleihe getVerleihByID(int verleihID) {
		for(Ausleihe ausleihe : this.verleiheList) {
			if(ausleihe.getLeihvorgangs_nr() == verleihID) {
				return ausleihe;
			} 
		}
		return null;
	}

	@Override
	public void deleteVerleih(int verleihNummer) {
		for(Ausleihe verleih : this.verleiheList) {
			if(verleihNummer == verleih.getLeihvorgangs_nr()) {
				try {
					this.verleiheList = this.datenhaltung.deleteAusleihe(verleih);
				} catch (FileNotFoundException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Fehlende oder fehlerhafte Dateien!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehlende oder fehlerhafte Dateien!");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Fehler beim Datenbankzugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehler beim Datenbankzugriff!");
				} catch (JAXBException e) {
					JOptionPane.showMessageDialog(null, "Fehler beim XML-Zugriff!", "Fehler!", JOptionPane.INFORMATION_MESSAGE);
					System.err.println("Fehler beim XML-Zugriff!");
				}
			}
		}		
	}
}
