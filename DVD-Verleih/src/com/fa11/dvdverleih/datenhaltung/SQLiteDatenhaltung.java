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
	private static final String KUNDEN_TABLE = "T_KUNDEN";
	private static final String DVD_TABLE = "T_DVD";
	private static final String VERLEIH_TABLE = "T_VERLEIH";
	private Statement statement = null;
	private Connection sqliteConnection = null;
	
	public SQLiteDatenhaltung() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		sqliteConnection = DriverManager.getConnection(DATABASE_PATH);
		sqliteConnection.setAutoCommit(false);
		statement = sqliteConnection.createStatement();
	}

	@Override
	public Kunde getKunde(int kunden_nr) {
		
		return null;
	}
	
	@Override
	public List<Kunde> getKundenList() throws SQLException {
		Construct construct = new Construct(null, KUNDEN_TABLE, null);
		ResultSet kundenResultSet = getResultSetFromTable(construct);
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
		closeDatabase();
		return kundenList;
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> insertKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> insertKunde(List<Kunde> kundeList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> deleteKunde(List<Kunde> kundeList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DVD getDVD(int dvd_nr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> getDVDList() throws SQLException {
		Construct construct = new Construct(null, DVD_TABLE, null);
		ResultSet dvdResultSet = getResultSetFromTable(construct);
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
	public List<DVD> updateDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> insertDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> insertDVD(List<DVD> dvdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> deleteDVD(List<DVD> dvdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verleih getVerleih(int verleih_nr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> getVerleihList() throws SQLException {
		Construct construct = new Construct(null, VERLEIH_TABLE, null); 
		ResultSet verleihResultSet = getResultSetFromTable(construct);
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
	public List<Verleih> updateVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> insertVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> insertVerleih(List<Verleih> verleihList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> deleteVerleih(Verleih verleih) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verleih> deleteVerleih(List<Verleih> verleihList) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResultSet getResultSetFromTable(Construct construct) throws SQLException{
		String whatPart = "";
		String wherePart = "";
		boolean firstWhereConstruct = true;
		for (String what : construct.getWhat()) {
			whatPart += ", " + what;
		}
		for (WhereConstruct where : construct.getWhere()) {
			if (firstWhereConstruct) {
				wherePart += " WHERE " + where.getField() + where.getOperator() ;
			}
		}
		return statement.executeQuery("SELECT " + whatPart + " FROM " + construct.getTableName() + wherePart );
	}

	public void closeDatabase() throws SQLException {
		sqliteConnection.close();
		statement.close();
	}
	
}

