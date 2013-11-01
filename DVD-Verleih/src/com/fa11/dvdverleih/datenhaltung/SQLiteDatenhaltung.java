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

import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.DVDFields;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.KundeFields;
import com.fa11.dvdverleih.datenhaltung.tables.Table;
import com.fa11.dvdverleih.datenhaltung.tables.AusleiheFields;

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
		statement = sqliteConnection.createStatement();
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
			+ " (" 	+ KundeFields.anrede + ", " 
					+ KundeFields.vorname + ", " 
					+ KundeFields.nachname + ", " 
					+ KundeFields.geburtstag + ", " 
					+ KundeFields.plz + ", " 
					+ KundeFields.ort + ", " 
					+ KundeFields.strasse + ", " 
					+ KundeFields.hausnr + ", " 
					+ KundeFields.telefonnr + ")"
			+ " VALUES ('" 	+ kunde.getAnrede() + "', '"
							+ kunde.getVorname() + "', '"
							+ kunde.getNachname() + "', '"
							+ kunde.getGeburtstag() + "', '"
							+ kunde.getPlz() + "', '"
							+ kunde.getOrt() + "', '"
							+ kunde.getStrasse() + "', "
							+ kunde.getHausnr() + ", '"
							+ kunde.getTelefonnr() + "');");
        return getKundenList();
	}

	@Override
	public List<Kunde> updateKunde(Kunde kunde) throws SQLException {
		statement.executeUpdate("UPDATE " + Table.T_KUNDE + 
				" SET "	+ KundeFields.anrede + "='" + kunde.getAnrede() + "',"
						+ KundeFields.vorname + "='" + kunde.getVorname() + "',"
						+ KundeFields.nachname + "='" + kunde.getNachname() + "',"
						+ KundeFields.geburtstag + "='" + kunde.getGeburtstag() + "',"
						+ KundeFields.plz + "='" + kunde.getPlz() + "',"
						+ KundeFields.ort + "='" + kunde.getOrt() + "',"
						+ KundeFields.strasse + "='" + kunde.getStrasse() + "',"
						+ KundeFields.hausnr + "=" + kunde.getHausnr() + ","
						+ KundeFields.telefonnr + "='" + kunde.getTelefonnr() + "' " + 
				"WHERE " + KundeFields.p_kunden_nr + "=" + kunde.getKunden_nr() + ";");
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
				+ " ("	+ DVDFields.titel + ", " 
						+ DVDFields.genre + ", " 
						+ DVDFields.erscheinungsjahr + ")"
				+ " VALUES ('"	+ dvd.getTitel() + "', '"
								+ dvd.getGenre() + "', "
								+ dvd.getErscheinungsjahr() + ");");
        return getDVDList();
	}

	@Override
	public List<DVD> updateDVD(DVD dvd) throws SQLException {
		statement.executeUpdate("UPDATE " + Table.T_DVD + 
				" SET "	+ DVDFields.titel + "='" + dvd.getTitel() + "', "
						+ DVDFields.genre + "='" + dvd.getGenre() + "', "
						+ DVDFields.erscheinungsjahr + "=" + dvd.getErscheinungsjahr() + 
				" WHERE " + DVDFields.p_dvd_nr + "=" + dvd.getDvd_nr() + ";");
		return getDVDList();
	}

	@Override
	public List<DVD> deleteDVD(DVD dvd) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_DVD.name() 
								+ " WHERE " + DVDFields.p_dvd_nr + " = " + dvd.getDvd_nr());
		return getDVDList();
	}

	@Override
	public List<Ausleihe> getAusleiheList() throws SQLException {
		List<Ausleihe> ausleiheList = new ArrayList<Ausleihe>();
		ResultSet resultSet = getResultSetFromTable(Table.T_AUSLEIHE);
		while (resultSet.next()) {
			Ausleihe dvd = new Ausleihe(	resultSet.getInt(AusleiheFields.p_leihvorgangs_nr.name()), 
					resultSet.getInt(AusleiheFields.f_dvd_nr.name()), 
					resultSet.getInt(AusleiheFields.f_kunden_nr.name()), 
					resultSet.getDate(AusleiheFields.ausleihe.name()),
					resultSet.getDate(AusleiheFields.rueckgabe.name()));
			ausleiheList.add(dvd);
		}
		return ausleiheList;
	}

	@Override
	public List<Ausleihe> addAusleihe(Ausleihe ausleihe) throws SQLException {
		statement.executeUpdate("INSERT INTO " + Table.T_AUSLEIHE 
				+ " (" 	+ AusleiheFields.f_dvd_nr + ", " 
						+ AusleiheFields.f_kunden_nr + ", " 
						+ AusleiheFields.ausleihe + ", " 
						+ AusleiheFields.rueckgabe + ")"
				+ " VALUES ('" 	+ ausleihe.getDvd_nr() + "', '"
								+ ausleihe.getKunden_nr() + "', '"
								+ ausleihe.getAusleihe() + "', '"
								+ ausleihe.getRueckgabe() + "');");
		return getAusleiheList();
	}

	@Override
	public List<Ausleihe> updateAusleihe(Ausleihe ausleihe) throws SQLException {
		statement.executeUpdate("UPDATE " + Table.T_AUSLEIHE + 
				" SET "	+ AusleiheFields.f_dvd_nr + "=" + ausleihe.getDvd_nr() + ","
						+ AusleiheFields.f_kunden_nr + "=" + ausleihe.getKunden_nr() + ","
						+ AusleiheFields.ausleihe + "='" + ausleihe.getAusleihe() + ","
						+ AusleiheFields.rueckgabe + "='" + ausleihe.getRueckgabe() + "'" + 
				" WHERE " + DVDFields.p_dvd_nr + "=" + ausleihe.getLeihvorgangs_nr() + ";");
		return getAusleiheList();
	}

	@Override
	public List<Ausleihe> deleteAusleihe(Ausleihe ausleihe) throws SQLException {
		statement.executeUpdate("DELETE from " + Table.T_AUSLEIHE 
								+ " WHERE " + AusleiheFields.p_leihvorgangs_nr + " = " + ausleihe.getLeihvorgangs_nr());
		return getAusleiheList();
	}
	
	private ResultSet getResultSetFromTable(Table table) throws SQLException {
		return statement.executeQuery("SELECT * FROM " + table.name() );
	}
	
}
