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
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
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

	@Override
	public void initDatenhaltung() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		sqliteConnection = DriverManager.getConnection(DATABASE_PATH);
		statement = sqliteConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	
	@Override
	public void close() throws SQLException {
		statement.close();
		sqliteConnection.close();
	}
	
	@Override
	public List<Kunde> getKundenList() throws SQLException {
		List<Kunde> kundenList = new ArrayList<Kunde>();
		ResultSet resultSet = getResultSetFromTable(Table.T_KUNDE);
		while (resultSet.next()) {
			Kunde kunde = new Kunde(	resultSet.getInt(KundeFields.p_kunden_nr.name()), 
					resultSet.getString(KundeFields.anrede.name()), 
					resultSet.getString(KundeFields.vorname.name()), 
					resultSet.getString(KundeFields.nachname.name()), 
					resultSet.getDate(KundeFields.geburtstag.name()), 
					resultSet.getString(KundeFields.plz.name()), 
					resultSet.getString(KundeFields.ort.name()), 
					resultSet.getString(KundeFields.strasse.name()), 
					resultSet.getInt(KundeFields.hausnr.name()), 
					resultSet.getString(KundeFields.telefonnr.name()));
			kundenList.add(kunde);
		}
		return kundenList;
	}
	
	@Override
	public List<Kunde> addKunde(Kunde kunde) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_KUNDE.name()
								+ " ("	+ KundeFields.anrede + ", " 
										+ KundeFields.vorname + ", " 
										+ KundeFields.nachname + ", " 
										+ KundeFields.geburtstag + ", " 
										+ KundeFields.plz + ", " 
										+ KundeFields.ort + ", " 
										+ KundeFields.strasse + ", " 
										+ KundeFields.hausnr + ", " 
										+ KundeFields.telefonnr + ")"
								+ " VALUES ("	+ "'" + kunde.getAnrede() + "', "
												+ "'" + kunde.getVorname() + "', "
												+ "'" + kunde.getNachname() + "', "
												+ "'" + kunde.getGeburtstag() + "', "
												+ "'" + kunde.getPlz() + "', "
												+ "'" + kunde.getOrt() + "', "
												+ "'" + kunde.getStrasse() + "', "
													  + kunde.getHausnr() + ", "
												+ "'" + kunde.getTelefonnr() + "');");
		return getKundenList();
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Table.T_KUNDE 
				+ " WHERE " + KundeFields.p_kunden_nr + " = " + kunde.getKunden_nr());
		resultSet.updateString(KundeFields.anrede.name(), kunde.getAnrede());
		resultSet.updateString(KundeFields.vorname.name(), kunde.getVorname());
		resultSet.updateString(KundeFields.nachname.name(), kunde.getNachname());
		resultSet.updateDate(KundeFields.geburtstag.name(), kunde.getGeburtstag());
		resultSet.updateString(KundeFields.plz.name(), kunde.getPlz());
		resultSet.updateString(KundeFields.ort.name(), kunde.getOrt());
		resultSet.updateString(KundeFields.strasse.name(), kunde.getStrasse());
		resultSet.updateInt(KundeFields.hausnr.name(), kunde.getHausnr());
		resultSet.updateString(KundeFields.telefonnr.name(), kunde.getTelefonnr());
		resultSet.updateRow();
		return getKundenList();
	}

	@Override
	public List<Kunde> deleteKunde(Kunde kunde) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_KUNDE.name() 
								+ " WHERE " + KundeFields.p_kunden_nr + " = " + kunde.getKunden_nr());
		return getKundenList();
	}
	
	@Override
	public List<DVD> getDVDList() throws SQLException {
		List<DVD> dvdList = new ArrayList<DVD>();
		ResultSet resultSet = getResultSetFromTable(Table.T_DVD);
		while (resultSet.next()) {
			DVD dvd = new DVD(	resultSet.getInt(DVDFields.p_dvd_nr.name()), 
					resultSet.getString(DVDFields.titel.name()), 
					resultSet.getString(DVDFields.genre.name()), 
					resultSet.getInt(DVDFields.erscheinungsjahr.name()));
			dvdList.add(dvd);
		}
		return dvdList;
	}

	@Override
	public List<DVD> addDVD(DVD dvd) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_DVD.name()
				+ " (" 	+ DVDFields.titel + ", " 
						+ DVDFields.genre + ", " 
						+ DVDFields.erscheinungsjahr + ")"
				+ " VALUES ("	+ "'" + dvd.getTitel() + "', "
								+ "'" + dvd.getGenre() + "', "
								+ 		dvd.getErscheinungsjahr() + ");");
		return getDVDList();
	}

	@Override
	public List<DVD> updateDVD(DVD dvd) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Table.T_DVD 
				+ " WHERE " + DVDFields.p_dvd_nr + " = " + dvd.getDvd_nr());
		resultSet.updateString(DVDFields.titel.name(), dvd.getTitel());
		resultSet.updateString(DVDFields.genre.name(), dvd.getGenre());
		resultSet.updateInt(DVDFields.erscheinungsjahr.name(), dvd.getErscheinungsjahr());
		resultSet.updateRow();
		return getDVDList();
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_DVD.name() 
								+ " WHERE " + DVDFields.p_dvd_nr + " = " + dvd.getDvd_nr());
		return getDVDList();
	}

	@Override
	public List<Ausleihe> getVerleihList() throws SQLException {
		List<Ausleihe> verleihList = new ArrayList<Ausleihe>();
		ResultSet resultSet = getResultSetFromTable(Table.T_AUSLEIHE);
		while (resultSet.next()) {
			Ausleihe dvd = new Ausleihe(	resultSet.getInt(VerleihFields.p_leihvorgangs_nr.name()), 
					resultSet.getInt(VerleihFields.f_dvd_nr.name()), 
					resultSet.getInt(VerleihFields.f_kunden_nr.name()), 
					resultSet.getDate(VerleihFields.ausleihe.name()),
					resultSet.getDate(VerleihFields.rueckgabe.name()));
			verleihList.add(dvd);
		}
		return verleihList;
	}

	@Override
	public List<Ausleihe> addVerleih(Ausleihe verleih) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_AUSLEIHE
				+ " ("	+ VerleihFields.f_dvd_nr + ", " 
						+ VerleihFields.f_kunden_nr + ", " 
						+ VerleihFields.ausleihe + ", " 
						+ VerleihFields.rueckgabe + ")"
				+ " VALUES ("	+ "'" + verleih.getDvd_nr() + "', "
								+ "'" + verleih.getKunden_nr() + "', "
								+ "'" + verleih.getAusleihe() + "', "
								+ "'" + verleih.getRueckgabe() + "');");
		return getVerleihList();
	}

	@Override
	public List<Ausleihe> updateVerleih(Ausleihe verleih) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Table.T_AUSLEIHE 
				+ " WHERE " + VerleihFields.p_leihvorgangs_nr + " = " + verleih.getLeihvorgangs_nr());
		resultSet.updateInt(VerleihFields.f_dvd_nr.name(), verleih.getDvd_nr());
		resultSet.updateInt(VerleihFields.f_kunden_nr.name(), verleih.getKunden_nr());
		resultSet.updateDate(VerleihFields.ausleihe.name(), verleih.getAusleihe());
		resultSet.updateDate(VerleihFields.rueckgabe.name(), verleih.getRueckgabe());
		resultSet.updateRow();
		return getVerleihList();
	}

	@Override
	public List<Ausleihe> deleteVerleih(Ausleihe verleih) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_AUSLEIHE 
								+ " WHERE " + VerleihFields.p_leihvorgangs_nr + " = " + verleih.getLeihvorgangs_nr());
		return getVerleihList();
	}
	
	private ResultSet getResultSetFromTable(Table table) throws SQLException {
		return statement.executeQuery("SELECT * FROM " + table.name() );
	}
	
}
