package org.tax.datatypes;

import java.util.Date;

public class QLDate extends QLType {
	Date value;
	

	public QLDate(Date value) {
		this.value = value;
	}
	
	public Date getValue() { return value; }

}
