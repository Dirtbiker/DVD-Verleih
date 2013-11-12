package com.fa11.dvdverleih.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.fachkonzept.IFachkonzept;

/**
 * Command Line Interface für den DVD-Verleih.
 * 
 * @author Timo Raschke
 * 
 */
public class TUI {
	private IFachkonzept fachkonzept;

	/**
	 * Erstellt eine TUI
	 * @param fachkonzept
	 */
	public TUI(IFachkonzept fachkonzept) {
		this.fachkonzept = fachkonzept;
		this.showMainMenu();
	}

	/**
	 * Zeigt das Hauptmenu an
	 */
	private void showMainMenu() {
		char auswahl;
		boolean korrekt;
		do {
			do {
				korrekt = true;

				System.out.println("DVD-Verleih");
				System.out.println("-----------\n");
				System.out.println("(a) alle Kunden anzeigen");
				System.out.println("(b) Kunde anzeigen");
				System.out.println("(c) Neuer Kunde");
				System.out.println("(d) Kunde bearbeiten");
				System.out.println("(e) Kunde löschen\n");
				// #########################################
				System.out.println("(f) alle DVDs anzeigen");
				System.out.println("(g) DVD anzeigen");
				System.out.println("(h) Neue DVD");
				System.out.println("(i) DVD bearbeiten");
				System.out.println("(j) DVD löschen\n");
				// #########################################
				System.out.println("(k) alle Leihvorgänge anzeigen");
				System.out.println("(l) Leihvorgänge eines Kunden anzeigen");
				System.out.println("(m) Neuer Leihvorgang");
				System.out.println("(n) Leihvorgang bearbeiten\n");
				// #########################################
				System.out.println("(x) Ende\n\n");
				System.out.print("Bitte wählen Sie einen Menüpunkt: ");
				auswahl = Helper.readToLowerChar();

				switch (auswahl) {
				case 'a':
					alleKundenAnzeigen();
					break;
				case 'b':
					kundeAnzeigen();
					break;
				case 'c':
					neuerKunde();
					break;
				case 'd':
					kundeBearbeiten();
					break;
				case 'e':
					kundeLoeschen();
					break;
				case 'f':
					alleDvdsAnzeigen();
					break;
				case 'g':
					dvdAnzeigen();
					break;
				case 'h':
					neueDvd();
					break;
				case 'i':
					dvdBearbeiten();
					break;
				case 'j':
					dvdLoeschen();
					break;
				case 'k':
					alleLeihvorgaengeAnzeigen();
					break;
				case 'l':
					leihvorgängeEinesKundenAnzeigen();
					break;
				case 'm':
					neuerLeihvorgang();
					break;
				case 'n':
					leihvorgangBearbeiten();
					break;
				case 'x':
					break;
				default:
					korrekt = false;
					System.out
							.println("Sie haben eine ungültige Auswahl getroffen!");
					Helper.warteAufTaste();
					break;
				}
			} while (!korrekt);
		} while (auswahl != 'x');
		System.out.println("Auf wiedersehen!");
		Helper.warteAufTaste();
	}

	/**
	 * Zeigt alle DVDs an
	 */
	private void alleDvdsAnzeigen() {
		System.out.println("DVD-Übersicht\n");
		for (DVD dvd : fachkonzept.getAllDVDs()) {
			// System.out.println(dvd.getDvd_nr() + " " + dvd.getTitel() + " " +
			// dvd.getGenre() + " " + dvd.getErscheinungsjahr());
			System.out.printf("%4d %-30s %-20s %4d\n", dvd.getDvd_nr(),
					dvd.getTitel(), dvd.getGenre(), dvd.getErscheinungsjahr());
		}
		Helper.warteAufTaste();
	}

	/**
	 * Zeigt alle Kunden an
	 */
	private void alleKundenAnzeigen() {
		System.out.println("Kundenübersicht\n");
		if (fachkonzept.getAllKunden() != null) {
			for (Kunde kunde : fachkonzept.getAllKunden()) {
				// System.out.println(kunde.getKunden_nr() + " "
				// + kunde.getAnrede() + " " + kunde.getVorname() + " "
				// + kunde.getNachname() + " " + kunde.getStrasse() + " "
				// + kunde.getHausnr() + " " + kunde.getPlz() + " "
				// + kunde.getOrt());
				System.out.printf(
						"%4d %-5s %-30s %-30s %-30s %4d %-5s %-15s\n",
						kunde.getKunden_nr(), kunde.getAnrede(),
						kunde.getVorname(), kunde.getNachname(),
						kunde.getStrasse(), kunde.getHausnr(), kunde.getPlz(),
						kunde.getOrt());
			}

		} else {
			System.out.println("Es wurden keine Kunden gefunden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Zeigt einen Kunden an
	 */
	private void kundeAnzeigen() {
		System.out.println("Kunden anzeigen\n");
		int kundennummer;
		Kunde kunde;
		System.out.println("Kunden anzeigen\n");
		System.out.print("Kundennummer: ");
		kundennummer = Helper.readInt();
		kunde = fachkonzept.getKundeByID(kundennummer);
		if (kunde != null) {
			System.out.println("Anrede:       " + kunde.getAnrede());
			System.out.println("Vorname:      " + kunde.getVorname());
			System.out.println("Nachname:     " + kunde.getNachname());
			System.out.println("Straße:       " + kunde.getStrasse() + " "
					+ kunde.getHausnr());
			System.out.println("PLZ:          " + kunde.getPlz());
			System.out.println("Ort:          " + kunde.getOrt());
			System.out.println("Telefon:      " + kunde.getTelefonnr());
			// System.out.println("Geburtstag:   " + kunde.getGeburtstag());
		} else {
			System.out.println("Kunde nicht vorhanden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Fuegt einen neuen Kunden hinzu
	 */
	private void neuerKunde() {
		System.out.println("Kunde hinzufügen\n");
		String anrede;
		String vorname;
		String nachname;
		Date geburtstag = null;
		String plz;
		String ort;
		String strasse;
		int hausnummer;
		String telefon_nummer;
		SimpleDateFormat sdfGeburtstag = new SimpleDateFormat("dd.MM.yyyy");
		boolean korrekt = true;

		System.out.print("Anrede: ");
		anrede = Helper.readString();
		System.out.print("Vorname: ");
		vorname = Helper.readString();
		System.out.print("Nachname: ");
		nachname = Helper.readString();
		System.out.print("Straße: ");
		strasse = Helper.readString();
		System.out.print("Hausnummer: ");
		hausnummer = Helper.readInt();
		System.out.print("PLZ: ");
		plz = Helper.readString();
		System.out.print("Ort: ");
		ort = Helper.readString();
		do {
			korrekt = true;
			System.out.print("Geburtstag (DD.MM.YYYY): ");
			try {
				geburtstag = sdfGeburtstag.parse(Helper.readString());
			} catch (ParseException e) {
				korrekt = false;
			}
		} while (!korrekt);
		System.out.print("Telefonnummer: ");
		telefon_nummer = Helper.readString();
		fachkonzept.createKunde(new Kunde(anrede, vorname, nachname,
				new java.sql.Date(geburtstag.getTime()), plz, ort, strasse,
				hausnummer, telefon_nummer));
		System.out.println("\nKunde wurde hinzugefügt!");
		Helper.warteAufTaste();
	}

	/**
	 * Bearbeitet einen Kunden
	 */
	private void kundeBearbeiten() {
		System.out.println("Kunde bearbeiten\n");
		String anrede;
		String vorname;
		String nachname;
		Date geburtstag = null;
		String plz;
		String ort;
		String strasse;
		int hausnummer;
		String telefon_nummer;
		SimpleDateFormat sdfGeburtstag = new SimpleDateFormat("dd.MM.yyyy");
		boolean korrekt = true;
		int kundennr;
		Kunde kunde;

		System.out.print("Kundennummer: ");
		kundennr = Helper.readInt();
		kunde = fachkonzept.getKundeByID(kundennr);
		if (kunde != null) {
			System.out
			.println("Wenn keine Änderungen vorgenommen werden sollen, \"-1\" eintragen!");
			System.out.print("Anrede (" + kunde.getAnrede() + "): ");
			anrede = Helper.readString();
			System.out.print("Vorname (" + kunde.getVorname() +"): ");
			vorname = Helper.readString();
			System.out.print("Nachname (" + kunde.getNachname() + "): ");
			nachname = Helper.readString();
			System.out.print("Straße (" + kunde .getStrasse() + "): ");
			strasse = Helper.readString();
			System.out.print("Hausnummer (" + kunde.getHausnr() + "): ");
			hausnummer = Helper.readInt();
			System.out.print("PLZ (" + kunde.getPlz() + "): ");
			plz = Helper.readString();
			System.out.print("Ort (" + kunde.getOrt() + "): ");
			ort = Helper.readString();
//			do {
//				korrekt = true;
//				System.out.print("Geburtstag (DD.MM.YYYY): ");
//				String tmp = Helper.readString();
//				if (!tmp.equals("-1")) {
//					try {
//						geburtstag = sdfGeburtstag.parse(Helper.readString());
//					} catch (ParseException e) {
//						korrekt = false;
//					}
//				}
//			} while (!korrekt);
			System.out.print("Telefonnummer (" + kunde.getTelefonnr() + "): ");
			telefon_nummer = Helper.readString();

			if (!anrede.equals("-1"))
				kunde.setAnrede(anrede);
			if (!vorname.equals("-1"))
				kunde.setVorname(vorname);
			if (!nachname.equals("-1"))
				kunde.setNachname(nachname);
			if (!strasse.equals("-1"))
				kunde.setStrasse(strasse);
			if (hausnummer != -1)
				kunde.setHausnr(hausnummer);
			if (!plz.equals("-1"))
				kunde.setPlz(plz);
			if (!ort.equals("-1"))
				kunde.setOrt(ort);
			if (!telefon_nummer.equals("-1"))
				kunde.setTelefonnr(telefon_nummer);
			
			fachkonzept.updateKunde(kunde);

			System.out.println("\nKunde wurde hinzugefügt!");
		} else {
			System.out.println("Der Kunde wurde nicht gefunden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Loescht einen Kunden
	 */
	private void kundeLoeschen() {
		System.out.println("Kunde löschen\n");
		System.out.print("Kundennummer des zu löschenden Kunden: ");
		try {
			Kunde kunde = fachkonzept.getKundeByID(Helper.readInt());
			System.out.println("Möchten Sie Kunde \"" + kunde.getKunden_nr()
					+ " " + kunde.getVorname() + " " + kunde.getNachname()
					+ "\" wirklich löschen? (j/n) ");
			if (Helper.readToLowerChar() == 'j') {
				fachkonzept.deleteKunde(kunde.getKunden_nr());
				System.out.println("Der Kunde wurde gelöscht!");
			}
		} catch (NullPointerException e) {
			System.out.println("Kunde nicht vorhanden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Zeigt eine DVD an
	 */
	private void dvdAnzeigen() {
		System.out.println("DVD anzeigen\n");
		int nummer;
		DVD dvd;
		System.out.print("DVD-Nummer: ");
		nummer = Helper.readInt();
		dvd = fachkonzept.getDVDByID(nummer);
		System.out.println("DVD-Nummer: " + dvd.getDvd_nr());
		System.out.println("Titel:    " + dvd.getTitel());
		System.out.println("Genre:    " + dvd.getGenre());
		System.out.println("Jahr:     " + dvd.getErscheinungsjahr());
		Helper.warteAufTaste();
	}

	/**
	 * Fuegt eine neue DVD hinzu
	 */
	private void neueDvd() {
		System.out.println("DVD hinzufügen\n");
		String titel;
		String genre;
		int erscheinungsjahr;
		System.out.print("Titel: ");
		titel = Helper.readString();
		System.out.print("Genre: ");
		genre = Helper.readString();
		System.out.print("Jahr:  ");
		erscheinungsjahr = Helper.readInt();
		fachkonzept.createDVD(new DVD(titel, genre, erscheinungsjahr));
		System.out.println("DVD wurde hinzugefügt!");
		Helper.warteAufTaste();
	}

	/**
	 * Bearbeitet eine DVD
	 */
	private void dvdBearbeiten() {
		System.out.println("DVD bearbeiten\n");
		String titel;
		String genre;
		int erscheinungsjahr;
		int dvd_nr;
		DVD dvd;
		System.out.print("DVD-Nr.: ");
		dvd_nr = Helper.readInt();
		dvd = fachkonzept.getDVDByID(dvd_nr);
		if (dvd != null) {
			System.out
					.println("Wenn keine Änderungen vorgenommen werden sollen, \"-1\" eintragen!");
			System.out.print("Titel (" + dvd.getTitel() + "): ");
			titel = Helper.readString();
			System.out.print("Genre (" + dvd.getGenre() + "): ");
			genre = Helper.readString();
			System.out.print("Jahr (" + dvd.getErscheinungsjahr() + "): ");
			erscheinungsjahr = Helper.readInt();

			if (!titel.equals("-1"))
				dvd.setTitel(titel);
			if (!genre.equals("-1"))
				dvd.setGenre(genre);
			if (erscheinungsjahr != -1)
				dvd.setErscheinungsjahr(erscheinungsjahr);

			fachkonzept.updateDVD(dvd);
			System.out.println("DVD wurde bearbeitet!");
		} else {
			System.out.println("DVD mit der Nummer \"" + dvd_nr
					+ "\" wurde nicht gefunden!");
		}

		Helper.warteAufTaste();
	}

	/**
	 * Loescht eine DVD
	 */
	private void dvdLoeschen() {
		System.out.println("DVD löschen\n");
		System.out.print("Nummer der zu löschenden DVD: ");
		try {
			DVD dvd = fachkonzept.getDVDByID(Helper.readInt());
			System.out.println("Möchten Sie die DVD \"" + dvd.getDvd_nr() + " "
					+ dvd.getTitel() + " " + dvd.getErscheinungsjahr()
					+ "\" wirklich löschen? (j/n) ");
			if (Helper.readToLowerChar() == 'j') {
				fachkonzept.deleteDVD(dvd.getDvd_nr());
				System.out.println("Die DVD wurde gelöscht!");
			}
		} catch (NullPointerException e) {
			System.out.println("DVD nicht vorhanden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Zeigt alle Leihvorgaenge an
	 */
	private void alleLeihvorgaengeAnzeigen() {
		System.out.println("Leihvorgang-Übersicht\n");
		if (fachkonzept.getAllVerleihe() != null) {
			for (Ausleihe verleih : fachkonzept.getAllVerleihe()) {
				Kunde kunde = fachkonzept.getKundeByID(verleih.getKunden_nr());
				DVD dvd = fachkonzept.getDVDByID(verleih.getDvd_nr());
				String rueckgabe = "";
				if (verleih.getRueckgabe() != null)
					rueckgabe = Helper.getDDMMYYYDate(verleih.getRueckgabe());
				System.out
						.printf("%4d %-5s %-30s %-30s %-30s %4d %-10s %-10s\n",
								verleih.getLeihvorgangs_nr(),
								kunde.getAnrede(), kunde.getVorname(),
								kunde.getNachname(), dvd.getTitel(),
								dvd.getErscheinungsjahr(),
								Helper.getDDMMYYYDate(verleih.getAusleihe()),
								rueckgabe);
			}
		} else {
			System.out.println("Keine Ausleihen vorhanden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Zeigt alle Leihvorgaenge eines Kunden an
	 */
	private void leihvorgängeEinesKundenAnzeigen() {
		System.out.println("Leihvorgang-Übersicht\n");
		System.out.print("Kundennummer: ");
		int temp = Helper.readInt();
		try {
			for (Ausleihe verleih : fachkonzept.getKundenVerleih(temp)) {
				Kunde kunde = fachkonzept.getKundeByID(verleih.getKunden_nr());
				DVD dvd = fachkonzept.getDVDByID(verleih.getDvd_nr());
				// Nr Kunde DVD Ausleihe Rueckgabe
				System.out.println(verleih.getLeihvorgangs_nr() + " "
						+ kunde.getAnrede() + " " + kunde.getVorname() + " "
						+ kunde.getNachname() + " " + dvd.getTitel() + " "
						+ dvd.getErscheinungsjahr() + " "
						+ verleih.getAusleihe().toString() + " "
						+ verleih.getRueckgabe().toString());

			}
		} catch (NullPointerException npe) {
			System.out.println("Keine Ausleihen vorhanden!");
		}
		Helper.warteAufTaste();
	}

	/**
	 * Fuegt einen neuen Leihvorgang hinzu
	 */
	private void neuerLeihvorgang() {
		System.out.println("Leihvorgang hinzufügen\n");
		int dvd_nr;
		int kunden_nr;
		Date ausleihe = null;
		Date rueckgabe = null;
		SimpleDateFormat sdfGeburtstag = new SimpleDateFormat("dd.MM.yyyy");
		boolean korrekt;

		System.out.println("Leihvorgang hinzufügen\n");
		System.out.print("DVD-Nr.   : ");
		dvd_nr = Helper.readInt();
		DVD dvd = fachkonzept.getDVDByID(dvd_nr);
		if (dvd != null) {
			System.out.print("Kunden-Nr.: ");
			kunden_nr = Helper.readInt();
			Kunde kunde = fachkonzept.getKundeByID(kunden_nr);
			if (kunde != null) {
				do {
					korrekt = true;
					System.out.print("Ausleihe (DD.MM.YYYY): ");
					try {
						ausleihe = sdfGeburtstag.parse(Helper.readString());
					} catch (ParseException e) {
						korrekt = false;
					}
				} while (!korrekt);

				do {
					korrekt = true;
					System.out.print("Rückgabe (DD.MM.YYYY): ");
					try {
						String tmp = Helper.readString();
						if (!tmp.equals("-1"))
							rueckgabe = sdfGeburtstag
									.parse(Helper.readString());
						else
							rueckgabe = null;
					} catch (ParseException e) {
						korrekt = false;
					}
				} while (!korrekt);

				fachkonzept.createVerleih(new Ausleihe(dvd_nr, kunden_nr,
						ausleihe, rueckgabe));
				System.out.println("Ausleihe wurde hinzugefügt!");
			} else {
				System.out.println("Der Kunde wurde nicht gefunden!");
			}
		} else {
			System.out.println("Die DVD wurde nicht gefunden!");
		}

		Helper.warteAufTaste();
	}

	/**
	 * Bearbeitet einen Leihvorgang
	 */
	private void leihvorgangBearbeiten() {
		int leihvorgangsnummer;
		Ausleihe ausleihe;
		Date rueckgabe = null;
		boolean korrekt;
		SimpleDateFormat sdfGeburtstag = new SimpleDateFormat("dd.MM.yyyy");
		
		System.out.println("Leihvorgang bearbeiten\n");
		System.out.print("Leihvorgangsnummer:      ");
		leihvorgangsnummer = Helper.readInt();
		ausleihe = fachkonzept.getVerleihByID(leihvorgangsnummer);
		if(ausleihe != null){
			System.out.println("DVD-Nr:                " + ausleihe.getDvd_nr());
			System.out.println("Kundennummer:          " + ausleihe.getKunden_nr());
			System.out.println("Ausleihe (DD.MM.YYYY): " + Helper.getDDMMYYYDate(ausleihe.getAusleihe()));
			do {
				korrekt = true;
				System.out.print("Rückgabe (DD.MM.YYYY): ");
				try {
					String tmp = Helper.readString();
					if (!tmp.equals("-1"))
						rueckgabe = sdfGeburtstag
								.parse(Helper.readString());
					else
						rueckgabe = null;
				} catch (ParseException e) {
					korrekt = false;
				}
			} while (!korrekt);
			ausleihe.setRueckgabe(rueckgabe);
			fachkonzept.updateVerleih(ausleihe);
		} else {
			System.out.println("Leihvorgang wurde nicht gefunden!");
		}
	}
}
