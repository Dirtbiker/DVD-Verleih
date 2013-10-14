/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;

import java.util.List;

/**
 * @author Paul Manthei
 *
 */
public class Construct {

	private List<String> what;
	private String tableName;
	private List<WhereConstruct> where;
	
	public Construct(List<String> what, String tableName, List<WhereConstruct> where) {
		this.setWhat(what);
		this.setTableName(tableName);
		this.setWhere(where);
	}

	public List<String> getWhat() {
		return what;
	}

	public void setWhat(List<String> what) {
		this.what = what;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<WhereConstruct> getWhere() {
		return where;
	}

	public void setWhere(List<WhereConstruct> where) {
		this.where = where;
	}
	
}
