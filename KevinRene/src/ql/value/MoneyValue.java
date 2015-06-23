package ql.value;

import ql.ast.QLType;
import ql.ast.type.QLMoney;


public class MoneyValue extends FloatValue {
	public MoneyValue(Float value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLMoney();
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MoneyValue) {
			return getPrimitive().equals(((MoneyValue) obj).getPrimitive());
		}
		
		return false;
	}
}
