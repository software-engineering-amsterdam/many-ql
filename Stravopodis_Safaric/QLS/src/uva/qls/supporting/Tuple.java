package uva.qls.supporting;

import uva.qls.ast.value.GenericValue;

public class Tuple <X,Y> extends GenericValue<Object>{
	
	private X k;
	private Y l;
	
	public Tuple(X _k, Y _l){
		this.k=_k;
		this.l=_l;
		
	}
	public Tuple<X,Y> getTuple(){
		return this;
	}
	
	public String toString(){
		return this.k+" "+this.l;
	}
	
	public X getX(){
		return this.k;
	}
	
	public Y getY(){
		return this.l;
	}
	
	@Override
	public Object getValue() {
		return this;
	}
	
}
