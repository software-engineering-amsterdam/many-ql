package uva.qls.supporting;

import uva.qls.ast.value.GenericValue;

public class Tuple <A,B> extends GenericValue<Object>{
	
	public A k;
	public B l;
	
	public Tuple(A _k, B _l){
		this.k=_k;
		this.l=_l;
		
	}
	public Tuple<A,B> getTuple(){
		return this;
	}
	
	public String toString(){
		return this.k+" "+this.l;
	}
	
	@Override
	public Object getValue() {
		return this;
	}
	
	@Override
	public int intValue() {
		return 0;
	}
}
