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
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;

/**
 * @author Paul Manthei
 *
 */
public class SQLiteDatenhaltung implements IDatenhaltung {

	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String DATABASE_PATH = "jdbc:sqlite:Datenbank" + FILE_SEPARATOR + "DVDVerleih.sqlite";
	private static final String KUNDEN_TABLE = "T_KUNDE";
	private static final String DVD_TABLE = "T_DVD";
	private static final String VERLEIH_TABLE = "T_AUSLEIHE";
	private Statement statement = null;
	private Connection sqliteConnection = null;
	
	@Override
	public List<Kunde> getKundenList() throws SQLException, ClassNotFoundException {
		openDatabase();
		ResultSet kundenResultSet = getResultSetFromTable(KUNDEN_TABLE);
		System.out.println("Size: " + kundenResultSet.getFetchSize());
		List<Kunde> kundenList = new ArrayList<Kunde>();
		while (kundenResultSet.next()) {
			Kunde kunde = new Kunde(	kundenResultSet.getInt("p_kunden_nr"), 
					kundenResultSet.getString("anrede"), 
					kundenResultSet.getString("vorname"), 
					kundenResultSet.getString("nachname"), 
					kundenResultSet.getDate("geburtstag"), 
					kundenResultSet.getString("plz"), 
					kundenResultSet.getString("ort"), 
					kundenResultSet.getString("strasse"), 
					kundenResultSet.getInt("hausnr"), 
					kundenResultSet.getString("telefonnr"));
			kundenList.add(kunde);
		}
		closeDatabase();
		return kundenList;
	}

	@Override
	public List<DVD> getDVDList() throws SQLException, ClassNotFoundException {
		openDatabase();
		ResultSet dvdResultSet = getResultSetFromTable(DVD_TABLE);
		List<DVD> dvdList = new ArrayList<DVD>();
		while (dvdResultSet.next()) {
			DVD dvd = new DVD(	dvdResultSet.getInt("p_dvd_nr"), 
					dvdResultSet.getString("titel"), 
					dvdResultSet.getString("genre"), 
					dvdResultSet.getInt("erscheinungsjahr"));
			dvdList.add(dvd);
		}
		closeDatabase();
		return dvdList;
	}
	
	@Override
	public List<Verleih> getVerleihList() throws SQLException, ClassNotFoundException {
		openDatabase();
		ResultSet verleihResultSet = getResultSetFromTable(VERLEIH_TABLE);
		List<Verleih> verleihList = new ArrayList<Verleih>();
		while (verleihResultSet.next()) {
			Verleih dvd = new Verleih(	verleihResultSet.getInt("p_leihvorgangs_nr"), 
					verleihResultSet.getInt("f_dvd_nr"), 
					verleihResultSet.getInt("f_kunden_nr"), 
					verleihResultSet.getDate("ausleihe"),
					verleihResultSet.getDate("rueckgabe"));
			verleihList.add(dvd);
		}
		closeDatabase();
		return verleihList;
	}
	
	@Override
	public List<Kunde> addKunde(Kunde kunde) throws ClassNotFoundException, SQLException {
		openDatabase();
		statement.executeUpdate("INSERT INTO " + KUNDEN_TABLE
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
		closeDatabase();
		return getKundenList();
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) throws ClassNotFoundException, SQLException {
		openDatabase();
		closeDatabase();
		return getKundenList();
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) throws ClassNotFoundException, SQLException {
		openDatabase();
		statement.executeUpdate("DELETE from " + KUNDEN_TABLE + " WHERE p_kunden_nr = " + kunde.getKunden_nr());
		closeDatabase();
		return getKundenList();
	}

	@Override
	public List<DVD> addDVD(DVD dvd) throws ClassNotFoundException, SQLException {
		openDatabase();
		statement.executeUpdate("INSERT INTO " + DVD_TABLE
				+ " (titel, genre, erscheinungsjahr)"
				+ " VALUES ("	+ "'" + dvd.getTitel() + "', "
								+ "'" + dvd.getGenre() + "', "
								+ 		dvd.getErscheinungsjahr() + ");");
		closeDatabase();
		return getDVDList();
	}

	@Override
	public List<DVD> updateDVD(DVD dvd) throws ClassNotFoundException, SQLException {
		openDatabase();
		closeDatabase();
		return getDVDList();
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) throws ClassNotFoundException, SQLException {
		openDatabase();
		statement.executeUpdate("DELETE from " + DVD_TABLE + " WHERE p_dvd_nr = " + dvd.getDvd_nr());
		closeDatabase();
		return getDVDList();
	}

	@Override
	public List<Verleih> addVerleih(Verleih verleih) throws ClassNotFoundException, SQLException {
		openDatabase();
		statement.executeUpdate("INSERT INTO " + VERLEIH_TABLE
				+ " (f_dvd_nr, f_kunden_nr, ausleihe, rueckgabe)"
				+ " VALUES ("	+ "'" + verleih.getDvd_nr() + "', "
								+ "'" + verleih.getKunden_nr() + "', "
								+ "'" + verleih.getAusleihe() + "', "
								+ "'" + verleih.getRueckgabe() + "');");
		closeDatabase();
		return getVerleihList();
	}

	@Override
	public List<Verleih> updateVerleih(Verleih verleih) throws ClassNotFoundException, SQLException {
		openDatabase();
		closeDatabase();
		return getVerleihList();
	}

	@Override
	public List<Verleih> deleteVerleih(Verleih verleih) throws ClassNotFoundException, SQLException {
		openDatabase();
		statement.executeUpdate("DELETE from " + VERLEIH_TABLE + " WHERE p_leihvorgangs_nr = " + verleih.getLeihvorgangs_nr());
		closeDatabase();
		return getVerleihList();
	}
	
	private ResultSet getResultSetFromTable(String tablename) throws SQLException{
		return statement.executeQuery("SELECT * FROM " + tablename );
	}
	
	private void openDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		sqliteConnection = DriverManager.getConnection(DATABASE_PATH);
		sqliteConnection.setAutoCommit(false);
		statement = sqliteConnection.createStatement();
	}
	
	private void closeDatabase() throws SQLException {
		statement.close();
		sqliteConnection.commit();
		sqliteConnection.close();
	}
}


