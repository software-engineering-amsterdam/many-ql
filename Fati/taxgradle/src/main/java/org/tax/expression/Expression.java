package org.tax.expression;

import org.tax.datatypes.QLType;

public abstract class Expression <T extends QLType> {
	public abstract T evaluate(); 
}
