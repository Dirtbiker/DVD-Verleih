/**
 * 
 */
package com.fa11.dvdverleih.datenhaltung;


/**
 * @author Paul Manthei
 *
 */
public class WhereConstruct {

	private String link;
	private String field;
	private String operator;
	private String value;
	
	public WhereConstruct(String link, String field, String operator, String value) {
		this.setStringValue(value);
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStringValue() {
		return value;
	}

	public void setStringValue(String value) {
		this.value = value;
	}

}
