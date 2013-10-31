/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.DVDFields;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.KundeFields;
import com.fa11.dvdverleih.datenhaltung.tables.Table;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;
import com.fa11.dvdverleih.datenhaltung.tables.VerleihFields;

/**
 * @author Paul Manthei
 *
 */
public class SQLiteDatenhaltung implements IDatenhaltung {

	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String DATABASE_PATH = "jdbc:sqlite:Datenbank" + FILE_SEPARATOR + "DVDVerleih.sqlite";
	private Statement statement = null;
	private Connection sqliteConnection = null;
	private ResultSet kundenResultSet = null;
	private ResultSet dvdResultSet = null;
	private ResultSet ausleiheResultSet = null;

	@Override
	public void initDatenhaltung() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		sqliteConnection = DriverManager.getConnection(DATABASE_PATH);
		statement = sqliteConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		kundenResultSet = statement.executeQuery("SELECT * FROM " + Table.T_KUNDE.name() );
		dvdResultSet = statement.executeQuery("SELECT * FROM " + Table.T_DVD.name() );
		ausleiheResultSet = statement.executeQuery("SELECT * FROM " + Table.T_AUSLEIHE.name() );
	}
	
	@Override
	public void close() throws SQLException {
		statement.close();
		sqliteConnection.close();
	}
	
	@Override
	public List<Kunde> getKundenList() throws SQLException {
		List<Kunde> kundenList = new ArrayList<Kunde>();
		while (kundenResultSet.next()) {
			Kunde kunde = new Kunde(	kundenResultSet.getInt(KundeFields.p_kunden_nr.name()), 
					kundenResultSet.getString(KundeFields.anrede.name()), 
					kundenResultSet.getString(KundeFields.vorname.name()), 
					kundenResultSet.getString(KundeFields.nachname.name()), 
					kundenResultSet.getDate(KundeFields.geburtstag.name()), 
					kundenResultSet.getString(KundeFields.plz.name()), 
					kundenResultSet.getString(KundeFields.ort.name()), 
					kundenResultSet.getString(KundeFields.strasse.name()), 
					kundenResultSet.getInt(KundeFields.hausnr.name()), 
					kundenResultSet.getString(KundeFields.telefonnr.name()));
			kundenList.add(kunde);
		}
		return kundenList;
	}
	
	@Override
	public List<Kunde> addKunde(Kunde kunde) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_KUNDE.name()
								+ " (anrede, vorname, nachname, geburtstag, plz, ort, strasse, hausnr, telefonnr)"
								+ " VALUES ("	+ "'" + kunde.getAnrede() + "', "
												+ "'" + kunde.getVorname() + "', "
												+ "'" + kunde.getNachname() + "', "
												+ "'" + kunde.getGeburtstag() + "', "
												+ "'" + kunde.getPlz() + "', "
												+ "'" + kunde.getOrt() + "', "
												+ "'" + kunde.getStrasse() + "', "
													  + kunde.getHausnummer() + ", "
												+ "'" + kunde.getTelefon_nummer() + "');");
		return getKundenList();
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde, List<KundeFields> fields) throws SQLException {
		for (KundeFields kundeFields : fields) {
			switch (kundeFields) {
			case p_kunden_nr: 
			case hausnr:
				break;
			
			case geburtstag:
				break;
				
			case anrede:
			case vorname:
			case nachname:
			case plz:
			case ort:
			case strasse:
			case telefonnr:
				break;
			
			default:
				break;
			}
		}
		return getKundenList();
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_KUNDE.name() + " WHERE p_kunden_nr = " + kunde.getKunden_nr());
		return getKundenList();
	}
	
	@Override
	public List<DVD> getDVDList() throws SQLException {
		List<DVD> dvdList = new ArrayList<DVD>();
		while (dvdResultSet.next()) {
			DVD dvd = new DVD(	dvdResultSet.getInt(DVDFields.p_dvd_nr.name()), 
					dvdResultSet.getString(DVDFields.titel.name()), 
					dvdResultSet.getString(DVDFields.genre.name()), 
					dvdResultSet.getInt(DVDFields.erscheinungsjahr.name()));
			dvdList.add(dvd);
		}
		return dvdList;
	}

	@Override
	public List<DVD> addDVD(DVD dvd) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_DVD.name()
				+ " (titel, genre, erscheinungsjahr)"
				+ " VALUES ("	+ "'" + dvd.getTitel() + "', "
								+ "'" + dvd.getGenre() + "', "
								+ 		dvd.getErscheinungsjahr() + ");");
		return getDVDList();
	}

	@Override
	public List<DVD> updateDVD(DVD dvd, List<DVDFields> fields) throws SQLException {
		for (DVDFields dvdFields : fields) {
			switch (dvdFields) {
			
			case p_dvd_nr: 
			case erscheinungsjahr:
				break;
			
			case titel: 
			case genre:
				break;
			
			default:
				break;
			}
		}
		return getDVDList();
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_DVD.name() + " WHERE p_dvd_nr = " + dvd.getDvd_nr());
		return getDVDList();
	}

	@Override
	public List<Verleih> getVerleihList() throws SQLException {
		List<Verleih> verleihList = new ArrayList<Verleih>();
		while (ausleiheResultSet.next()) {
			Verleih dvd = new Verleih(	ausleiheResultSet.getInt(VerleihFields.p_leihvorgangs_nr.name()), 
					ausleiheResultSet.getInt(VerleihFields.f_dvd_nr.name()), 
					ausleiheResultSet.getInt(VerleihFields.f_kunden_nr.name()), 
					ausleiheResultSet.getDate(VerleihFields.ausleihe.name()),
					ausleiheResultSet.getDate(VerleihFields.rueckgabe.name()));
			verleihList.add(dvd);
		}
		return verleihList;
	}

	@Override
	public List<Verleih> addVerleih(Verleih verleih) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_AUSLEIHE
				+ " (f_dvd_nr, f_kunden_nr, ausleihe, rueckgabe)"
				+ " VALUES ("	+ "'" + verleih.getDvd_nr() + "', "
								+ "'" + verleih.getKunden_nr() + "', "
								+ "'" + verleih.getAusleihe() + "', "
								+ "'" + verleih.getRueckgabe() + "');");
		return getVerleihList();
	}

	@Override
	public List<Verleih> updateVerleih(Verleih verleih, List<VerleihFields> fields) throws SQLException {
		for (VerleihFields verleihFields : fields) {
			switch (verleihFields) {
			
			case p_leihvorgangs_nr: 
			case f_dvd_nr: 
			case f_kunden_nr:
				break;
			
			case ausleihe: 
			case rueckgabe:
				break;
			
			default:
				break;
			}
		}
		return getVerleihList();
	}

	@Override
	public List<Verleih> deleteVerleih(Verleih verleih) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_AUSLEIHE + " WHERE p_leihvorgangs_nr = " + verleih.getLeihvorgangs_nr());
		return getVerleihList();
	}
	
}



