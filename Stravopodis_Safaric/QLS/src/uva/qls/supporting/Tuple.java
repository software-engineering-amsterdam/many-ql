package uva.qls.supporting;

public class Tuple <A,B> {
	
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
}
