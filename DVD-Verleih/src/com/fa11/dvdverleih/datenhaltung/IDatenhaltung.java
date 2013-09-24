/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Paul Manthei
 *
 */
public interface IDatenhaltung {

	public List<Kunde> getKundenList() throws SQLException;
	
	public List<DVD> getDVDList() throws SQLException;
	
	public List<Verleih> getVerleihList() throws SQLException;
	
}
