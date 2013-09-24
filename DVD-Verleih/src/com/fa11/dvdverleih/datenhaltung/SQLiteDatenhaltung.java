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

/**
 * @author Paul Manthei
 *
 */
public class SQLiteDatenhaltung implements IDatenhaltung {

	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String DATABASE_PATH = "jdbc:sqlite:Datenbank" + FILE_SEPARATOR + "DVDVerleih.sqlite";
	private static final String KUNDEN_TABLE = "T_KUNDEN";
	private static final String DVD_TABLE = "T_DVD";
	private static final String VERLEIH_TABLE = "T_VERLEIH";
	private Statement statement = null;
	
	
	public SQLiteDatenhaltung() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection sqliteConnection = DriverManager.getConnection(DATABASE_PATH);
		sqliteConnection.setAutoCommit(false);
		statement = sqliteConnection.createStatement();
	}
	
	@Override
	public List<Kunde> getKundenList() throws SQLException {
		ResultSet kundenResultSet = getResultSetFromTable(KUNDEN_TABLE);
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
										kundenResultSet.getInt("hausnummer"), 
										kundenResultSet.getString("telefon_nummer"));
			kundenList.add(kunde);
		}
		return kundenList;
	}

	@Override
	public List<DVD> getDVDList() throws SQLException {
		ResultSet dvdResultSet = getResultSetFromTable(DVD_TABLE);
		List<DVD> dvdList = new ArrayList<DVD>();
		while (dvdResultSet.next()) {
			DVD dvd = new DVD(	dvdResultSet.getInt("p_dvd_nr"), 
								dvdResultSet.getString("titel"), 
								dvdResultSet.getString("genre"), 
								dvdResultSet.getInt("erscheinungsjahr"));
			dvdList.add(dvd);
		}
		return dvdList;
	}

	@Override
	public List<Verleih> getVerleihList() throws SQLException {
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
		return verleihList;
	}

	private ResultSet getResultSetFromTable(String table) throws SQLException{
		return statement.executeQuery("SELECT * FROM " + table);
	}
	
}
